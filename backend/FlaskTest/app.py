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
        # print(table_name[0])
        
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

    print(total_table[0])
    cursor.close()
    conn.close()
    return total_table


# ==================================================================================================


# 기업 자소서 문항 정보 DB에서 가져오는 method
@app.route("/test_company_table_select")
def company_table_select(company_id, position):

    conn = dbconn.db_connect()

    company_table = []   
    table_index = 0

    cursor = conn.cursor()
        
    sql = "SELECT question_id, position, question, length FROM question WHERE company_id = " + str(company_id) + " AND position = '" + str(position) +"'"
    cursor.execute(sql)
    rows = cursor.fetchall() 

    for row in rows :
        company_table.append(list(row))
        table_index += 1

    cursor.close()
    conn.close()
    return company_table


#==================================================================================

@app.route("/test_user_info_table")
def user_info_table(seeker_id) :

    conn = dbconn.db_connect()
    cursor = conn.cursor()
    
    sql = "SELECT user_id FROM user_seeker_info WHERE seeker_id = " + str(seeker_id)
    main_sql = "SELECT * FROM user_info WHERE user_id = (" + sql + ")"
    
    cursor.execute(main_sql)
    rows = list(cursor.fetchone())

    cursor.close()
    conn.close()
    return list(map(str, rows))

@app.route("/test_portfolio_career_table")
def portfolio_career_table(seeker_id):

    # seeker_id=1
    conn = dbconn.db_connect()

    career_table = [["user_seeker_info"], ["user_language_info"], ["user_skill_info"], ["user_license_info"], ["user_school_info"],  ["user_career_info"], ["user_project_info"], ["user_activation_info"], ["user_reward_info"], ["user_overseas_info"]]
    table_index = 0
    rowArr = []
    cursor = conn.cursor()

    for table_name in career_table :
        
        sql = "SELECT * FROM " + table_name[0] + " WHERE seeker_id = " + str(seeker_id)
        cursor.execute(sql)
        rows = cursor.fetchall()                  
        
        for row in rows :
            for tmp in row :
                rowArr.append(tmp)
            career_table[table_index].append(list(rowArr))

        rowArr.clear()
        career_table[table_index].pop(0)
        list(map(str, career_table[table_index]))     
        table_index += 1

    # print(career_table[1][0])
    cursor.close()
    conn.close()
    
    return career_table



def split_str_num(str_num):
    for index in range(len(str_num)):
        if not str_num[index].isdigit():
            return str_num[:index], str_num[index:]
        

@app.route("/resume_create/<seeker_id>/<company_id>/<company_name>/<position>")
def resumeCreate(seeker_id, company_id, company_name, position):
    
    result_arr = []
    total_table = career_table_select(seeker_id)
    # company_value[0~3] = 순서 : question_id,  position, question, length
    company_table = company_table_select(company_id, position)
    result_arr = []

    for company_value in company_table :

        # 직무, 자소서 질문, 자소서 최대 길이
        # position = company_value[1]
        resume_question = company_value[2]
        question_text_max = company_value[3]

        question_length_num, question_length_str = split_str_num(question_text_max)
        question_length_min = question_length_num - 100
        # print("num : " + result_num)
        # print("str : " + result_str)

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

            {"role": "assistant", "content": ("자기소개서를 작성하기 위해 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주세요.")},
                                            
            {"role": "user", "content":f"1. 경력 : {total_table[0]}\n"},
            {"role": "user", "content":f"2. 프로젝트 경험 : {total_table[1]}\n"},
            {"role": "user", "content":f"3. 수상 경험 : {total_table[2]}\n"},
            {"role": "user", "content":f"4. 대외활동 경험 : {total_table[3]}\n"},
            {"role": "user", "content":f"5. 해외 경험 : {total_table[4]}\n"},
            {"role": "user", "content":f"6. 보유한 자격증 : {total_table[5]}\n"},
            {"role": "user", "content":f"7. 보유 스킬 정보 : {total_table[6]}\n"},

            {"role": "assistant", "content": ("기업명과 지원 직무, 자기소개서 질문, 자기소개서 글자 수 범위를 알려주세요.")},
            {"role": "user", "content":f"지원할 기업의 기업명 : {company_name}\n"},
            {"role": "user", "content":f"지원 직무 : {position}\n"},
            {"role": "user", "content":f"자기소개서 질문 : {resume_question}\n"},
            {"role": "user", "content":f"자기소개서 최대 글자수 : {question_length_min}{question_length_str} ~ {question_length_num}{question_length_str} 사이"},
            
            {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 "
                                             f"{company_name} {position} 직무의 자기소개서를 작성해드리도록 하겠습니다."},
            {"role": "user", "content":f"자기소개서 내용에 인삿말(감사합니다, 안녕하세요)과 이름 소개가 들어갔다면 그 부분은 삭제해줘"},

            {"role": "assistant", "content": ("감사합니다, 안녕하세요와 같은 인삿말이 작성되어 있는 부분은 삭제하겠습니다. 작성된 자기소개서에 추가할 부분이 있나요?")},
            {"role": "user", "content": ("제일 첫 번째 줄에는 []안에 작성된 자기소개서 내용의 제목을 간략하게 작성해줘")},
            ],
            # repetition_penalty=1.2,
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

        result_arr.append([[resume_question, message_result]])

    # return 'good'
    return jsonify({"result": result_arr})


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

    return jsonify({"result": arr})


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

    return jsonify({"result": arr})


@app.route("/make_portfolio/<seeker_id>")
def makePortfolio(seeker_id):
    document = MailMerge('C:\\kb\\cheer-up_portfoliio\\real_fin_KB\\ver3_new_excel\\portfolio_1.docx')
    # 문서의 병합필드 확인
    print(document.get_merge_fields())

    user_table = user_info_table(seeker_id)
    career_table = portfolio_career_table(seeker_id)

    print(career_table)

    # 직접 값을 채워보자
    ## 유동적인 필드 값을 처리하기 위해 필드 담는 변수 초기화 ##
    language_fields = []
    skill_fields = []
    license_fields = []
    school_fields = []
    career_fields = []
    project_fields = []
    activation_fields = []
    rewards_fields = []
    overseas_fields = []

    # 유동적인 필드 값 추출 및 필드 리스트에 추가
    for language in career_table[1]:
        language_fields.append({
            'language': language[1],
            'lang_type': language[2],
            'lang_grade': language[3],
            'lang_acquired_date': "2023.05.16",
            'lang_license_number': language[5],
            'lang_agency': language[7]
        })

    for skill in skill_table[2]:
        skill_fields.append({
            'skill_name': skill[0][1],
            'skill_grade': skill[0][2]
        })

    for license in career_table[3]:
        license_fields.append({
            'license_name': license[0][1],
            'license_acquired_date': "2022.9.14",
            'license_license_number': license[0][4],
            'license_agency': license[0][5]
        })

    for school in school_table[4]:
        school_fields.append({
            'education_type': school[0][1],
            'highest_check': school[0][2],
            'school_name': school[0][3],
            'entrance_date': school[0][4],
            'graduation_date': school[0][5],
            'attending_check': school[0][6],
            'major': school[0][7],
            'gpa': school[0][8],
            'transfer_check': school[0][9]
        })

    for career in career_table[5]:
        career_fields.append({
            'company_name': career[0][1],
            'department': career[0][2],
            'position': career[0][3],
            'career_start_date': career[0][4],
            'career_end_date': career[0][5],
            'career_attending_check': career[0][6],
            'hire_type': career[0][7]
        })

    for project in project_table[6]:
        project_fields.append({
            'project_name': project[0][1],
            'host_name': project[0][2],
            'project_content': project[0][3],
            'project_skill': project[0][4],
            'institution': project[0][5]
        })

    for activation in activation_table[7]:
        activation_fields.append({
            'activation_name': activation[0][1],
            'act_start_date': activation[0][2],
            'act_end_date': activation[0][3],
            'activation_content': activation[0][4]
        })

    for rewards in rewards_table[8]:
        rewards_fields.append({
            'rewards_name': rewards[0][1],
            'rewards_acquired_date': rewards[0][2],
            'rewards_host': rewards[0][3]
        })

    for overseas in overseas_table[9]:
        overseas_fields.append({
            'oversea_purpose': overseas[0][1],
            'nation': overseas[0][2],
            'oversea_start_date': overseas[0][3],
            'oversea_end_date': overseas[0][4],
            'ovesea_institution': overseas[0][5],
            'oversea_reason': overseas[0][6]
        })

    # 문서 병합 시 유동적인 필드를 추가하기
    document.merge(
        # 고정 필드들은 그대로 유지
        # 기본 인적사항
        user_name=user_table[3],
        birthdate='1999.06.05',  # front = ex)990605 이런식으로 적도록 / db = varchar
        sex="여",
        address=user_table[11],
        phone=user_table[7],
        email=user_table[6],

        # userd_seeker
        ename=career_table[0][0][1],
        cname=career_table[0][0][2],
        nation_origin=career_table[0][0][7],
        military="면제",  # career_table[0][0][3] , front = option value "면제" / db = varchar /// 이건 form도 만들어야함
        bohun=career_table[0][0][4],
        disabled="미해당",  # career_table[0][0][5], 장애여부, 해당 미해당 form 필요 병역과 같은 form으로 하면 될듯

        # 유동적인 필드들을 반복하면서 추가
        **{f'language_{index}': language for index, language in enumerate(language_fields)},
        **{f'skill_{index}': skill for index, skill in enumerate(skill_fields)},
        **{f'license_{index}': license for index, license in enumerate(license_fields)},
        **{f'school_{index}': school for index, school in enumerate(school_fields)},
        **{f'career_{index}': career for index, career in enumerate(career_fields)},
        **{f'project_{index}': project for index, project in enumerate(project_fields)},
        **{f'activation_{index}': activation for index, activation in enumerate(activation_fields)},
        **{f'rewards_{index}': rewards for index, rewards in enumerate(rewards_fields)},
        **{f'overseas_{index}': overseas for index, overseas in enumerate(overseas_fields)},

    )

    # 필드 병합된 결과의 포트폴리오를 직접 생성...파일명도 필드명을 참고해서
    document.write('./real_kb/portfolio.docx')


'''
    document.merge(
        ################## 기본 인적 사항###############
        user_name=user_table[3],
        birthdate='1999.06.05',  # front = ex)990605 이런식으로 적도록 / db = varchar
        sex="여",
        address=user_table[11],
        phone=user_table[7],
        email=user_table[6],

        # userd_seeker
        ename=career_table[0][0][1],
        cname=career_table[0][0][2],
        nation_origin=career_table[0][0][7],
        military="면제",  # career_table[0][0][3] , front = option value "면제" / db = varchar /// 이건 form도 만들어야함
        bohun=career_table[0][0][4],
        disabled="미해당",  # career_table[0][0][5], 장애여부, 해당 미해당 form 필요 병역과 같은 form으로 하면 될듯

        ##################language#######################
        language=career_table[1][0][1],
        lang_type=career_table[1][0][2],
        lang_grade=career_table[1][0][3],
        lang_acquired_date="2023.05.16",  # career_table[1][0][4], 이건 일단 보류
        lang_license_number=career_table[1][0][5],
        lang_agency=career_table[1][0][7],

        ##################skill############################
        skill_name='',
        skill_grade='',

        ##################licence############################
        license_name=career_table[3][0][1],
        license_acquired_date="2022.9.14",  # career_table[3][0][3], 보류
        license_license_number=career_table[3][0][4],
        license_agency=career_table[3][0][5],

        ##################school##############################
        education_type='',
        highest_check='',
        school_name='',
        entrance_date='',
        graduation_date='',
        attending_check='',

        major='',
        gpa='',
        transfer_check='',

        ##################career###############################
        company_name=career_table[5][0][1],
        department=career_table[5][0][2],
        position=career_table[5][0][3],
        career_start_date=career_table[5][0][4],
        career_end_date=career_table[5][0][5],
        career_attending_check=career_table[5][0][6],
        hire_type=career_table[5][0][7],

        ##################project###############################
        project_name=career_table[6][0][1],
        host_name=career_table[6][0][2],
        project_content=career_table[6][0][3],
        project_skill=career_table[6][0][4],
        institution=career_table[6][0][6],

        ##################Activation###############################
        activation_name=career_table[7][0][1],
        act_start_date=career_table[7][0][2],
        act_end_date=career_table[7][0][3],
        activation_content=career_table[7][0][4],

        ##################Rewards###################################
        rewards_name=career_table[8][0][1],
        rewards_acquired_date=career_table[8][0][2],
        rewards_host=career_table[8][0][3],

        ##################Overseas###################################
        oversea_purpose=career_table[9][0][1],
        nation=career_table[9][0][2],
        oversea_start_date=career_table[9][0][3],
        oversea_end_date=career_table[9][0][4],
        ovesea_institution=career_table[9][0][5],
        oversea_reason=career_table[9][0][6]
    )

'''


if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)