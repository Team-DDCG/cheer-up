from flask import Flask
from flask import request, jsonify
from flask_cors import CORS

import openai
import cx_Oracle

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

dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
conn = cx_Oracle.connect('kb_db', '1234', dns)


@app.route("/test_sql")
def career_table_select(user_seeker_id):

    # career_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"], ["user_skill_info"]]
    career_table = [["user_career_info"], ["user_project_info"]]
    total_table = []
    table_index = 0

    # 취준생번호 값 받아오기
    seeker_id = user_seeker_id

    # dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    # conn = cx_Oracle.connect('kb_db', '1234', dns)
    cursor = conn.cursor()

    # career_table에서 테이블 명 하나씩 가져와서 select에 넣어주기
    for table_name in career_table :
        
        print(table_name[0])
        
        sql = "SELECT * FROM " + table_name[0] + " WHERE seeker_id = " + str(seeker_id)
        print(sql)

        cursor.execute(sql)
        
        print(cursor.rowcount)

        rows = cursor.fetchall()                  
        # print(rows)

        # print(career_table[0])
        # print(career_table[1])
        for row in rows :
            career_table[table_index].append(', '.join(map(str, row)))
            # career_table[table_index].extend(row)

        career_table[table_index].pop(0)
        table_str = ""
        for st in career_table[table_index] :
             table_str += (st + ", ")

        total_table.append(table_str)
        # print(career_table[table_index])
        table_index += 1

    print(total_table)
    cursor.close()
    return total_table





# ==================================================================================================





@app.route("/resume_create")
def resumeCreate():
    
    # 취준생번호, 회사번호 값 받아오기
    seeker_id = 1
    company_id = 1
    
    total_table = career_table_select(seeker_id)

    # 자소서 질문, 자소서 최대 길이, 기업명 
    resume_question = "가장 재미있고 의미 있었던 IT 프로젝트 또는 교육(공모전, 논문, 이수과목 등)을 진행한 경험을 작성해 주시고, 해당 경험을 어떻게 직무수행에 활용할 것인지 서술해 주십시오. (해당 문항을 주제로 코딩테스트 합격자에 한하여 포트폴리오 제출 예정, 자세한 내용은 코딩테스트 합격자 대상 추후 안내)"
    # resume_question = "그동안 접했던 여러 금융기관의 온·오프라인 서비스 중 개선할 필요가 있다고 느낀 서비스에 대해 기술해 주십시오."
    question_text_max = "2000byte"
    company_name = "KB국민은행"

    # Call the chat GPT API 
    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
         {"role": "system", "content": ("내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 "
                                       "기업 자기소개서 질문에 맞추어 기업에 제출할 자기소개서를 작성해줘")},

         {"role": "system", "content": ("제일 첫 번째 줄에는 []안에 자소서 내용의 제목에 대해 간략하게 작성해줘")},

         {"role": "system", "content": ("인삿말(감사합니다, 안녕하세요)과 이름 소개는 절대 쓰지마, "
                                       "두괄식으로 작성해줘, "
                                       "제공해주는 내 정보에 아무런 값이 없다면 참고하지 말아줘")},

         {"role": "user", "content": (f"1. 경력 : ${total_table[0]}\n2. 프로젝트 경험 : ${total_table[1]}\n3. 수상 경험 : ${total_table[2]}\n"
                                     f"4. 대외활동 경험 : ${total_table[3]}\n5. 해외 경험 : ${total_table[4]}\n6. 보유한 자격증 : ${total_table[5]}\n"
                                     f"7. 보유 스킬 정보 : ${total_table[6]}\n 기업명 : ${company_name}\n "
                                     f"자기소개서 질문 : ${resume_question}\n 자기소개서 최대 글자수 : ${question_text_max}")},
        ],
        temperature=0.8,
        max_tokens=2048
    )
    
    print(resume_question)
    
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    
    print(message_result)

    # DB 접속 및 저장, close
    dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    conn = cx_Oracle.connect('kb_db', '1234', dns)
    cursor = conn.cursor()
    sql = "INSERT INTO resume VALUES(resume_seq.nextval, :content, 0, :seeker_id, :company_id)"
    cursor.execute(sql, {'content': message_result, 
                         'seeker_id': seeker_id, 
                         'company_id': company_id})
    conn.commit()
    cursor.close()
    conn.close()
    
    return jsonify({"result": message_result})




# ==================================================================================================



# 회원 이력정보 작성 후 유료회원 일 경우 또는 유료회원 가입 후 나의 성향 그래프 생성하는 것을 목표.
# === myCharacteristic() 기능은 회원 정보 가져오고 gpt통해 회원 성향 다섯가지를 DB에 저장하는 기능
@app.route("/my_characteristic")
def myCharacteristic():

    # career_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"]]
    # career_table = [["user_career_info"], ["user_project_info"]]
    # total_table = []
    # table_index = 0

    # 취준생번호 값 받아오기
    seeker_id = 1

    # dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    # conn = cx_Oracle.connect('kb_db', '1234', dns)
    # cursor = conn.cursor()

    total_table = career_table_select(seeker_id)

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content" : ("내가 제공하는 정보를 기반으로 성향을 나타내기 적합한 단어라고 생각되는 것을 "
                                           "책임의식, 도전정신, 소통․협력, 창의성, 원칙신뢰, 전문성, 열정, 글로벌역량, 실행력, 사회공헌 "
                                           "10개 중 5개를 뽑고 비율을 나타내줘")},

            {"role": "system", "content" : ("다른 말은 다 제외하고 나타내줘, 답변 결과는 다른 말 하나 없이 "
                                           "'성향1: 비율1/성향2: 비율2/성향3: 비율3/성향4: 비율4/성향5: 비율5'의 형태로만 나타내줘, "
                                           "성향1에 대한 비율은 비율1이야, "
                                           "성향은 문자열이라''로 감싸주고 비율은 int값이야, "
                                           "성향1: 비율1을 전문성: 40과 같이 각각에 단어를 대입한 양식으로 나타내줘")},
            
            {"role": "system", "content" : "기입이 되지않은 정보의 경우 무시하고 기입된 것 위주로만 판단해줘"},

            # {"role": "user", "content": (f"경력 : ${career_info}\n프로젝트 경험 : ${project_info}\n수상 경험 : ${reward_info}\n대외활동 경험 : ${activation_info}\n"
            #                             f"해외 경험 : ${overseas_info}\n보유한 자격증 : ${license_info}\n 를 기반으로 "
            #                              "부가적인 말 아예없이 양식에 맞추어 성향 5개와 비율을 나타내주면 돼")},
            {"role": "user", "content": (f"경력 : ${total_table[0]}\n프로젝트 경험 : ${total_table[1]}를 기반으로 "
                                        "부가적인 말 아예없이 양식에 맞추어 책임의식, 도전정신, 소통․협력, 창의성, 원칙신뢰, 전문성, 열정, 글로벌역량, 실행력, 사회공헌 중에 적합한 성향 5개와 비율을 나타내주면 돼")},
        ],
        temperature=0.7,
        max_tokens=2048
    )


    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    print(message_result)

    tmp_text = message_result.split('/')
    print(tmp_text)

    arr = []
    for tmp in tmp_text :
        arr.append(tmp.split(': '))

    for tmp in arr :
        arr[arr.index(tmp)][1] = int(tmp[1])

    # DB 접속 및 저장, close
    cursor = conn.cursor()

    sql = ("INSERT INTO characteristic_test VALUES"
           "(:seeker_id, :characteristic_1, :characteristic_2, :characteristic_3,"
           ":characteristic_4, :characteristic_5,"
           ":percentage_1, :percentage_2, :percentage_3, :percentage_4, :percentage_5)")
    
    cursor.execute(sql, {'seeker_id': seeker_id,
                         'characteristic_1': arr[0][0],
                         'characteristic_2': arr[1][0],
                         'characteristic_3': arr[2][0],
                         'characteristic_4': arr[3][0],
                         'characteristic_5': arr[4][0],
                         'percentage_1': arr[0][1],
                         'percentage_2': arr[1][1],
                         'percentage_3': arr[2][1],
                         'percentage_4': arr[3][1],
                         'percentage_5': arr[4][1]})
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({"result": message_result})


# ==================================================================================================


# 회사의 인재상과 프로젝트 경험 기반으로 인재상 적합도 나타내기
@app.route("/goodness_of_fit")
def goodnessOfFit():

    # 취준생번호 값 받아오기
    seeker_id = 1
    # 회사명 값 받아오기
    company_name = "KB국민은행"

    total_table = career_table_select(seeker_id)

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content" : (f"${company_name}의 인재상 단어 5개를 뽑고 내가 제공하는 정보를 기반으로 "
                                            f"${company_name}의 인재상과의 적합도 비율을 나타내줘")},

            {"role": "system", "content" : ("다른 말은 다 제외하고 나타내줘, 답변 결과는 다른 말 하나 없이 "
                                           "'인재상1: 적합도 비율1/인재상2: 적합도 비율2/인재상3: 적합도 비율3/인재상4: 비율4/인재상5: 적합도 비율5'의 형태로만 나타내줘, "
                                           "인재상1에 대한 비율은 적합도 비율1이야, "
                                           "인재상은 문자열이라''로 감싸주고 비율은 int값이야, "
                                           "인재상1: 적합도 비율1을 '전문성': 40과 같이 각각에 단어를 대입한 양식으로 나타내줘, "
                                           "'/'으로 구분 주어줄 때 공백이 없어야해")},

            {"role": "system", "content" : "기입이 되지않은 정보의 경우 무시하고 기입된 것 위주로만 판단해줘"},

            {"role": "user", "content": (f"경력 : ${total_table[0]}\n프로젝트 경험 : ${total_table[1]}\n수상 경험 : ${total_table[2]}\n"
                                         f"대외활동 경험 : ${total_table[3]}\n해외 경험 : ${total_table[4]}\n보유한 자격증 : ${total_table[5]}\n "
                                         f"를 기반으로 부가적인 말 아예없이 양식에 맞추어 ${company_name}의 인재상 5개와 비율을 나타내주면 돼")},
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
    print(tmp_text)

    # ': ' 기준으로 나누어 ['인재상1', '적합도 비율1']로 arr 배열에 차례대로 저장 ( 2차원 배열 )
    arr = []
    for tmp in tmp_text :
        arr.append(tmp.split(': '))

    print(arr)

    # 적합도 비율은 int 값이여야 하므로 str -> int로 변환
    for tmp in arr :
        arr[arr.index(tmp)][1] = int(tmp[1])

    print(arr)

    # DB 접속 및 저장, close
    # dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    # conn = cx_Oracle.connect('kb_db', '1234', dns)
    cursor = conn.cursor()
    
    sql = ("INSERT INTO company_fit VALUES"
           "(company_fit_seq.nextval, :company_name, :company_needs1, :company_needs2,"
           ":company_needs3, :company_needs4, :company_needs5,"
           ":company_rate1, :company_rate2, :company_rate3, :company_rate4,"
           ":company_rate5, :seeker_id)")
    
    cursor.execute(sql, {
                         'company_name': company_name,
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