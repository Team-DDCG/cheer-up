import time
import selenium
import dbconn
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from bs4 import BeautifulSoup
from urllib.request import urlopen
import re
from pathlib import Path
import os, json

def json_read():

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
    ID = get_secret("ID")
    PW = get_secret("PW")

    return ID, PW

def driver_open():
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

    return driver


def login(driver, ID, PW):
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
    email_input.send_keys(ID)  # 새로운 값 입력

    pw_input = driver.find_element(By.CLASS_NAME, 'password')
    pw_input.clear()  # 기존 값 지우기
    pw_input.send_keys(PW)  # 새로운 값 입력

    login = driver.find_element(By.CLASS_NAME, 'sign-in-btn')
    login.click()

    time.sleep(5)

    # 페이지 로딩이 완료될 때까지 대기
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

    return driver

def crawling(driver, number):
    # 크롤링할 웹 페이지 URL 설정

    #span에 글자수 나오니까
    # Categories 에서 빈  배열 선언 후, for

    conn = dbconn.db_connect()

    url = 'https://jasoseol.com/recruit/'+str(number)
    # url = 'https://jasoseol.com/recruit/81415'
    # url = 'https://jasoseol.com/recruit/82000'

    # 웹 페이지 열기
    driver.get(url)

    # 페이지 로딩이 완료될 때까지 대기
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.TAG_NAME, 'body')))

    time.sleep(5)

    # 웹 페이지 소스코드 가져오기
    html = driver.page_source

    # BeautifulSoup으로 HTML 파싱
    soup = BeautifulSoup(html, 'html.parser')

    ## title (공고명, 소분류)
    title = soup.find('title').text.strip()
    temp = title.split(" 채용공고 2023 ")
    name = temp[0]
    print("====title====")
    print(name)
    print("====company_name====")
    print(name)
    print()
    result = temp[1].split(" - ")[0]

    logo_url = soup.find('div', attrs={'class':'ec-image'}).find('img').get('src')
    print("====company_logo====")
    print(logo_url)

    img_url = soup.find('meta', attrs={'property':'og:image'}).get('content')
    print("====content====")
    print(img_url)
    # start_date, end_date
    term = soup.find('span', attrs={'class':'time'})
    print(term)
    if term == None :
        start_date = None
        end_date = None
    else :
        times = term.find_all('span')
        print(len(times))
        print("====start_date====")
        start_date = times[0].text
        print(start_date)
        print("====end_date====")
        end_date = times[1].text
        print(end_date)

    a_tag = soup.find('a', attrs={'class':'ec-option-letters'})
    site = a_tag.get('href')
    print("====compan_url====")
    print(site)


    cursor = conn.cursor()
    sql_check_duplicate = "SELECT COUNT(*) FROM company WHERE company_name = :company_name"
    cursor.execute(sql_check_duplicate, {'company_name': name})
    result = cursor.fetchone()

    if result[0] == 0 :
        sql = "INSERT INTO company VALUES(company_seq.NEXTVAL, :company_name, :start_date, :end_date, :company_logo, :title, :company_url, :content)"
        cursor.execute(sql, {'company_name' : name,
                            'start_date' : start_date,
                            'end_date' : end_date,
                            'company_logo' : logo_url,
                            'title' : name,
                            'company_url' : site,
                            'content' : img_url})
        conn.commit()
    #################################

    ## description (마감일, 직무분야)
    description = soup.find('meta', attrs={'name':'description'}).get('content')
    # print(description)
    # match = re.search(r"\d+년 \d+월 \d+일", description)
    # if match:
    #     date = match.group()
    #     print("====date====")
    #     print(date)
    # else:
    #     print("Date not found")
    # print()

    result = description.split(" 조회수 ")[1]
    categories = result.split("/")
    ## first, last data need to fit
    categories[0] = categories[0].split("회 ")[1]
    length = len(categories)-1
    categories[length] = categories[length].split("; ")[0]
    print("====categories1====") #Question
    print(categories)
    print("카테고리 1 직무 갯수 : " + str(len(categories)))
    print()
    ## script (채용공고 정보가 있는 경우도 있고 없는 경우도 있음)
    # script = soup.find('script', attrs={'type':'application/ld+json'}).text

    # # JSON으로 변환
    # json_data = json.dumps(script)
    # print(json_data)
    # print()

    #################################
    #신입/인턴/계약직 사업기획, 경영전략, 사업전략, 채용, 재무, 네트워크·보안·운영, 빅데이터·AI(인공지능), iOS개발, 안드로이드개발, 기타, 프론트엔드개발, 서버·백엔드개발, HTML·퍼블리싱, 데이터엔지니어, 데이터분석, DBA, 증권·투자, 외환·펀드·자산운용, 채권·심사, 은행원, 법률·특허·상표, 회계·세무·CPA·CFA
    filter = result.split(" ")
    # print("====filter[0]====")
    # print(filter[0])
    # print("====filter====")
    filter_list = filter[1:]
    # print(filter_list)

    """
    categories2 = [element.replace(",", "") for element in filter_list]
    # 회사이름 가져오는 Code 삽입 필요
    print("====categories2====") #Question
    print(categories2)
    print("카테고리 2 직무 갯수 : " + str(len(categories2)))
    print()
    """

    ## 자소서 갯수찾기
    elements = driver.find_elements(By.XPATH, '/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr')
    element_count = len(elements)
    print("====element_count====")
    print(element_count)
    print()

    #################################
    if element_count == 1:
        hover_element = driver.find_element(By.XPATH,'/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr/td[4]/div')    
        
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
            print("1번째 직무 입니다!")
            print("직무 명 : " + str(categories[0]))
            lis = ul.find_all('li')
            for li in lis:
                div1 = li.find('div')
                if div1:
                    print("====question====")
                    question = div1.text.strip()
                    print(question)
                else:
                    print("Inner div element not found")
                div2 = li.find('div', attrs={'class': 'count'})
                span = div2.find('span')
                if span:
                    print("====length====")
                    length = span.text.strip()
                    print(length)
                else:
                    print("Span element not found")
                
                sql_id_check = "SELECT company_id FROM company WHERE company_name = :company_name"
                cursor.execute(sql_id_check, {'company_name': name})
                result = cursor.fetchone()[0]
                print(result)
                sql = "INSERT INTO question VALUES(question_seq.NEXTVAL, :position, :question, :length, :company_id)"
                cursor.execute(sql, {'position': categories[0],
                                    'question': question,
                                    'length': length,
                                    'company_id': result})
                conn.commit()
        else:
            print("UL element not found")
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
                print(str(i) + "번째 직무 입니다!")
                print("직무 명 : " + str(categories[i-1]))
                lis = ul.find_all('li')
                for li in lis:
                    div1 = li.find('div')
                    if div1:
                        print("====question====")
                        question = div1.text.strip()
                        print(question)
                    else:
                        print("Inner div element not found")
                    div2 = li.find('div', attrs={'class': 'count'})
                    span = div2.find('span')
                    if span:
                        print("====length====")
                        length = span.text.strip()
                        print(length)
                    else:
                        print("Span element not found")
                    sql_id_check = "SELECT company_id FROM company WHERE company_name = :company_name"
                    cursor.execute(sql_id_check, {'company_name': name})
                    result = cursor.fetchone()[0]
                    sql = "INSERT INTO question VALUES(question_seq.NEXTVAL, :position, :question, :length, :company_id)"
                    cursor.execute(sql, {'position': categories[i-1],
                                        'question': question,
                                        'length': length,
                                        'company_id': result})
                    conn.commit()
            else:
                print("UL element not found")
            
    cursor.close()
    conn.close()


# main 함수 호출하여 프로그램 실행
if __name__ == "__main__":
    ID, PW = json_read()

    driver = driver_open()
    driver = login(driver, ID, PW)

    # KB국민은행 81415
    # KB증권 82000
    # 230519, 82830 is last data

    # crawling(driver, 82000)

    start = 81150
    end = 81170
    
    for i in range(start, end+1):
        crawling(driver, i)

    # 드라이버 종료
    driver.quit()

    print("END")