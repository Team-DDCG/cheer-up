import time
from flask import Flask
from flask import request, jsonify
from flask_cors import CORS

import openai
import cx_Oracle
import dbconn
from mailmerge import MailMerge

app = Flask(__name__)
CORS(app)

from pathlib import Path
import os, json

BASE_DIR = os.getcwd()

secret_file = os.path.join(BASE_DIR, 'secrets.json') # secrets.json 파일 위치를 명시

with open(secret_file) as f:
    secrets = json.loads(f.read())

def get_secret(setting, secrets=secrets):
    try:
        return secrets[setting]
    except KeyError:
        error_msg = "Set the {} environment variable".format(setting)
        print(error_msg)

        
# SECURITY WARNING: keep the secret key used in production secret!
SECRET_KEY = get_secret("SECRET_KEY")
ORGANIZATION = get_secret("ORGANIZATION")

# set api key
openai.organization = SECRET_KEY
openai.api_key = ORGANIZATION

# ==================================================================================================

# 이력사항 DB에서 가져오는 method
@app.route("/test_career_table_select")
def career_table_select(seeker_id):

    conn = dbconn.db_connect()

    career_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"], ["user_skill_info"]]
    total_table = []
    table_index = 0

    cursor = conn.cursor()

    for table_name in career_table :
        print(table_name[0])
        
        sql = "SELECT * FROM " + table_name[0] + " WHERE seeker_id = " + str(seeker_id)
        cursor.execute(sql)
        rows = cursor.fetchall()                  

        for row in rows :
            career_table[table_index].append(', '.join(map(str, row)))

        career_table[table_index].pop(0)
        table_str = ""
        for st in career_table[table_index] :
             table_str += (st + ", ")

        total_table.append(table_str)
        table_index += 1

    print(total_table)
    cursor.close()
    conn.close()
    return total_table


# ==================================================================================================


# 기업 자소서 문항 정보 DB에서 가져오는 method
@app.route("/test_company_table_select")
def company_table_select(company_id):

    conn = dbconn.db_connect()

    company_table = []   
    table_index = 0

    cursor = conn.cursor()
        
    sql = "SELECT * FROM question WHERE company_id = " + str(company_id)
    cursor.execute(sql)
    rows = cursor.fetchall() 

    for row in rows :
        company_table.append(list(row))
        table_index += 1

    cursor.close()
    conn.close()
    return company_table



@app.route("/resume_create/<seeker_id>/<company_id>/<company_name>")
def resumeCreate(seeker_id, company_id, company_name):
    
    total_table = career_table_select(seeker_id)
    # company_value[0~3] = 순서 : question_id,  position, question, length
    company_table = company_table_select(company_id)

    for company_value in company_table :

        # 직무, 자소서 질문, 자소서 최대 길이
        position = company_value[1]
        resume_question = company_value[2]
        question_text_max = company_value[3]

        # Call the chat GPT API 
        completion = openai.ChatCompletion.create(
            model="gpt-4",
            messages=[
            {"role": "system", "content": ("너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 "
                                        "기업 자기소개서 질문과 지원 직무에 맞추어 기업에 제출할 자기소개서를 작성해주는 AI야")},

            {"role": "assistant", "content": ("자기소개서를 작성하는데 유의할 점이 있나요?")},
            {"role": "user", "content": ("인삿말(감사합니다, 안녕하세요)과 이름 소개는 쓰지말고, 두괄식으로 작성해줘"
                                        "그리고 내가 제공해주는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 중 없는 것이 있다면 참고하지 말아줘 ")},

            {"role": "assistant", "content": ("인삿말과 이름 소개를 쓰지 않도록 하겠습니다. 더 유의할 점이 있나요?")},
            {"role": "user", "content": ("내가 제공하는 정보를 너무 다양하고 얕게 작성하지말고 1~2개 정도의 정보를 기반으로 구체적으로 자기소개서를 작성해줘")},

            {"role": "assistant", "content": ("자기소개서를 작성하기 위해 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주시고, "
                                              "기업명과 지원 직무, 자기소개서 질문, 자기소개서 최대 글자수를 알려주세요.")},
                                            
            {"role": "user", "content":f"1. 경력 : {total_table[0]}\n"},
            {"role": "user", "content":f"2. 프로젝트 경험 : {total_table[1]}\n"},
            {"role": "user", "content":f"3. 수상 경험 : {total_table[2]}\n"},
            {"role": "user", "content":f"4. 대외활동 경험 : {total_table[3]}\n"},
            {"role": "user", "content":f"5. 해외 경험 : {total_table[4]}\n"},
            {"role": "user", "content":f"6. 보유한 자격증 : {total_table[5]}\n"},
            {"role": "user", "content":f"7. 보유 스킬 정보 : {total_table[6]}\n"},
            {"role": "user", "content":f"지원할 기업의 기업명 : {company_name}\n"},
            {"role": "user", "content":f"지원 직무 : {position}\n"},
            {"role": "user", "content":f"자기소개서 질문 : {resume_question}\n"},
            {"role": "user", "content":f"자기소개서 최대 글자수 : {question_text_max}"},
            
            {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 "
                                             f"{company_name} {position} 직무의 자기소개서를 작성해드리도록 하겠습니다."},
            {"role": "user", "content":f"자기소개서 내용에 인삿말(감사합니다, 안녕하세요)과 이름 소개가 들어갔다면 그 부분은 삭제해줘"},

            {"role": "assistant", "content": ("감사합니다, 안녕하세요와 같은 인삿말이 작성되어 있는 부분은 삭제하겠습니다. 작성된 자기소개서에 추가할 부분이 있나요?")},
            {"role": "user", "content": ("제일 첫 번째 줄에는 []안에 작성된 자기소개서 내용의 제목을 간략하게 작성해줘")},
            ],
            repetition_penalty=1.2,
            temperature=0.8,
            max_tokens=2048
        )

        time.sleep(30)    
        
        print(resume_question)
        
        message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
        
        conn = dbconn.db_connect()
        cursor = conn.cursor()
        sql = "INSERT INTO resume VALUES(resume_seq.nextval, :content, 0, :seeker_id, :company_id, SYSDATE)"
        cursor.execute(sql, {'content': message_result, 
                            'seeker_id': seeker_id, 
                            'company_id': company_id})
        conn.commit()
        cursor.close()
        conn.close()

    # return 'good'
    return jsonify({"result": message_result})


# ==================================================================================================


# 회원 이력정보 작성 후 유료회원 일 경우 또는 유료회원 가입 후 나의 성향 그래프 생성하는 것을 목표.
# === myCharacteristic() 기능은 회원 정보 가져오고 gpt통해 회원 성향 다섯가지를 DB에 저장하는 기능
@app.route("/my_characteristic/<seeker_id>")
def myCharacteristic(seeker_id):

    total_table = career_table_select(seeker_id)
    completion = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content" : "너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 성향을 나타내주는 AI야 "},

            {"role": "system", "content" : "성향은 책임의식, 도전정신, 소통․협력, 창의성, 원칙신뢰, 전문성, 열정, 글로벌역량, 실행력, 사회공헌 10개 중 5개를 뽑고 비율을 나타내줘"},

            {"role": "assistant", "content" : "성향과 비율을 나타낼 때 맞춰야할 양식이 있나요?"},
            {"role": "user", "content": "'뽑은성향1: 비율1/뽑은성향2: 비율2/뽑은성향3: 비율3/뽑은성향4: 비율4/뽑은성향5: 비율5'의 형태로만 나타내줘"},
            {"role": "assistant", "content": " 뽑은성향1: 비율1/의 형태로 나타내겠습니다. 뽑은성향1에 대한 비율은 비율1이 맞나요?"},
            {"role": "user", "content": " 맞아. 즉, 뽑은성향1: 비율1을 전문성: 40과 같이 각각에 단어를 대입한 양식으로 나타내줘"},

            {"role": "assistant", "content" : "성향과 비율을 나타낼 때 유의할 점이 있나요?"},
            {"role": "user", "content" : "기입이 되지않은 정보의 경우 무시하고 기입된 것 위주로만 판단해줘"},
            {"role": "user", "content" : " 부가적인 말이나 다른 말은 다 제외하고 내가 제시해준 양식에만 맞추어서 답변해줘"},

            {"role": "assistant", "content": "경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주세요."},

            {"role": "user", "content":f"1. 경력 : {total_table[0]}\n"},
            {"role": "user", "content":f"2. 프로젝트 경험 : {total_table[1]}\n"},
            {"role": "user", "content":f"3. 수상 경험 : {total_table[2]}\n"},
            {"role": "user", "content":f"4. 대외활동 경험 : {total_table[3]}\n"},
            {"role": "user", "content":f"5. 해외 경험 : {total_table[4]}\n"},
            {"role": "user", "content":f"6. 보유한 자격증 : {total_table[5]}\n"},
            {"role": "user", "content":f"7. 보유 스킬 정보 : {total_table[6]}\n"},

            {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 성향과 비율을 나타내드리겠습니다."},           
        ],
        temperature=0.7,
        max_tokens=2048
    )

    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    print(message_result)

    tmp_text = message_result.split('/')

    arr = []
    for tmp in tmp_text :
        arr.append(tmp.split(': '))

    print(arr)

    for tmp in arr :
        arr[arr.index(tmp)][1] = int(tmp[1])

    print(arr)

    # DB insert
    conn = dbconn.db_connect()
    cursor = conn.cursor()

    sql = ("INSERT INTO seeker_fit VALUES"
           "(seeker_fit_seq.nextval, :TENDENCY1, :TENDENCY2, :TENDENCY3,"
           ":TENDENCY4, :TENDENCY5,"
           ":RATE1, :RATE2, :RATE3, :RATE4, :RATE5, :seeker_id)")
    
    cursor.execute(sql, {'TENDENCY1': arr[0][0],
                         'TENDENCY2': arr[1][0],
                         'TENDENCY3': arr[2][0],
                         'TENDENCY4': arr[3][0],
                         'TENDENCY5': arr[4][0],
                         'RATE1': arr[0][1],
                         'RATE2': arr[1][1],
                         'RATE3': arr[2][1],
                         'RATE4': arr[3][1],
                         'RATE5': arr[4][1],
                         'seeker_id': seeker_id})
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({"result": message_result})


# ==================================================================================================


# 회사의 인재상과 프로젝트 경험 기반으로 인재상 적합도 나타내기
@app.route("/goodness_of_fit/<seeker_id>/<company_name>")
def goodnessOfFit(seeker_id, company_name):

    total_table = career_table_select(seeker_id)

    completion = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content" : (f"너는 {company_name}의 인재상 단어 5개를 뽑고, "
                                            f"내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 {company_name}의 인재상과의 적합도 비율을 나타내주는 AI야")},

            {"role": "assistant", "content" : "인재상과의 적합도 비율을 나타낼 때 맞춰야할 양식이 있나요?"},
            {"role": "user", "content" : "'뽑은인재상 명1: 적합도 비율1/뽑은인재상 명2: 적합도 비율2/뽑은인재상 명3: 적합도 비율3/뽑은인재상 명4: 비율4/뽑은인재상 명5: 적합도 비율5'의 형태로만 나타내줘 "},
            {"role": "user", "content" : " 뽑은인재상 명1에 대한 비율은 적합도 비율1이야 "},
            {"role": "user", "content" : "뽑은인재상 명1: 적합도 비율1을 '전문성': 40과 같이 각각에 단어를 대입한 양식으로 나타내줘, '/'으로 구분 주어줄 때 공백이 없어야해"},

            {"role": "assistant", "content" : "성향과 비율을 나타낼 때 유의할 점이 있나요?"},
            {"role": "user", "content": "기입이 되지않은 정보의 경우 무시하고 기입된 것 위주로만 판단해줘"},
            {"role": "user", "content" : " 부가적인 말이나 다른 말은 다 제외하고 내가 제시해준 양식에만 맞추어서 답변해줘"},

            {"role": "assistant", "content": "경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주세요."},

            {"role": "user", "content":f"1. 경력 : {total_table[0]}\n"},
            {"role": "user", "content":f"2. 프로젝트 경험 : {total_table[1]}\n"},
            {"role": "user", "content":f"3. 수상 경험 : {total_table[2]}\n"},
            {"role": "user", "content":f"4. 대외활동 경험 : {total_table[3]}\n"},
            {"role": "user", "content":f"5. 해외 경험 : {total_table[4]}\n"},
            {"role": "user", "content":f"6. 보유한 자격증 : {total_table[5]}\n"},
            {"role": "user", "content":f"7. 보유 스킬 정보 : {total_table[6]}\n"},

            {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 {company_name}의 인재상 5개와 그에 따른 비율을 나타내드리겠습니다."},     

        ],
        temperature=0.7,
        max_tokens=2048
    )

    # GPT 답변 결과
    # 양식을 "인재상1: 적합도 비율1/인재상2: 적합도 비율2/..." 로 맞추어 놓음
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    print(message_result)

    # '/' 기준으로 나누어 "인재상1: 적합도 비율1"로 각각 나누어 tmp_text 배열에 string으로 저장 
    tmp_text = message_result.split('/')

    # ': ' 기준으로 나누어 ['인재상1', '적합도 비율1']로 arr 배열에 차례대로 저장 ( 2차원 배열 )
    arr = []
    for tmp in tmp_text :
        arr.append(tmp.split(': '))

    # 적합도 비율은 int 값이여야 하므로 str -> int로 변환
    for tmp in arr :
        arr[arr.index(tmp)][1] = int(tmp[1])

    # DB 접속 및 저장, close
    conn = dbconn.db_connect()
    cursor = conn.cursor()
    
    sql = ("INSERT INTO company_fit VALUES"
           "(company_fit_seq.nextval, :company_name, :company_needs1, :company_needs2,"
           ":company_needs3, :company_needs4, :company_needs5,"
           ":company_rate1, :company_rate2, :company_rate3, :company_rate4,"
           ":company_rate5, :seeker_id)")
    
    cursor.execute(sql, {'company_name': company_name,
                         'company_needs1': arr[0][0],
                         'company_needs2': arr[1][0],
                         'company_needs3': arr[2][0],
                         'company_needs4': arr[3][0],
                         'company_needs5': arr[4][0],
                         'company_rate1': arr[0][1],
                         'company_rate2': arr[1][1],
                         'company_rate3': arr[2][1],
                         'company_rate4': arr[3][1],
                         'company_rate5': arr[4][1],
                         'seeker_id': seeker_id})
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({"result": message_result})

@app.route("/make_portfolio/<seeker_id>")
def makePortfolio(seeker_id):
    document = MailMerge('./real_kb/portfolio_1.docx')
    # 문서의 병합필드 확인
    print(document.get_merge_fields())

    # 직접 이름과 생년월일의 값을 채워보자
    document.merge(
        ################## 기본 인적 사항##############################################################
        user_name='',
        birthdate='',
        sex='',
        address='',
        phone='',
        email='',

        # userd_seeker
        ename='',
        cname='',
        nation_origin='',
        military='',
        bohun='',
        disabled='',

        ##################language#########################################################################
        language='',
        lang_grade='',
        lang_type='',
        lang_acquired_date='',
        lang_license_number='',
        lang_agency='',

        ##################skill#########################################################################
        skill_name='',
        skill_grade='',

        ##################licence#########################################################################
        license_name='',
        license_acquired_date='',
        license_license_number='',
        license_agency='',

        ##################school#########################################################################
        education_type='',
        highest_check='',
        school_name='',
        entrance_date='',
        graduation_date='',
        attending_check='',

        major='',
        gpa='',
        transfer_check='',

        ##################career#########################################################################
        company_name='',
        career_start_date='',
        career_end_date='',
        career_attending_check='',
        department='',
        position='',
        hire_type='',

        ##################project#########################################################################
        project_name='',
        host_name='',
        institution='',
        project_skill='',
        project_content='',

        ##################Activation#########################################################################
        activation_name='',
        act_start_date='',
        act_end_date='',
        activation_content='',

        ##################Rewards#########################################################################
        rewards_name='',
        rewards_acquired_date='',
        rewards_host='',

        ##################Overseas#########################################################################
        oversea_purpose='',
        ovesea_institution='',
        nation='',
        oversea_start_date='',
        oversea_end_date='',
        oversea_reason=''
    )

    # 필드 병합된 결과의 수료증을 직접 생성...파일명도 필드명을 참고해서
    document.write('./real_kb/수료증_tem_test.docx')




if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)