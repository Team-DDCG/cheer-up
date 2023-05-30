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

    category_table = {
        '경영기획' : 1,
        '사업기획' : 1,
        '경영전략' : 1,
        '사업전략' : 1,
        '경영분석·컨설턴트' : 1,
        '인사' : 2,
        '노무' : 2,
        '교육' : 2,
        '채용' : 2,
        '급여' : 2,
        '보상관리' : 2,
        '재무' : 3,
        '세무' : 3,
        'IR' : 3,
        '자금' : 3,
        '경리·회계·결산' : 4,
        '일반사무' : 5,
        '총무' : 5,
        '비서' : 5,
        '사무보조' : 5,
        '법무' : 6,
        '브랜드마케팅' :7,
        '콘텐츠마케팅' :7,
        '퍼포먼스·온라인마케팅' :7,
        '마케팅전략·기획' :7,
        '상품기획' :7,
        '광고기획·AE' :8,
        '광고제작·카피' :8,
        '언론홍보·PR' :8,
        '사내홍보' :8,
        '물류관리·기획' :9,
        '유통관리·기획' :9,
        '재고' :9,
        '해외영업' :10,
        '무역·수출입관리' :10,
        '구매' :11,
        '자재' :11,
        '운전·운송' :12,
        '상품기획·MD' :13,
        'QA' :14,
        'iOS개발' :15,
        '안드로이드개발' :15,
        '프론트엔드개발' :16,
        '서버·백엔드개발' :16,
        'HTML·퍼블리싱' :16,
        '데이터엔지니어' :17,
        '데이터분석' :17,
        'DBA' :17,
        '시스템프로그래머' :18,
        '응용프로그래머' :19,
        '네트워크·보안·운영' :20,
        '빅데이터·AI(인공지능)' :21,
        '게임개발' :22,
        'HW·임베디드' :23,
        'SW·솔루션·ERP' :24,
        '서비스기획·PM' :25,
        '생산관리' :26,
        '공정관리' :26,
        '품질관리' :26,
        '안전관리' :27,
        '환경관리' :27,
        '생산·제조·설비·조립' :28,
        '설치·정비·AS·시공·공무' :29,
        '제품·서비스영업' :30,
        'IT·솔루션·기술영업' :31,
        'B2B영업·법인영업' :32,
        '영업관리·지원·기획' :33,
        '아웃바운드' :34,
        '인바운드' :35,
        '고객응대·CS' :36,
        '금융·보험영업' :37,
        '현장·시공·감리·공무' :38,
        '안전·품질·관리' :39,
        '전기·통신' :40,
        '기계·설비·화학' :41,
        '토목·조경·도시' :42,
        '건축·설계·인테리어' :43,
        '환경·플랜트' :44,
        '부동산·영업·견적' :45,
        '증권·투자' :46,
        '외환·펀드·자산운용' :47,
        '보험계리사·손해사정' :48,
        '채권·심사' :49,
        '은행원' :50,
        '애널리스트' :51,
        '자동차' :52,
        '기계' :52,
        '화학' :53,
        '에너지' :53,
        '환경' :53,
        '화장품' :53,
        '바이오·제약' :54,
        '식품' :54,
        '기계설계·CAD·CAM' :55,
        '전기·전자·제어' :56,
        '반도체·디스플레이' :57,
        '통신기술·네트워크 구축' :58,
        '금속·철강' :59,
        '조선·항공·우주' :60,
        '인문·사회과학' :61,
        '광고 디자인' :62,
        '그래픽디자인·CG' :62,
        '출판·편집디자인' :62,
        '캐릭터·애니메이션' :62,
        '제품·산업디자인' :63,
        '건축·인테리어디자인' :64,
        '의류·패션·잡화디자인' :65,
        'UI·UX디자인' :66,
        '연출·제작·PD·작가' :67,
        '음악·영상·사진' :68,
        '아나운서·리포터·성우·기자' :69,
        '무대·스탭·오퍼레이터' :70,
        '연예·엔터테인먼트' :71,
        '인쇄·출판·편집' :72,
        '리서치·시장조사' :73,
        '외국어·번역·통역' :74,
        '법률·특허·상표' :75,
        '회계·세무·CPA·CFA' :76,
        '보안·경비·경호' :77,
        '보건·의료' :78,
        '초·중·고 교사' :79,
        '교육개발·기획' :80,
        '외국어·자격증·기술강사' :81,
        '사회복지·요양보호·자원봉사' :82,
        '승무원·숙박·여행 서비스' :83,
        '음식서비스' :84
    }

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
    

    logo_url = soup.find('div', attrs={'class':'ec-image'}).find('img').get('src')

    img_url = soup.find('meta', attrs={'property':'og:image'}).get('content')
    # start_date, end_date
    term = soup.find('span', attrs={'class':'time'})
    if term == None :
        start_date = None
        end_date = None
    else :
        times = term.find_all('span')
        start_date = times[0].text
        end_date = times[1].text

    a_tag = soup.find('a', attrs={'class':'ec-option-letters'})
    site = a_tag.get('href')

    cursor = conn.cursor()
    sql_check_duplicate = "SELECT COUNT(*) FROM company WHERE company_name = :company_name"
    cursor.execute(sql_check_duplicate, {'company_name': name})
    check_duplicate = cursor.fetchone()

    if check_duplicate[0] == 0 :
        sql = "INSERT INTO company VALUES(company_seq.NEXTVAL, :company_name, :start_date, :end_date, :company_logo, :title, :company_url, :content)"
        cursor.execute(sql, {'company_name' : name,
                            'start_date' : start_date,
                            'end_date' : end_date,
                            'company_logo' : logo_url,
                            'title' : name,
                            'company_url' : site,
                            'content' : img_url})
        conn.commit()

    ## description (마감일, 직무분야)
    description = soup.find('meta', attrs={'name':'description'}).get('content')
    print("==============description========================")
    print(description)

    result = description.split(" 조회수 ")[1]
    categories = result.split("/")
    ## first, last data need to fit
    categories[0] = categories[0].split("회 ")[1]
    length = len(categories)-1
    categories[length] = categories[length].split("; ")[0]
    # print("====categories1====") #Question
    # print("카테고리 1 직무 갯수 : " + str(len(categories)))
    ## script (채용공고 정보가 있는 경우도 있고 없는 경우도 있음)
    # script = soup.find('script', attrs={'type':'application/ld+json'}).text
    # print("=======================categories=======================")
    # print(categories) # 직무
    # print(len(categories))

    # title (공고명, 소분류)
    title = soup.find('title').text.strip()
    # print(title)
    temp = title.split(" 채용공고 2023 ")
    name = temp[0]
    print(name)
    print()
    result = temp[1].split(" - ")[0]

    #################################
    #신입/인턴/계약직 사업기획, 경영전략, 사업전략, 채용, 재무, 네트워크·보안·운영, 빅데이터·AI(인공지능), iOS개발, 안드로이드개발, 기타, 프론트엔드개발, 서버·백엔드개발, HTML·퍼블리싱, 데이터엔지니어, 데이터분석, DBA, 증권·투자, 외환·펀드·자산운용, 채권·심사, 은행원, 법률·특허·상표, 회계·세무·CPA·CFA
    filter = result.split(" ")
    print(filter[0])

    filter_list = filter[1:]
    categories2 = [element.replace(",", "") for element in filter_list] #직무분류

    #company_category relation 값 넣기
    conn.cursor()
    sql_check_duplicate = "SELECT COUNT(*) FROM company WHERE company_name = :company_name"
    cursor.execute(sql_check_duplicate, {'company_name': name})
    check_duplicate = cursor.fetchone()

    for c in categories2 :  
        if c in category_table.keys() : 
            sql_id_check = "SELECT company_id FROM company WHERE company_name = :company_name"
            cursor.execute(sql_id_check, {'company_name': name})
            result2 = cursor.fetchone()[0]

            sql_relation = "INSERT INTO company_category_relation VALUES(company_category_relation_seq.NEXTVAL, :category2_id, :company_id )"
            cursor.execute(sql_relation, {'company_id' : result2, 'category2_id' : category_table[c]})
            conn.commit()
    
    # print("========================categories2============================")
    # print(categories2) # 직무 분류
    # print(len(categories2))
    # print()

    #################################
    #신입/인턴/계약직 사업기획, 경영전략, 사업전략, 채용, 재무, 네트워크·보안·운영, 빅데이터·AI(인공지능), iOS개발, 안드로이드개발, 기타, 프론트엔드개발, 서버·백엔드개발, HTML·퍼블리싱, 데이터엔지니어, 데이터분석, DBA, 증권·투자, 외환·펀드·자산운용, 채권·심사, 은행원, 법률·특허·상표, 회계·세무·CPA·CFA

    ## 자소서 갯수찾기
    elements = driver.find_elements(By.XPATH, '/html/body/div/div/div[2]/div/div[4]/div/div[2]/div/div/div[2]/recruit-slide/div[1]/div[2]/table/tbody/tr')
    element_count = len(elements)
    # print("====element_count====")
    # print(element_count)
    # print()
    

    #################################
    if element_count == 1:
        # 웹 페이지 소스코드 가져오기
        html = driver.page_source

        # BeautifulSoup으로 HTML 파싱
        soup = BeautifulSoup(html, 'html.parser')
        field = soup.find('td', attrs={'class': 'field ng-binding'})

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
            lis = ul.find_all('li')
            for li in lis:
                div1 = li.find('div')
                if div1:
                    question = div1.text.strip()
                else:
                    print("Inner div element not found")
                div2 = li.find('div', attrs={'class': 'count'})
                span = div2.find('span')
                if span:
                    length = span.text.strip()
                else:
                    print("Span element not found")
                
                sql_id_check = "SELECT company_id FROM company WHERE company_name = :company_name"
                cursor.execute(sql_id_check, {'company_name': name})
                result2 = cursor.fetchone()[0]
                sql = "INSERT INTO question VALUES(question_seq.NEXTVAL, :position, :question, :length, :company_id)"
                cursor.execute(sql, {'position': field.text,
                                    'question': question,
                                    'length': length,
                                    'company_id': result2})
                conn.commit()

        else:
            print("UL element not found")
    else:
        for i in range(1, element_count+1):
            # 웹 페이지 소스코드 가져오기
            html = driver.page_source

            # BeautifulSoup으로 HTML 파싱
            soup = BeautifulSoup(html, 'html.parser')
            field = soup.find('td', attrs={'class': 'field ng-binding'})

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
                        question = div1.text.strip()
                    else:
                        print("Inner div element not found")
                    div2 = li.find('div', attrs={'class': 'count'})
                    span = div2.find('span')
                    if span:
                        length = span.text.strip()
                    else:
                        print("Span element not found")
                    
                    

                    sql_id_check = "SELECT company_id FROM company WHERE company_name = :company_name"
                    cursor.execute(sql_id_check, {'company_name': name})
                    result2 = cursor.fetchone()[0]
                    sql = "INSERT INTO question(question_id, position,question,length,company_id) VALUES(question_seq.NEXTVAL, :position, :question, :length, :company_id)"
                    cursor.execute(sql, {'position': field.text,
                                        'question': question,
                                        'length': length,
                                        'company_id': result2})
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

    start = 81415
    end = 81415
    
    for i in range(start, end+1):
        crawling(driver, i)

    # 드라이버 종료
    driver.quit()

    print("END")