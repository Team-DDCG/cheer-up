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

@app.route("/resume_create")
def resumeCreate():
    
    # oracle DB에서 가져와야 됨...... 임의로 넣어놓은 값....
    # 경력, 프로젝트 경험, 수상, 대외활동, 해외경험, 자격증, 스킬정보
    career_info = "1. 웹크롤링을 통한 외래어 빈도 분석 프로그램, 2021.03 ~ 2021.12, 소개 : 국어문화원 교수님과 진행한 지방자치단체 홈페이지의 특정 게시판 웹크롤링을 통하여 외래어 빈도 수를 체크하는 프로그램 제작, 2. KDB산업은행 청년 인턴, 산업기술리서치센터에서 근무"
    project_info = "1. 어린이 스마트 배지 2021.03 ~ 2021.06 소개 : 영상처리 기술을 이용한 어린이 보행안전 배지와 부모용 App 개발, 어린이가 착용하는 배지의 경우, 아이가 바라보는 시점을 기준으로 도로의 유형을 구분하고 그에 맞는 알림을 줌, 부모용 App의 경우, 아이의 위치 및 안전구역 설정이 가능하며 아이의 배지 알림을 직접 음성으로 녹음하는 기능이 있음, Semantic segmentation - FCN(fully convolutional networks) 모델 사용, 2. 스터디플래너 App ‘Make You Study’, 2020.03 ~ 2020.06, 소개 : 영상처리 기술을 사용한 출석체크 기능의 스터디플래너 Android App, 타임테이블에 설정한 시간에 알림이 울리고, 책상사진을 찍어 출석체크를 하는 기능, 사용 기술 : firebase, firebase ML Kit, OpenCV, Android Studio, 나의 역할 : 출석체크 기능 담당 - OpenCV의 color Histogram을 이용한 matching 방법을 사용, 프로필에 등록해놓은 책상사진 5장과 출석체크시 촬영한 책상사진을 비교하여 출석을 체크"
    reward_info = "1. 제 9회 대한전기학회 산업전기위원회 대학생 작품경진대회 대상 수상, 2. 교내 프라임 경진대회 최우수상 수상 "
    activation_info = ""
    overseas_info = ""
    license_info = ""
    skill_info = "python, java, c, c#, spring, javascript"
    
    # 자소서 질문, 자소서 최대 길이, 기업명 
    resume_question = "가장 재미있고 의미 있었던 IT 프로젝트 또는 교육(공모전, 논문, 이수과목 등)을 진행한 경험을 작성해 주시고, 해당 경험을 어떻게 직무수행에 활용할 것인지 서술해 주십시오. (해당 문항을 주제로 코딩테스트 합격자에 한하여 포트폴리오 제출 예정, 자세한 내용은 코딩테스트 합격자 대상 추후 안내)"
    question_text_max = 2000
    company_name = "KB 국민은행"

    # Call the chat GPT API
    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
         {"role": "system", "content": "내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 기업 자기소개서 질문에 맞추어 기업에 제출할 자기소개서를 작성해줘, 안녕하세요, 감사합니다 같은 인삿말은 빼줘, 제공해주는 내 정보에 아무런 값이 없다면 참고하지 말아줘"},   
         {"role": "user", "content": f"1. 경력 : ${career_info}\n2. 프로젝트 경험 : ${project_info}\n3. 수상 경험 : ${reward_info}\n4. 대외활동 경험 : ${activation_info}\n5. 해외 경험 : ${overseas_info}\n6. 보유한 자격증 : ${license_info}\n7. 보유 스킬 정보 : ${skill_info}\n 기업명 : ${company_name}\n 자기소개서 질문 : ${resume_question}\n 자기소개서 최대 글자수 : ${question_text_max}"},
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
    sql = "INSERT INTO resume_test VALUES(:resume_question, :message_result)"
    cursor.execute(sql, {'resume_question': resume_question, 'message_result': message_result})
    conn.commit()
    conn.close()
    
    return jsonify({"result": message_result})

@app.route("/my_characteristic")
def myCharacteristic():

    # 경력, 프로젝트 경험, 수상, 대외활동, 해외경험, 자격증, 스킬정보
    career_info = "1. 웹크롤링을 통한 외래어 빈도 분석 프로그램, 2021.03 ~ 2021.12, 소개 : 국어문화원 교수님과 진행한 지방자치단체 홈페이지의 특정 게시판 웹크롤링을 통하여 외래어 빈도 수를 체크하는 프로그램 제작, 2. KDB산업은행 청년 인턴, 산업기술리서치센터에서 근무"
    project_info = "1. 어린이 스마트 배지 2021.03 ~ 2021.06 소개 : 영상처리 기술을 이용한 어린이 보행안전 배지와 부모용 App 개발, 어린이가 착용하는 배지의 경우, 아이가 바라보는 시점을 기준으로 도로의 유형을 구분하고 그에 맞는 알림을 줌, 부모용 App의 경우, 아이의 위치 및 안전구역 설정이 가능하며 아이의 배지 알림을 직접 음성으로 녹음하는 기능이 있음, Semantic segmentation - FCN(fully convolutional networks) 모델 사용, 2. 스터디플래너 App ‘Make You Study’, 2020.03 ~ 2020.06, 소개 : 영상처리 기술을 사용한 출석체크 기능의 스터디플래너 Android App, 타임테이블에 설정한 시간에 알림이 울리고, 책상사진을 찍어 출석체크를 하는 기능, 사용 기술 : firebase, firebase ML Kit, OpenCV, Android Studio, 나의 역할 : 출석체크 기능 담당 - OpenCV의 color Histogram을 이용한 matching 방법을 사용, 프로필에 등록해놓은 책상사진 5장과 출석체크시 촬영한 책상사진을 비교하여 출석을 체크"
    reward_info = "1. 제 9회 대한전기학회 산업전기위원회 대학생 작품경진대회 대상 수상, 2. 교내 프라임 경진대회 최우수상 수상 "
    activation_info = ""
    overseas_info = ""
    license_info = ""

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content" : "내가 제공하는 정보를 기반으로 전체적인 나의 성향을 나타낼 수 있는 단어 5개와 비율을 나타내줘"},
            {"role": "system", "content" : "다른 말은 다 제외하고 나의 성향을 나타낼 수 있는 단어 총 5개와 각 성향이 차지하는 비율을 예를 들어 성향 - 비율%, 로 구분해서 나타내줘"},
            {"role": "user", "content": f"경력 : ${career_info}\n프로젝트 경험 : ${project_info}\n수상 경험 : ${reward_info}\n대외활동 경험 : ${activation_info}\n해외 경험 : ${overseas_info}\n보유한 자격증 : ${license_info}\n"},
        ],
        temperature=0.7,
        max_tokens=2048
    )
    
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    
    print(message_result)

    return jsonify({"result": message_result})

if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)
# @app.route('/')
# def hello_world():
#     return 'hello'