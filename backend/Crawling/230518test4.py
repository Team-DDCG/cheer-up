import time
import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from bs4 import BeautifulSoup
from urllib.request import urlopen
import re
import json

# 웹 드라이버 실행
driver = webdriver.Chrome()

# 크롤링할 웹 페이지 URL 설정
# url = 'https://jasoseol.com/recruit/81415'
url = 'https://jasoseol.com/recruit/'

# 웹 페이지 열기
driver.get(url)

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

time.sleep(5)

# <div class="tab_right"> 요소를 찾아 클릭
element = driver.find_element(By.CLASS_NAME, 'tab_right')
element.click()

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))
# wait.until(EC.title_contains('Expected Title'))

# <input class="email ng-valid ng-dirty ng-valid-parse ng-touched"> 요소를 찾아 값을 채워 넣음
email_input = driver.find_element(By.CLASS_NAME, 'email')
email_input.clear()  # 기존 값 지우기
email_input.send_keys('ID')  # 새로운 값 입력

pw_input = driver.find_element(By.CLASS_NAME, 'password')
pw_input.clear()  # 기존 값 지우기
pw_input.send_keys('PW')  # 새로운 값 입력

login = driver.find_element(By.CLASS_NAME, 'sign-in-btn')
login.click()

time.sleep(5)

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

#################################################
# 230518test.py

# 크롤링할 웹 페이지 URL 설정
url = 'https://jasoseol.com/recruit/81415'
# url = 'https://jasoseol.com/recruit/82000'

# 웹 페이지 열기
driver.get(url)

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

time.sleep(5)

## 자소서 갯수찾기
elements = driver.find_elements(By.XPATH, '/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr')
element_count = len(elements)
print(element_count)

# 웹 페이지 소스코드 가져오기
html = driver.page_source

# BeautifulSoup으로 HTML 파싱
soup = BeautifulSoup(html, 'html.parser')

## title (공고명, 소분류)
title = soup.find('title').text.strip()
# print(title)
name = result = title.split(" ")[0]
print(name)
print()
result = title.split(" - ")[0]
categories = result.split(", ")
## first data cut
categories[0] = categories[0].split(" ")[4]
print(categories)
print()
## description (마감일, 직무분야)
description = soup.find('meta', attrs={'name':'description'}).get('content')
# print(description)
match = re.search(r"\d+년 \d+월 \d+일", description)
if match:
    date = match.group()
    print(date)
else:
    print("Date not found")
print()

result = description.split(" 조회수 ")[1]
categories = result.split("/")
## first, last data need to fit
categories[0] = categories[0].split("회 ")[1]
length = len(categories)-1
categories[length] = categories[length].split("; ")[0]
print(categories)
print()
## script (채용공고 정보가 있는 경우도 있고 없는 경우도 있음)
script = soup.find('script', attrs={'type':'application/ld+json'}).text
# print(script)
# JSON으로 변환
json_data = json.dumps(script)
print(json_data)
print()


if element_count == 1:
    hover_element = driver.find_element(By.XPATH,'/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr/td[4]/div')    
else:
    for i in range(1, element_count+1):
        hover_element = driver.find_element(By.XPATH,'/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr['+str(i)+']/td[4]/div')

        # ActionChains 객체를 생성합니다.
        action_chains = ActionChains(driver)

        # 마우스를 hover_element 요소로 이동합니다.
        action_chains.move_to_element(hover_element).perform()

        # 마우스를 이동한 후에 실행할 작업을 수행합니다.
        print('Mouse hover event executed successfully!')

        time.sleep(1)

        # 웹 페이지 소스코드 가져오기
        html = driver.page_source

        # BeautifulSoup으로 HTML 파싱
        soup = BeautifulSoup(html, 'html.parser')

        # All company name
        ul = soup.find('ul', attrs={'class': 'question-area ng-scope'})
        if ul:
            lis = ul.find_all('li')
            for li in lis:
                div1 = li.find('div')
                if div1:
                    print(div1.text.strip())
                else:
                    print("Inner div element not found")
                div2 = li.find('div', attrs={'class': 'count'})
                span = div2.find('span')
                if span:
                    print(span.text.strip())
                else:
                    print("Span element not found")
            
        else:
            print("UL element not found")
##################################################

# 드라이버 종료
driver.quit()

print("hi")