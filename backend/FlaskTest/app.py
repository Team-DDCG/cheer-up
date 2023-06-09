# -*- coding: utf-8 -*-
import time
from flask import Flask
from flask import request, jsonify
from flask_cors import CORS
from io import BytesIO

import openai
import cx_Oracle
import dbconn
from datetime import datetime
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

# 이력사항 DB에서 가져오고 gpt에 이력정보 넣어주기 위해 str 만들어줌 
@app.route("/test_career_table_select/<seeker_id>")
def career_table_select(seeker_id):

    
    conn = dbconn.db_connect()

    career_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"], ["user_skill_info"]]
    table_index = 0
    career_index = 0
    cursor = conn.cursor()

    for table_name in career_table :

        if table_name[0] == "user_seeker_info" :
            career_table[table_index].append("[개인 정보] \n")
            select_value = "*"

        elif table_name[0] == "user_language_info" :
            career_table[table_index].append("[어학 정보] \n")
            select_value = "language, type, grade"

        elif table_name[0] == "user_skill_info" :
            career_table[table_index].append("[보유 기술] \n")
            select_value = "skill_name"

        elif table_name[0] == "user_license_info" :
            career_table[table_index].append("[보유 자격증] \n")
            select_value = "license_name, grade"

        elif table_name[0] == "user_career_info" :
            career_table[table_index].append("[경력] \n")
            select_value = "company_name, department, position, attending_check"

        elif table_name[0] == "user_project_info" :
            career_table[table_index].append("[프로젝트 경험] \n")
            select_value = "project_name, host_name, content, skill"

        elif table_name[0] == "user_activation_info" :
            career_table[table_index].append("[대외 활동] \n")
            select_value = "activation_name, content"

        elif table_name[0] == "user_reward_info" :
            career_table[table_index].append("[수상 경력] \n")
            select_value = "reward_name, host, content"

        elif table_name[0] == "user_overseas_info" :
            career_table[table_index].append("[해외 경험] \n")
            select_value = "nation, institution, purpose, reason"  

        
        sql = "SELECT "+ select_value +" FROM " + table_name[0] + " WHERE seeker_id = " + str(seeker_id)
        cursor.execute(sql)
        rows = cursor.fetchall() 
        # print(rows)                 
        # total_table = [["user_career_info"], ["user_project_info"], ["user_reward_info"], ["user_activation_info"], ["user_overseas_info"], ["user_license_info"], ["user_skill_info"]]
        # print(total_table)

        for row in rows :
            # career_table[table_index].append(str(career_index)+" : ")
            tmp_row = list(row)
            print(tmp_row)
            
            # tmp_row2 = list(map(str,tmp_row))
            # print(tmp_row2[1])
            if career_table[table_index][0] == "user_career_info" :
                career_str = "- " + tmp_row[0] + "의 " + tmp_row[1] + " 부서에서 " + tmp_row[2] +" 직무로 근무\n"
                career_table[table_index].append(career_str)
                # print(total_table)
                # career_index += 1
            elif career_table[table_index][0] == "user_project_info" :
                career_str = "- 프로젝트 제목 : " + tmp_row[0] + ", 주최 : " + tmp_row[1] + ", 프로젝트 설명 : " + tmp_row[2] + ", 사용 기술 : " + tmp_row[3] + "\n"
                career_table[table_index].append(career_str)

            elif career_table[table_index][0] == "user_reward_info" :
                career_str = "- " + tmp_row[1] + "에서 " + tmp_row[0] + "을(를) 받음" + ", 수상 이유는 " + tmp_row[2] + "\n"
                career_table[table_index].append(career_str)    
            
            elif career_table[table_index][0] == "user_activation_info" :
                career_str = "- 활동명 : " + tmp_row[0] + ", 활동 내용 : " + tmp_row[1] + "\n"
                career_table[table_index].append(career_str)

            elif career_table[table_index][0] == "user_overseas_info" :
                career_str = "- 거주 국가 : " + tmp_row[0] + ", 소속 기관 : " + tmp_row[1] + ", 거주 목적 : " + tmp_row[2] + ", 거주 사유 : " + tmp_row[3] + "\n"
                career_table[table_index].append(career_str)

            elif career_table[table_index][0] == "user_skill_info" :
                career_str = "- " + tmp_row[0] + "\n"
                career_table[table_index].append(career_str)
                # print(total_table)
                # career_index += 1
            # for i in range(len(tmp_row)) :
                
                
                # print(tmp_str)
        #     for tmp in row :
        #         career_table[table_index].append(tmp)
        #         # print(rowArr)
        #         # print(career_table[table_index]) 

                       
            
            
        career_table[table_index].pop(0)
        # # print(career_table[table_index][0])
        


        career_table[table_index].append(' '.join(map(str, career_table[table_index])))
        #     # career_table[table_index].append(list(career_table[table_index]))
            
        #     # rowArr.clear()
        
        # list(map(str, career_table[table_index]))     
        table_index += 1
        # total_table.append([])
        # career_index += 1
    cursor.close()
    conn.close()
    return career_table

# career_table[0][len(career_table[0])-1]

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

# 유저 기본(개인)정보 가져오기
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


@app.route("/test_portfolio_career_table/<seeker_id>")
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
            tmp_row = list(row)
            # print(tmp_row)
            career_table[table_index].append(tmp_row)

        # rowArr.clear()
        career_table[table_index].pop(0)
        list(map(str, career_table[table_index]))     
        table_index += 1

    # print(career_table[1][0])
    cursor.close()
    conn.close()
    
    return career_table


# 문장 별 수정 위한 position, 자소서 질문 가져오기 
@app.route("/sentence_question/<question_id>")
def sentence_question(question_id) :
    conn = dbconn.db_connect()

    cursor = conn.cursor()
        
    sql = "SELECT position, question FROM question WHERE question_id = " + str(question_id) 
    cursor.execute(sql)
    rows = list(cursor.fetchall())

    list(map(str, rows))

    cursor.close()
    conn.close()
    return rows

# 문장별 수정 위한 저장된 자소서 전체 글 가져오기
@app.route("/resume_select/<resume_id>")
def resume_select(resume_id) :

    conn = dbconn.db_connect()
    cursor = conn.cursor()
        
    sql = "SELECT content FROM resume WHERE resume_id = " + str(resume_id) 
    cursor.execute(sql)
    rows = list(cursor.fetchone())

    cursor.close()
    conn.close()
    return rows

# 1000자, 1000byte 구분위해 숫자, 문자 split해주는 함수
def split_str_num(str_num):
    for index in range(len(str_num)):
        if not str_num[index].isdigit():
            return str_num[:index], str_num[index:]
        
# 자소서 자동생성 method
@app.route("/resume_create/<seeker_id>/<company_id>/<company_name>/<position>")
def resumeCreate(seeker_id, company_id, company_name, position):
    
    matching_arr = resume_matching(seeker_id, company_id, company_name, position)
    print(matching_arr)
    matching_index = 0
    # total_table = career_table_select(seeker_id)
    # company_value[0~3] = 순서 : question_id,  position, question, length
    company_table = company_table_select(company_id, position)
    result_arr = []

    for company_value in company_table :

        # 직무, 자소서 질문, 자소서 최대 길이
        # position = company_value[1]
        resume_question = company_value[2]
        question_text_max = company_value[3]

        question_length_num, question_length_str = split_str_num(question_text_max)
        question_length_min = str(int(question_length_num) - 100)

        # print("num : " + result_num)
        # print("str : " + result_str)

        # Call the chat GPT API 
        completion = openai.ChatCompletion.create(
            model="gpt-4",
            messages=[
            {"role": "system", "content": ("너는 내가 제공하는 이력 정보 기반으로 "
                                        "기업 자기소개서 질문과 지원 직무에 맞추어 기업에 제출할 자기소개서를 작성해주는 AI야")},

            {"role": "assistant", "content": ("자기소개서를 작성하는데 유의할 점이 있나요?")},
            {"role": "user", "content": ("인삿말(감사합니다, 안녕하세요)과 이름 소개는 쓰지말고, 두괄식으로 작성해줘")},

            {"role": "assistant", "content": ("기업명과 지원 직무, 자기소개서 질문, 자기소개서 글자 수 범위를 알려주세요.")},
            {"role": "user", "content":f"지원할 기업의 기업명 : {company_name}\n"},
            {"role": "user", "content":f"지원 직무 : {position}\n"},
            {"role": "user", "content":f"자기소개서 질문 : {resume_question}\n"},
            {"role": "user", "content":f"자기소개서 최대 글자수 : {question_length_min}{question_length_str} ~ {question_length_num}{question_length_str} 사이"},
            
            {"role": "assistant", "content": ("자기소개서 질문에 적용하고 싶은 이력 정보가 있나요?")},
            {"role": "user", "content": f"{matching_arr[0][matching_index]} \n 첫 줄은 자기소개서 질문이고, 그 다음에 있는 해당하는 이력 정보를 기반으로 자기소개서를 작성해줘"},

            {"role": "assistant", "content": f"{company_name} {position} 직무의 자기소개서를 작성해드리도록 하겠습니다."},
            
            {"role": "assistant", "content": ("작성된 자기소개서에 추가할 부분이 있나요?")},
            {"role": "user", "content": ("제일 첫 번째 줄에는 []안에 작성된 자기소개서 내용의 제목을 간략하게 작성해줘")},
            ],
            # repetition_penalty=1.2,
            temperature=0.8,
            max_tokens=2048
        )

        # # Call the chat GPT API 
        # completion = openai.ChatCompletion.create(
        #     model="gpt-4",
        #     messages=[
        #     {"role": "system", "content": ("너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 "
        #                                 "기업 자기소개서 질문과 지원 직무에 맞추어 기업에 제출할 자기소개서를 작성해주는 AI야")},

        #     {"role": "assistant", "content": ("자기소개서를 작성하는데 유의할 점이 있나요?")},
        #     {"role": "user", "content": ("인삿말(감사합니다, 안녕하세요)과 이름 소개는 쓰지말고, 두괄식으로 작성해줘"
        #                                 "그리고 내가 제공해주는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 중 없는 것이 있다면 참고하지 말아줘 ")},

        #     {"role": "assistant", "content": ("인삿말과 이름 소개를 쓰지 않도록 하겠습니다. 더 유의할 점이 있나요?")},
        #     {"role": "user", "content": ("내가 제공하는 정보를 너무 다양하고 얕게 작성하지말고 1~2개 정도의 정보를 기반으로 구체적으로 자기소개서를 작성해줘")},

        #     {"role": "assistant", "content": ("자기소개서를 작성하기 위해 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주세요.")},
                                            
        #     {"role": "user", "content":f"{total_table[0][len(total_table[0])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[1][len(total_table[1])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[2][len(total_table[2])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[3][len(total_table[3])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[4][len(total_table[4])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[5][len(total_table[5])-1]}\n"},
        #     {"role": "user", "content":f"{total_table[6][len(total_table[6])-1]}\n"},

        #     {"role": "assistant", "content": ("기업명과 지원 직무, 자기소개서 질문, 자기소개서 글자 수 범위를 알려주세요.")},
        #     {"role": "user", "content":f"지원할 기업의 기업명 : {company_name}\n"},
        #     {"role": "user", "content":f"지원 직무 : {position}\n"},
        #     {"role": "user", "content":f"자기소개서 질문 : {resume_question}\n"},
        #     {"role": "user", "content":f"자기소개서 최대 글자수 : {question_length_min}{question_length_str} ~ {question_length_num}{question_length_str} 사이"},
            
        #     {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 "
        #                                      f"{company_name} {position} 직무의 자기소개서를 작성해드리도록 하겠습니다."},
        #     {"role": "user", "content":f"자기소개서 내용에 인삿말(감사합니다, 안녕하세요)과 이름 소개가 들어갔다면 그 부분은 삭제해줘"},

        #     {"role": "assistant", "content": ("감사합니다, 안녕하세요와 같은 인삿말이 작성되어 있는 부분은 삭제하겠습니다. 작성된 자기소개서에 추가할 부분이 있나요?")},
        #     {"role": "user", "content": ("제일 첫 번째 줄에는 []안에 작성된 자기소개서 내용의 제목을 간략하게 작성해줘")},
        #     ],
        #     # repetition_penalty=1.2,
        #     temperature=0.8,
        #     max_tokens=2048
        # )
        
        time.sleep(30)    
        
        print(resume_question)
        
        message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()

        matching_index += 1

        result_arr.append([resume_question, question_text_max, message_result])

    # return 'good'
    return jsonify({"result": result_arr})


# ==================================================================================================

# 문장 별 수정 method
@app.route("/sentence_update/<seeker_id>/<resume_id>/<question_id>/<sentence>")
def sentenceUpdate(seeker_id, resume_id, question_id, sentence):

    # question_table[0][0~1] = 순서 : 0 - 직무 , 1 - 문항질문
    question_table = sentence_question(question_id)
    # resume 내용 가져오기
    resume_content = resume_select(resume_id)
    total_table = career_table_select(seeker_id)

    # Call the chat GPT API 
    completion = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
        {"role": "system", "content": ("너는 내가 제공하는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 등을 기반으로 "
                                    "자기소개서를 내가 지정해주는 문장만 수정해주는 AI야")},

        {"role": "assistant", "content": ("자기소개서를 수정하는데 유의할 점이 있나요?")},
        {"role": "user", "content": ("제공해주는 자기소개서 문맥에 맞게 내가 지정해주는 문장만 수정해야해"
                                    "그리고 내가 제공해주는 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보 중 없는 것이 있다면 참고하지 말아줘 ")},

        {"role": "assistant", "content": ("더 유의할 점이 있나요?")},
        {"role": "user", "content": ("답변은 수정한 문장으로만 답변해줘")},

        {"role": "assistant", "content": ("자기소개서를 수정하기 위해 경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 알려주세요.")},
                                        
        {"role": "user", "content":f"{total_table[0][len(total_table[0])-1]}\n"},
        {"role": "user", "content":f"{total_table[1][len(total_table[1])-1]}\n"},
        {"role": "user", "content":f"{total_table[2][len(total_table[2])-1]}\n"},
        {"role": "user", "content":f"{total_table[3][len(total_table[3])-1]}\n"},
        {"role": "user", "content":f"{total_table[4][len(total_table[4])-1]}\n"},
        {"role": "user", "content":f"{total_table[5][len(total_table[5])-1]}\n"},
        {"role": "user", "content":f"{total_table[6][len(total_table[6])-1]}\n"},

        {"role": "assistant", "content": ("지원 직무와 자기소개서 질문, 자기소개서 전체 내용을 알려주세요.")},
        {"role": "user", "content":f"지원 직무 : {question_table[0][0]}\n"},
        {"role": "user", "content":f"자기소개서 질문 : {question_table[0][1]}\n"},
        {"role": "user", "content":f"자기소개서 전체 내용 : {resume_content[0]}\n"},

        {"role": "assistant", "content": ("수정하고 싶은 문장이 무엇인가요?")},
        {"role": "user", "content":f"자기소개서 전체 내용 : {sentence}"},

        {"role": "assistant", "content": f"경력, 프로젝트 경험, 대외 활동, 해외 경험, 수상 경력, 자격증, 스킬정보를 기반으로 "
                                            f"{sentence} 부분을 수정해드리도록 하겠습니다. 답변은 수정된 문장만 출력됩니다."},
        ],
        # repetition_penalty=1.2,
        temperature=0.8,
        max_tokens=2048
    )

    
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()

    return jsonify({"result": message_result})

# ==================================================================================================

# 자소서 생성 전, 자소서 문항마다 적용하기 좋은 이력사항 매칭 먼저 해주기 ( 여러개의 문항인데 특정 이력사항만 계속 작성해주는 것을 방지 ) 
@app.route("/resume_matching/<seeker_id>/<company_id>/<company_name>/<position>")
def resume_matching(seeker_id, company_id, company_name, position):

    total_table = career_table_select(seeker_id)
    # company_value[0~3] = 순서 : question_id,  position, question, length
    question_table = company_table_select(company_id, position)
    question_str = ""

    for i in range(len(question_table)) :
        question_str += (str(i+1) + ". " + question_table[i][2] + "\n\n ")

    # Call the chat GPT API 
    completion = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
        {"role": "system", "content": ("너는 내가 제공하는 이력사항을 기반으로 자기소개서 문항과 어울리는 이력사항을 매칭해주는 AI야")},



        {"role": "assistant", "content": ("이력사항과 자기소개서 문항을 매칭하기 위해 이력정보를 알려주세요.")},
                                        
        {"role": "user", "content":f"{total_table[0][len(total_table[0])-1]}\n"},
        {"role": "user", "content":f"{total_table[1][len(total_table[1])-1]}\n"},
        {"role": "user", "content":f"{total_table[2][len(total_table[2])-1]}\n"},
        {"role": "user", "content":f"{total_table[3][len(total_table[3])-1]}\n"},
        {"role": "user", "content":f"{total_table[4][len(total_table[4])-1]}\n"},
        {"role": "user", "content":f"{total_table[5][len(total_table[5])-1]}\n"},
        {"role": "user", "content":f"{total_table[6][len(total_table[6])-1]}\n"},

        {"role": "assistant", "content": ("지원 직무와 자기소개서 문항을 알려주세요.")},
        {"role": "user", "content":f"지원 직무 : {question_table[0][1]}\n"},
        {"role": "user", "content":f"자기소개서 질문 : {question_str}\n"},

        {"role": "assistant", "content": ("문항과 이력사항을 매칭하는데 유의할 점이 있나요?")},
        {"role": "user", "content": ("나의 이력정보를 기반으로 어떤 이력정보를 각각 자기소개서 문항에 적용해서 자기소개서를 작성하는게 좋을지"
                                    "한 문항당 이력정보 1~2개를 문항마다 최대한 중복없이 이력정보를 뽑아줘")},
        ],
        temperature=0.5,
        max_tokens=2048
    )
    
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()

    result_matching = []

    for i in range(len(question_table)-1) :
        message_result = message_result.replace((str(i+2)+". "), '$')
        print(str(i+1)+". ")
        print(message_result)

    result_matching.append(message_result.split('$'))

    return result_matching




# ==================================================================================================

# === myCharacteristic() 기능은 회원 정보 가져오고 gpt통해 회원 성향 다섯가지를 뽑아내기
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

            {"role": "user", "content":f"{total_table[0][len(total_table[0])-1]}\n"},
            {"role": "user", "content":f"{total_table[1][len(total_table[1])-1]}\n"},
            {"role": "user", "content":f"{total_table[2][len(total_table[2])-1]}\n"},
            {"role": "user", "content":f"{total_table[3][len(total_table[3])-1]}\n"},
            {"role": "user", "content":f"{total_table[4][len(total_table[4])-1]}\n"},
            {"role": "user", "content":f"{total_table[5][len(total_table[5])-1]}\n"},
            {"role": "user", "content":f"{total_table[6][len(total_table[6])-1]}\n"},

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

            {"role": "user", "content":f"{total_table[0][len(total_table[0])-1]}\n"},
            {"role": "user", "content":f"{total_table[1][len(total_table[1])-1]}\n"},
            {"role": "user", "content":f"{total_table[2][len(total_table[2])-1]}\n"},
            {"role": "user", "content":f"{total_table[3][len(total_table[3])-1]}\n"},
            {"role": "user", "content":f"{total_table[4][len(total_table[4])-1]}\n"},
            {"role": "user", "content":f"{total_table[5][len(total_table[5])-1]}\n"},
            {"role": "user", "content":f"{total_table[6][len(total_table[6])-1]}\n"},

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

    return jsonify({"result": arr})


@app.route("/make_portfolio/<seeker_id>/<flag>")
def makePortfolio(seeker_id, flag):
    document = MailMerge('./real_kb/portfolio_' + flag +'.docx')
    # 문서의 병합필드 확인
    """
    {'project_name', 'lang_license_number', 'career_attending_check', 'gpa', 'activation_name', 'act_end_date', 'project_skill', 'lang_grade', 'phone', 
    'email', 'skill_grade', 'school_name', 'activation_content', 'sex', 'lang_type', 'act_start_date', 'rewards_acquired_date', 'attending_check', 'language', 
    'license_acquired_date', 'license_license_number', 'department', 'ename', 'graduation_date', 'hire_type', 'career_end_date', 'position', 'host_name', 'license_name', 
    'user_name', 'address', 'nation_origin', 'major', 'project_content', 'company_name', 'transfer_check', 'nation', 'oversea_start_date', 'ovesea_institution', 'military', 
    'birthdate', 'oversea_reason', 'lang_agency', 'disabled', 'highest_check', 'oversea_purpose', 'education_type', 'career_start_date', 'oversea_end_date', 'rewards_name', 'license_agency', 
    'institution', 'bohun', 'rewards_host', 'lang_acquired_date', 'entrance_date', 'cname', 'skill_name'}
    """
    #print(document.get_merge_fields())

    user_table = user_info_table(seeker_id)
    career_table = portfolio_career_table(seeker_id)

    #=================================================================================================================================
    #USER_ID,ID,PASSWORD,USER_NAME,BIRTHDATE,SEX,EMAIL,PHONE,USER_STATUS,TSTAMP,MAIL_CHECK,ADDRESS
    #['1', '111', '111', '임찬연', '1998-06-17 10:40:02', '1', 'dksdus@gmail.com', '01012345678', '0', '2023-05-19 10:41:00', '1', '수원']
    #user_table 숫자 값 전부 문자로 바꾸기

    #birthdate
    user_table[4] = user_table[4].split(' ')[0]

    #sex
    if user_table[5] == 0 :
        user_table[5] = '남성'
    else :
        user_table[5] = '여성'
    
    #=================================================================================================================================
    #career_table[0][0] = user_seeker_info
    #SEEKER_ID,ENAME,CNAME,MILITARY,BOHUN,DISABLED,USER_ID,NATION,PROFILE,CATEGORY1_NO,CATEGORY2_NO
    #[1, 'lcy', '凸', 1, 0, 0, 1, '한국', 'fsafasdfasdf', None, None]

    #military
    if career_table[0][0][3] == 0 :
        career_table[0][0][3] = '필'
    elif career_table[0][0][3] == 1 :
        career_table[0][0][3] = '미필'
    elif career_table[0][0][3] == 2 :
        career_table[0][0][3] = '면제'
    elif career_table[0][0][3] == 3 :
        career_table[0][0][3] = '복무중'
    elif career_table[0][0][3] == 4 : 
        career_table[0][0][3] = '해당없음'
    
    #bohun
    if career_table[0][0][4] == 0 :
        career_table[0][0][4] = '대상'
    elif career_table[0][0][4] == 1 :
        career_table[0][0][4] = '비대상'
    
    #disabled
    if career_table[0][0][5] == 0 :
        career_table[0][0][5] = '대상'
    elif career_table[0][0][5] == 1 :
        career_table[0][0][5] = '비대상'

    #=================================================================================================================================

    # 직접 값을 채워보자
    ## 유동적인 필드 값을 처리하기 위해 필드 담는 변수 초기화 ##
    language_fields = []
    #LANGUAGE_ID,LANGUAGE,TYPE,GRADE,ACQUIRED_DATE,LICENSE_NUMBER,SEEKER_ID,AGENCY
    #[[1, '영어', 'TOEIC', '900', datetime.datetime(2023, 5, 16, 10, 51, 7), '12345-678', 1, '한국토익위원회']]
    #print(career_table[1])

    for language in career_table[1]:
        language_fields.append({
            'language': language[1],
            'lang_type': language[2],
            'lang_grade': language[3],
            'lang_acquired_date': language[4].strftime("%Y-%m-%d"),
            'lang_license_number': language[5],
            'lang_agency': language[7]
        })
    
    skill_fields = []
    for skill in career_table[2]:
        if skill[2] == 0 :
            skill[2] = '하'
        elif skill[2] == 1 :
            skill[2] = '중'
        elif skill[2] == 2 :
            skill[2] = '상'

        skill_fields.append({
            'skill_name': skill[1],
            'skill_grade': skill[2],
        })
    print(skill_fields)

    license_fields = []
    #LICENSE_ID,LICENSE_NAME,GRADE,ACQUIRED_DATE,LICENSE_NUMBER,AGENCY,SEEKER_ID
    #[[1, '정보처리기사', None, datetime.datetime(2022, 9, 14, 10, 53, 35), '1234-5678', '정처기위원회', 1]]
    for license in career_table[3]:
        license_fields.append({
            'license_name': license[1],
            'license_acquired_date': license[3].strftime("%Y-%m-%d"),
            'license_license_number': license[4],
            'license_agency': license[5]
        })

    school_fields = []
    #SCHOOL_ID,EDUCATION_TYPE,SCHOOL_NAME,ENTRANCE_DATE,GRADUATION_DATE,MAJOR,ATTENDING_CHECK,TRANSFER_CHECK,GPA,HIGHEST_CHECK,SEEKER_ID,DOUBLE_MAJOR
    #[[1, 0, '멀캠고', datetime.datetime(2017, 3, 1, 11, 9, 31), datetime.datetime(2019, 2, 27, 11, 9, 40), None, 1, None, None, 0, 1, None], [2, 1, '멀캠대', datetime.datetime(2019, 3, 4, 11, 10, 29), datetime.datetime(2023, 2, 15, 11, 10, 40), '컴퓨터공학과', 1, 0, '4.5', 1, 1, None]]
    
    for school in career_table[4]:
        if school[0] == 0 :
            school[0] = '고졸'
        elif school[0] == 1 :
            school[0] = '초대졸'
        elif school[0] == 2 :
            school[0] = '학사'
        elif school[0] == 3 :
            school[0] = '석사'
        elif school[0] == 4 : 
            school[0] = '박사'
        
        if school[1] == 0 :
            school[1] = ""
        elif school[1] == 1 :
            school[1] = "최종학력"
        
        if school[6] == 0 :
            school[6] = '재학'
        elif school[6] == 1 :
            school[6] = '휴학'
        elif school[6] == 2 :
            school[6] = '졸업'
        
        if school[7] == 0 :
            school[7] = '대상'
        elif school[7] == 1 :
            school[7] = '비대상'

        if school[5] == 'None' :  
            school[5] = ""
        if school[8] == 'None' :  
            school[8] = ""
        if school[11] == 'None' :  
            school[11] = ""

        school_fields.append({
            'education_type': school[0],
            'highest_check': school[1],
            'school_name': school[2],
            'entrance_date': school[3].strftime("%Y-%m-%d"),
            'graduation_date': school[4].strftime("%Y-%m-%d"),
            'attending_check': school[6],
            'major': school[5],
            'gpa': school[8],
            'transfer_check': school[7]
        })

    career_fields = []
    #CAREER_ID,COMPANY_NAME,DEPARTMENT,POSITION,START_DATE,END_DATE,ATTENDING_CHECK,HIRE_TYPE,SEEKER_ID
    #[[1, '네이버', '프론트엔드', '개발자', datetime.datetime(2023, 1, 17, 15, 57, 6), datetime.datetime(2023, 3, 23, 15, 57, 13), 0, 0, 1]]
    for career in career_table[5]:
        if career[6] == 0 :
            career[6] = '재직중'
        else :
            career[6] = '퇴사'
        
        if career[7] == 0 :
            career[7] = '정규직'
        elif career[7] == 1 :
            career[7] = '비정규직'
        else :
            career[7] = '인턴'

        career_fields.append({
            'company_name': career[1],
            'department': career[2],
            'position': career[3],
            'career_start_date': career[4].strftime("%Y-%m-%d"),
            'career_end_date': career[5].strftime("%Y-%m-%d"),
            'career_attending_check': career[6],
            'hire_type': career[7]
        })

    project_fields = []
    #PROJECT_ID,PROJECT_NAME,HOST_NAME,CONTENT,SKILL,SEEKER_ID,INSTITUTION
    #[[1, '웹 크롤링을 통한 외래어 빈도 분석', 'KDB 산업은행', '국어문화원 교수님과 진행한 지방자치단체 홈페이지의 특정 게시판 웹크롤링을 통하여 외래어 빈도 수를 체크하는 프로그램 제작', 'python', 1, '산업은행']]    
    for project in career_table[6]:
        project_fields.append({
            'project_name': project[1],
            'host_name': project[2],
            'project_content': project[3],
            'project_skill': project[4],
            'institution': project[6]
        })

    activation_fields = []
    #ACTIVATION_ID,ACTIVATION_NAME,START_DATE,END_DATE,CONTENT,SEEKER_ID
    #[[1, '봉사활동', datetime.datetime(2023, 1, 16, 15, 55, 33), datetime.datetime(2023, 3, 11, 15, 55, 39), '쓰레기를 주웠습니다.', 1]]
    for activation in career_table[7]:
        activation_fields.append({
            'activation_name': activation[1],
            'act_start_date': activation[2].strftime("%Y-%m-%d"),
            'act_end_date': activation[3].strftime("%Y-%m-%d"),
            'activation_content': activation[4]
        })

    rewards_fields = []
    #REWARD_ID,REWARD_NAME,ACQUIRED_DATE,HOST,CONTENT,SEEKER_ID
    #[[1, '개근상', datetime.datetime(2022, 5, 18, 11, 8, 49), '멀캠고등학교', '출석을 잘 해서 개근상을 받음', 1]]
    for rewards in career_table[8]:
        rewards_fields.append({
            'rewards_name': rewards[1],
            'rewards_acquired_date': rewards[2].strftime("%Y-%m-%d"),
            'rewards_host': rewards[3]
        })

    overseas_fields = []
    #OVERSEAS_ID,PURPOSE,NATION,START_DATE,END_DATE,INSTITUTION,REASON,SEEKER_ID
    #[[1, '어학연수', '미국', datetime.datetime(2021, 5, 6, 11, 6, 47), datetime.datetime(2021, 12, 23, 11, 6, 53), '대행사', '영어를 잘하고싶어요', 1]]
    for overseas in career_table[9]:
        overseas_fields.append({
            'oversea_purpose': overseas[1],
            'nation': overseas[2],
            'oversea_start_date': overseas[3].strftime("%Y-%m-%d"),
            'oversea_end_date': overseas[4].strftime("%Y-%m-%d"),
            'ovesea_institution': overseas[5],
            'oversea_reason': overseas[6]
        })
    
    document.merge(
        # 고정 필드들은 그대로 유지
        # 기본 인적사항
        user_name=user_table[3],
        birthdate=user_table[4],  # front = ex)990605 이런식으로 적도록 / db = varchar
        sex=user_table[5],
        address=user_table[11],
        phone=user_table[7],
        email=user_table[6],

        # userd_seeker
        ename=career_table[0][0][1],
        cname=career_table[0][0][2],
        nation_origin=career_table[0][0][7],
        military=career_table[0][0][3],  # career_table[0][0][3] , front = option value "면제" / db = varchar /// 이건 form도 만들어야함
        bohun=career_table[0][0][4],
        disabled=career_table[0][0][5],  # career_table[0][0][5], 장애여부, 해당 미해당 form 필요 병역과 같은 form으로 하면 될듯
    )

    for l in language_fields :
        document.merge(**l)
    
    for s in skill_fields :
        document.merge(**s)
    
    for l in license_fields :
        document.merge(**l)
    
    for s in school_fields :
        document.merge(**s)
    
    for c in career_fields :
        document.merge(**c)
    
    for p in project_fields :
        document.merge(**p)
    
    for a in activation_fields :
        document.merge(**a)
    
    for r in rewards_fields :
        document.merge(**r)
    
    for o in overseas_fields :
        document.merge(**o)

    output_blob = BytesIO()
    document.write(output_blob)
    output_blob.seek(0)

    result_blob = output_blob.getvalue()

    return result_blob

    # 필드 병합된 결과의 포트폴리오를 직접 생성...파일명도 필드명을 참고해서
    # document.write('./real_kb/portfolio.docx')


if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)