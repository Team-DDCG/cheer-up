<template>
  <tool-bar></tool-bar>
  <div id="main">
    <div id="filter">
      <div id="input">
        <div>
          <div>
            <img src="https://d2bovrvbszerbl.cloudfront.net/assets/icon/ic_search-c35fc43a726d9245c9bf98a8d5b101c1a54f7e71d063e2950d4c81b38873b023.svg">
          </div>
          <div>
            <div>
              기업명
            </div>
            <div>
              <div>
                <input type="text" placeholder="기업명을 검색하세요" v-model="searchInput"/>
              </div>
            </div>
          </div>        
        </div>     
      </div>
      <select class="form-select" v-model="selectedOption1">
        <option value="option1">경영·사무</option>
        <option value="option2">마케팅·광고·홍보</option>
        <option value="option3">무역·유통</option>
        <option value="option4">IT·인터넷</option>
        <option value="option5">생산·제조</option>
        <option value="option6">영업·고객상담</option>
        <option value="option7">건설</option>
        <option value="option8">금융</option>
        <option value="option9">연구개발·설계</option>
        <option value="option10">디자인</option>
        <option value="option11">미디어</option>
        <option value="option12">전문·특수직</option>
      </select>
      <select class="form-select" v-model="selectedOption2">
        <option v-for="option in options2" :value="option.value" v-bind:key="option">{{ option.label }}</option>
      </select>
      <button @click.prevent="saveOption" type="submit">저장</button>
    </div>
    <div id="resume">
      <side-bar :listData="company_list" v-model="company" @child-click="handleChildClick"></side-bar>
      <template v-if="company===''">
        <div id="nopost">현재 선택된 채용공고가 없습니다. <br>채용공고를 선택해주세요.</div>
      </template>
      <template v-else>
        <!-- <job-posting v-model="company"></job-posting> -->
        <job-posting :company="company"></job-posting>
      </template>
    </div>
  </div>
  <div class="footer">
    <footer-bar />
  </div>
</template>

<script>
 
import SideBar from '../components/SideBar.vue';
import ToolBar from '../components/ToolBar.vue';
import FooterBar from "../components/FooterBar.vue";
import JobPosting from '../components/JobPosting.vue';
import axios from "axios";

export default {
  components: {SideBar, ToolBar, JobPosting, FooterBar},
  data() {
    return {
      selectedOption1: '',
      selectedOption2: '',
      options2: [], // 두 번째 셀렉트 요소의 옵션 값
      company: '',
      searchInput: '',
      // company: {
      //   post_name: '[KB증권] 2023 대졸 신입사원 공개채용',
      //   logo_url: 'https://daoift3qrrnil.cloudfront.net/company_groups/images/000/002/439/original/KB_Signature_row_kr_3.jpg?1657045156',
      //   company_name: '케이비증권(주)',
      //   start_date: '2023.04.28 10:36',
      //   end_date: '2023.05.09 18:00',
      //   posting_url: 'https://c.incru.it/newjobpost/2023/04_kbintro/intro.png',
      //   site: 'https://kbstar.incruit.com/index_kbstar.asp',
      //   field: ['UB(자산관리) 부문(신입)', 'IB 부문(인턴)', '글로벌 부문(인턴)', '자본시장 부문(인턴)', 'IT 부문(인턴)', 'IT_플랫폼개발 부문(인턴)', 
      //   '데이터·AI 부문(인턴)', 'ICT_장애인 부문(인턴)', '변호사(계약직)', '보훈(신입)', 'ESG동반성장_다문화가족 자녀(신입)', 'UB(기업금융) 부문(신입)', '회계사(계약직)', '리스크 관리 전문가(계약직)', '전략기획 전문가(계약직)', 
      //   '재무관리 전문가(계약직)', '리크루팅 전문가(계약직)', 'ESG동반성장_북한이탈주민(신입)', 'ESG동반성장_기초생활수급자(신입)', 'ESG동반성장_장애인(신입)']
      // },
      company_list: [],
      seekerId: sessionStorage.getItem('seekerId')
    }
  },
  
  methods: {
    handleChildClick(value) {

      // 자식 컴포넌트의 클릭 이벤트 처리 로직
      console.log('자식 컴포넌트에서 전달된 값:', value);
      axios
        .get(this.$store.state.baseUrl+"api/companies/"+value, {
        })
        .then((res) => {
          console.log(res);
          // this.company = res.data[0];
          this.company = res.data;
          console.log(this.company);

          axios
          .get(this.$store.state.baseUrl+"api/companies/position/"+value, {
          })
          .then((res) => {
            console.log(res.data);
            this.company.position = res.data;
          }) 
          .catch((err) => {
            console.log(err)
          });

        }) 
        .catch((err) => {
          console.log(err)
        });
    },
    // Filter Save api
    async saveOption() {
      console.log(this.selectedOption1,this.selectedOption2);
        axios
        .put(this.$store.state.baseUrl+"api/companies/categories/"+this.seekerId, {
          // category1No: this.selectedOption1,
          category2No: this.selectedOption2,
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
    
    },
  },
  computed: {
    list() {
      return this.company_list;
    }
  },
  created() {
     
  },
  mounted() {

  },
  watch: {
    searchInput: function() {
      // alert(this.searchInput);
      axios
        .get(this.$store.state.baseUrl+"api/companies/search/"+this.searchInput, {
        })
        .then((res) => {
          console.log(res);
          this.company_list = res.data;

        }) 
        .catch((err) => {
          console.log(err)
          // this.company_list = [{companyName: 'KB국민은행'},{companyName: 'KB증권'},{companyName: '신한은행'}]
          this.company_list = [{companyName: '가능한 채용공고가 없어요'}]
        });
    },
    company: function() {
      // alert(this.company)
    },
    selectedOption2: function() {
      if (this.selectedOption2) {

        axios
        .get(this.$store.state.baseUrl+"api/companies/category2/"+this.selectedOption2, {
          // http://localhost:8080/api/companies/category2/1
          // params: {
          //   id: this.selectedOption2
          // }
        })
        .then((res) => {
          console.log(res);
          this.company_list = res.data;

        }) 
        .catch((err) => {
          console.log(err)
          // this.company_list = [{companyName: 'KB국민은행'},{companyName: 'KB증권'},{companyName: '신한은행'}]
          this.company_list = [{companyName: '가능한 채용공고가 없어요'}]
        });
      }
    },
    selectedOption1: function(newValue) {
      // 첫 번째 셀렉트 요소의 선택 값이 변경될 때 호출되는 함수
      if (newValue === 'option1') {
        this.options2 = [
          { value: '1', label: '기획·전략·경영' },
          { value: '2', label: '인사·노무·교육' },
          { value: '3', label: '재무·세무·IR' },
          { value: '4', label: '경리·회계·결산' },
          { value: '5', label: '일반사무·총무·비서' },
          { value: '6', label: '법무' }
        ];
      } else if (newValue === 'option2') {
        this.options2 = [
          { value: '7', label: '마케팅' },
          { value: '8', label: '광고·홍보' }
        ];
      } else if (newValue === 'option3') {
        this.options2 = [
          { value: '9', label: '유통·물류·재고' },
          { value: '10', label: '무역·해외영업' },
          { value: '11', label: '구매·자재' },
          { value: '12', label: '운전·운송' },
          { value: '13', label: '상품기획·MD' }
        ];
      } else if (newValue === 'option4') {
        this.options2 = [
          { value: '14', label: 'QA' },
          { value: '15', label: '앱개발' },
          { value: '16', label: '웹개발' },
          { value: '17', label: '데이터엔지니어·분석·DBA' },
          { value: '18', label: '시스템프로그래머' },
          { value: '19', label: '응용프로그래머' },
          { value: '20', label: '네트워크·보안·운영' },
          { value: '21', label: '빅데이터·AI(인공지능)' },
          { value: '22', label: '게임개발' },
          { value: '23', label: 'HW·임베디드' },
          { value: '24', label: 'SW·솔루션·ERP' },
          { value: '25', label: '서비스기획·PM' }
        ];
      } else if (newValue === 'option5') {
        this.options2 = [
          { value: '26', label: '생산관리·공정관리·품질관리' },
          { value: '27', label: '안전·환경관리' },
          { value: '28', label: '생산·제조·설비·조립' },
          { value: '29', label: '설치·정비·AS·시공·공무' }
        ];
      } else if (newValue === 'option6') {
        this.options2 = [
          { value: '30', label: '제품·서비스영업' },
          { value: '31', label: 'IT·솔루션·기술영업' },
          { value: '32', label: 'B2B영업·법인영업' },
          { value: '33', label: '영업관리·지원·기획' },
          { value: '34', label: '아웃바운드' },
          { value: '35', label: '인바운드' },
          { value: '36', label: '고객응대·CS' },
          { value: '37', label: '금융·보험영업' }
        ];
      } else if (newValue === 'option7') {
        this.options2 = [
          { value: '38', label: '현장·시공·감리·공무' },
          { value: '39', label: '안전·품질·관리' },
          { value: '40', label: '전기·통신' },
          { value: '41', label: '기계·설비·화학' },
          { value: '42', label: '토목·조경·도시' },
          { value: '43', label: '건축·설계·인테리어' },
          { value: '44', label: '환경·플랜트' },
          { value: '45', label: '부동산·영업·견적' }
        ];
      } else if (newValue === 'option8') {
        this.options2 = [
          { value: '46', label: '증권·투자' },
          { value: '47', label: '외환·펀드·자산운용' },
          { value: '48', label: '보험계리사·손해사정' },
          { value: '49', label: '채권·심사' },
          { value: '50', label: '은행원' },
          { value: '51', label: '애널리스트' }
        ];
      } else if (newValue === 'option9') {
        this.options2 = [
          { value: '52', label: '자동차·기계' },
          { value: '53', label: '화학·에너지·환경' },
          { value: '54', label: '바이오·제약·식품' },
          { value: '55', label: '기계설계·CAD·CAM' },
          { value: '56', label: '전기·전자·제어' },
          { value: '57', label: '반도체·디스플레이' },
          { value: '58', label: '통신기술·네트워크 구축' },
          { value: '59', label: '금속·철강' },
          { value: '60', label: '조선·항공·우주' },
          { value: '61', label: '인문·사회과학' }
        ];
      } else if (newValue === 'option10') {
        this.options2 = [
          { value: '62', label: '광고·시각디자인' },
          { value: '63', label: '제품·산업디자인' },
          { value: '64', label: '건축·인테리어디자인' },
          { value: '65', label: '의류·패션·잡화디자인' },
          { value: '66', label: 'UI·UX디자인' }
        ];
      } else if (newValue === 'option11') {
        this.options2 = [
          { value: '67', label: '연출·제작·PD·작가' },
          { value: '68', label: '음악·영상·사진' },
          { value: '69', label: '아나운서·리포터·성우·기자' },
          { value: '70', label: '무대·스탭·오퍼레이터' },
          { value: '71', label: '연예·엔터테인먼트' },
          { value: '72', label: '인쇄·출판·편집' }
        ];
      } else if (newValue === 'option12') {
        this.options2 = [
          { value: '73', label: '리서치·시장조사' },
          { value: '74', label: '외국어·번역·통역' },
          { value: '75', label: '법률·특허·상표' },
          { value: '76', label: '회계·세무·CPA·CFA' },
          { value: '77', label: '보안·경비·경호' },
          { value: '78', label: '보건·의료' },
          { value: '79', label: '초·중·고 교사' },
          { value: '80', label: '교육개발·기획' },
          { value: '81', label: '외국어·자격증·기술강사' },
          { value: '82', label: '사회복지·요양보호·자원봉사' },
          { value: '83', label: '승무원·숙박·여행 서비스' },
          { value: '84', label: '음식서비스' }
        ];
      } else {
        this.options2 = []; // 선택 값이 없을 경우 두 번째 셀렉트 요소를 비웁니다.
      }
      this.selectedOption2 = ''; // 두 번째 셀렉트 요소의 선택 값도 초기화합니다.
    }
  }
  
}
</script>

<style scoped>
tool-bar{
  width: 20%
}
#nopost{
  width: 80%;
  height: 650px;
  padding: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid #808080;
  border-radius: 5px;
  background-color: #515151;
  color:white;
  font-family: 'Montserrat', sans-serif; font-size:20px;
  text-align: center;
}
#post{
  width: 80%;
  /* height: 650px; */
  padding: 20px;
  border: 1px solid #808080;
  border-radius: 5px;
  background-color: #515151;
  color:white;
  font-family: 'Montserrat', sans-serif; font-size:20px;
}
#filter {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
#main {
  width: 90%;
  text-align: center;
  padding-top: 10px;
  background-color: #363533;
  margin: 0 auto;
}
#input{
  width:45%;
  height: 59px;
  border-radius: 5px;
  border: 1px solid #808080;
  background-color: #515151;
  margin-right: 1.5%;
  color: white;

  display: flex;
  align-items: center;
  position: relative;
  cursor: text;
  padding: 8px 16px;
}
#input div{
  display: flex;
  align-items: center;
  flex: auto;
  border: 1px solid transparent;
  box-sizing: content-box;
}
#input div div:first-child{
  display: flex;
  align-items: center;
  width: 24px;
  height: 24px;
  margin-right: 12px;
}
#input div div img{
  vertical-align: middle;
  border: 0;
}
#input div div:last-child{
  display: flex;
  flex-direction: column;
  width: 100%;
  white-space: nowrap;
}
#input div div div:first-child{
  width: 100%;
  color: #777;
  font-size: 12px;
  line-height: 18px;
  font-weight: normal;
}
#input div div div:last-child{
  display: flex;
  align-items: center;
  justify-content: space-between;
}
#input div div div div{
  position: relative;
  width: 100%;
}
input{
  background-color: #515151;
  color: white;
  width: 100%;
  padding: 0;
  border: none;
  outline: none;
  font-weight: 350;
  font-family: 'Montserrat', sans-serif; font-size:15px;
}
input::placeholder {
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
}
select{
  width:21%;
  height: 59px;
  border-radius: 5px;
  border: 1px solid #808080;
  background-color: #515151;
  color: white;
  overflow-y:auto;
}
option{
  overflow-y:scroll;
}
#resume {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}
button{
  text-align: center;
  width: 92px;
  height: 56px;
  border: 1px solid #363533;
  border-radius: 5px;
  line-height: 56px;
  background-color: #A46CFF; 
  color: white;
  font-family: 'Montserrat', sans-serif; font-size:15px;
  text-decoration: none;
  margin-left: 0.5%;
}
.footer{
  margin-top: 90px;
}
</style>