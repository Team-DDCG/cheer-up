from flask import Flask
from flask import request, jsonify
from flask_cors import CORS

import openai
import cx_Oracle
# import os
app = Flask(__name__)
CORS(app)

# API_KEY= os.getenv("FLASK_API_KEY")

from pathlib import Path
import os, json


# Build paths inside the project like this: BASE_DIR / 'subdir'.
# BASE_DIR = Path(__file__).resolve().parent.parent
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

@app.route("/")
def chatGPT():
    # set api key
    openai.organization = SECRET_KEY
    openai.api_key = ORGANIZATION

    text = "멋있는 슬로건 하나만 알려줘"
    # Call the chat GPT API
    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
         {"role": "user", "content": f"{text}"},
        ],
        temperature=0,
        max_tokens=2048
    )
    print(text)
    message_result = completion["choices"][0]["message"]["content"].encode("utf-8").decode()
    print(message_result)

    dns = cx_Oracle.makedsn('127.0.0.1', 1521, 'xe')
    conn = cx_Oracle.connect('kb_db', '1234', dns)
    cursor = conn.cursor()
    sql = "INSERT INTO resume_test VALUES('" +text+"', '" +message_result+ "')"
    cursor.execute(sql)
    conn.commit()
    conn.close()

    return jsonify({"result": message_result})

if __name__ == '__main__':
    app.run(host = '127.0.0.1', debug=True, port=5000)
# @app.route('/')
# def hello_world():
#     return 'hello'