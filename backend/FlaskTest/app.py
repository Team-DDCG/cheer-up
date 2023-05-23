from flask import Flask
from flask import request, jsonify
from flask_cors import CORS

import openai
import cx_Oracle
import dbconn

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
def career_table_select(user_seeker_id):

    conn = dbconn.db_connect()

    career_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"], ["user_skill_info"]]
    total_table = []
    table_index = 0

    # 취준생번호 값 받아오기
    seeker_id = user_seeker_id

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



@app.route("/resume_create/<seeker_id>/<company_id>")
def resumeCreate(seeker_id, company_id):
    
    # 취준생번호, 회사번호 값 받아오기
    # seeker_id = 1
    # company_id = 1
    
    total_table = career_table_select(seeker_id)
    # company_value[0~3] = 순서 : question_id,  position, question, length
    company_table = company_table_select(company_id)

    for company_value in company_table :

        # 직무, 자소서 질문, 자소서 최대 길이
        position = company_value[1]
        resume_question = company_value[2]
        question_text_max = company_value[3]
        
        # 회사번호로 기업명 가져오기...?
        company_name = "KB국민은행"
        

        # Call the chat GPT API 
        completion = openai.ChatCompletion.create(
            model="gpt-4",
            messages=[
            {"role": "system", "content": ("너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 "
                                        "기업 자기소개서 질문에 맞추어 기업에 제출할 자기소개서를 작성해주는 AI야")},

            {"role": "assistant", "content": ("자기소개서를 작성하는데 유의할 점이 있나요?")},
            {"role": "user", "content": ("인삿말(감사합니다, 안녕하세요)과 이름 소개는 쓰지말고, 두괄식으로 작성해줘"
                                        "그리고 내가 제공해주는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 중 없는 것이 있다면 참고하지 말아줘 ")},

            {"role": "assistant", "content": ("경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주시고, 기업명과 지원 직무, 자기소개서 질문, 자기소개서 최대 글자수를 알려주세요.")},
                                            
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
            
            {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 {company_name}의 자기소개서를 작성해드리도록 하겠습니다."},
            {"role": "user", "content":f"내용에 인삿말(감사합니다, 안녕하세요)과 이름 소개가 들어갔다면 그 부분은 삭제해줘"},

            {"role": "assistant", "content": ("작성된 자기소개서에 추가할 부분이 있나요?")},
            {"role": "user", "content": ("제일 첫 번째 줄에는 []안에 작성된 자기소개서 내용의 제목을 간략하게 작성해줘")},
            ],
            temperature=0.8,
            max_tokens=2048
        )
            
        print(resume_question)
        
        message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
        
        conn = dbconn.db_connect()
        cursor = conn.cursor()
        sql = "INSERT INTO resume VALUES(resume_seq.nextval, :content, SYSDATE, :seeker_id, :company_id)"
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

    # 취준생번호 값 받아오기
    # seeker_id = 1

    total_table = career_table_select(seeker_id)
    completion = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content" : "너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 성향을 나타내주는 AI야 "},

            {"role": "system", "content" : "성향은 책임의식, 도전정신, 소통․협력, 창의성, 원칙신뢰, 전문성, 열정, 글로벌역량, 실행력, 사회공헌 10개 중 5개를 뽑고 비율을 나타내줘"},

            {"role": "assistant", "content" : "성향과 비율을 나타낼 때 맞춰야할 양식이 있나요?"},
            {"role": "user", "content": "'성향1: 비율1/성향2: 비율2/성향3: 비율3/성향4: 비율4/성향5: 비율5'의 형태로만 나타내줘"},
            {"role": "user", "content": " 성향1에 대한 비율은 비율1이야"},
            {"role": "user", "content": " 즉, 성향1: 비율1을 전문성: 40과 같이 각각에 단어를 대입한 양식으로 나타내줘"},

            {"role": "assistant", "content" : "성향과 비율을 나타낼 때 유의할 점이 있나요?"},
            {"role": "user", "content" : "기입이 되지않은 정보의 경우 무시하고 기입된 것 위주로만 판단해줘"},
            {"role": "user", "content" : " 부가적인 말이나 다른 말은 다 제외하고 내가 제시해준 양식에만 맞추어서 답변해줘"},

            # {"role": "system", "content" : ("성향은 문자열이라''로 감싸주고 비율은 int값이야")},

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

    for tmp in arr :
        arr[arr.index(tmp)][1] = int(tmp[1])

    # DB insert
    conn = dbconn.db_connect()
    cursor = conn.cursor()

    sql = ("INSERT INTO characteristic_test VALUES"
           "(seeker_fit_seq.nextval, :characteristic_1, :characteristic_2, :characteristic_3,"
           ":characteristic_4, :characteristic_5,"
           ":percentage_1, :percentage_2, :percentage_3, :percentage_4, :percentage_5, :seeker_id)")
    
    cursor.execute(sql, {'characteristic_1': arr[0][0],
                         'characteristic_2': arr[1][0],
                         'characteristic_3': arr[2][0],
                         'characteristic_4': arr[3][0],
                         'characteristic_5': arr[4][0],
                         'percentage_1': arr[0][1],
                         'percentage_2': arr[1][1],
                         'percentage_3': arr[2][1],
                         'percentage_4': arr[3][1],
                         'percentage_5': arr[4][1],
                         'seeker_id': seeker_id})
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({"result": message_result})


# ==================================================================================================


# 회사의 인재상과 프로젝트 경험 기반으로 인재상 적합도 나타내기
@app.route("/goodness_of_fit/<seeker_id>/<company_name>")
def goodnessOfFit(seeker_id, company_name):

    # 취준생번호 값 받아오기
    # seeker_id = 1
    # # 회사명 값 받아오기
    # company_name = "KB국민은행"

    total_table = career_table_select(seeker_id)

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content" : (f"너는 {company_name}의 인재상 단어 5개를 뽑고, "
                                            f"내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 {company_name}의 인재상과의 적합도 비율을 나타내주는 AI야")},

            {"role": "assistant", "content" : "인재상과의 적합도 비율을 나타낼 때 맞춰야할 양식이 있나요?"},
            {"role": "user", "content" : "'인재상1: 적합도 비율1/인재상2: 적합도 비율2/인재상3: 적합도 비율3/인재상4: 비율4/인재상5: 적합도 비율5'의 형태로만 나타내줘 "},
            {"role": "user", "content" : " 인재상1에 대한 비율은 적합도 비율1이야 "},
            {"role": "user", "content" : "인재상1: 적합도 비율1을 '전문성': 40과 같이 각각에 단어를 대입한 양식으로 나타내줘, '/'으로 구분 주어줄 때 공백이 없어야해"},

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





















if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)


# @app.route('/')
# def hello_world():
#     return 'hello'

    # # 취준생번호 값 받아와서 해당 번호의 
    # # 경력, 프로젝트 경험, 수상, 대외활동, 해외경험, 자격증, 스킬정보 가져오기
    # career_info = "1. 웹크롤링을 통한 외래어 빈도 분석 프로그램, 2021.03 ~ 2021.12, 소개 : 국어문화원 교수님과 진행한 지방자치단체 홈페이지의 특정 게시판 웹크롤링을 통하여 외래어 빈도 수를 체크하는 프로그램 제작, 2. KDB산업은행 청년 인턴, 산업기술리서치센터에서 근무"
    # project_info = "1. 어린이 스마트 배지 2021.03 ~ 2021.06 소개 : 영상처리 기술을 이용한 어린이 보행안전 배지와 부모용 App 개발, 어린이가 착용하는 배지의 경우, 아이가 바라보는 시점을 기준으로 도로의 유형을 구분하고 그에 맞는 알림을 줌, 부모용 App의 경우, 아이의 위치 및 안전구역 설정이 가능하며 아이의 배지 알림을 직접 음성으로 녹음하는 기능이 있음, Semantic segmentation - FCN(fully convolutional networks) 모델 사용, 2. 스터디플래너 App ‘Make You Study’, 2020.03 ~ 2020.06, 소개 : 영상처리 기술을 사용한 출석체크 기능의 스터디플래너 Android App, 타임테이블에 설정한 시간에 알림이 울리고, 책상사진을 찍어 출석체크를 하는 기능, 사용 기술 : firebase, firebase ML Kit, OpenCV, Android Studio, 나의 역할 : 출석체크 기능 담당 - OpenCV의 color Histogram을 이용한 matching 방법을 사용, 프로필에 등록해놓은 책상사진 5장과 출석체크시 촬영한 책상사진을 비교하여 출석을 체크"
    # reward_info = "1. 제 9회 대한전기학회 산업전기위원회 대학생 작품경진대회 대상 수상, 2. 교내 프라임 경진대회 최우수상 수상 "
    # activation_info = ""
    # overseas_info = ""
    # license_info = ""