import time
import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup
from urllib.request import urlopen


# 웹 드라이버 실행
driver = webdriver.Chrome()

# 크롤링할 웹 페이지 URL 설정
url = 'https://jasoseol.com/recruit/'

# 웹 페이지 열기
driver.get(url)

# 페이지 로딩이 완료될 때까지 대기
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

time.sleep(5)
driver.find_element(By.XPATH,'/html/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a').click()

# 웹 페이지 소스코드 가져오기
html = driver.page_source

# BeautifulSoup으로 HTML 파싱
soup = BeautifulSoup(html, 'html.parser')

# 원하는 데이터 추출하기
## title
title = soup.find('title').text.strip()
print(title)

## All company name
divs = soup.find_all('div', attrs={'class':'company-name'})

for div in divs:
    span = div.find('span')
    print(span.text.strip())


## each company click event
aa = soup.find_all('a', attrs={'class':'company'})
print(aa)
for a in aa:
    print(a)


# 드라이버 종료
driver.quit()

print("hi")