import time
import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from bs4 import BeautifulSoup
from urllib.request import urlopen

# 웹 드라이버 실행
driver = webdriver.Chrome()

# 크롤링할 웹 페이지 URL 설정
# url = 'https://jasoseol.com/recruit/81415'
url = 'https://jasoseol.com/recruit/82000'

# 웹 페이지 열기
driver.get(url)

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

time.sleep(5)

hover_element = driver.find_element(By.XPATH,'/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr[1]/td[4]/div')

# ActionChains 객체를 생성합니다.
action_chains = ActionChains(driver)

# 마우스를 hover_element 요소로 이동합니다.
action_chains.move_to_element(hover_element).perform()

# 마우스를 이동한 후에 실행할 작업을 수행합니다.
print('Mouse hover event executed successfully!')

# 웹 페이지 소스코드 가져오기
html = driver.page_source

# BeautifulSoup으로 HTML 파싱
soup = BeautifulSoup(html, 'html.parser')

## title
title = soup.find('title').text.strip()
print(title)

## All company name
ul = soup.find('ul', attrs={'class': 'question-area ng-scope'})
if ul:
    lis = ul.find_all('li')
    for li in lis:
        div = li.find('div')
        if div:
            print(div.text.strip())
        else:
            print("Inner div element not found")
else:
    print("UL element not found")

# 드라이버 종료
driver.quit()

print("hi")