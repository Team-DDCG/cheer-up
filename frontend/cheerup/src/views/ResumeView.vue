<template>
  <tool-bar></tool-bar>
  <select v-model="selectedOption1">
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

  <select v-model="selectedOption2">
    <option v-for="option in options2" :value="option.value" v-bind:key="option">{{ option.label }}</option>
  </select>
  <button @click.prevent="saveOption" type="submit" class="btn btn-primary">저장</button>
  <side-bar></side-bar>

</template>

<script>
 
import SideBar from '../components/SideBar.vue';
import ToolBar from '../components/ToolBar.vue';
import axios from "axios";

export default {
  components: {SideBar, ToolBar},
  data() {
    return {
      selectedOption1: '',
      selectedOption2: '',
      options2: [] // 두 번째 셀렉트 요소의 옵션 값
    }
  },
  methods: {
    async saveOption() {
      alert(this.selectedOption2);
        // const userData = {
        //     address: this.address,
        //     email: this.email,
        //     mail_check: this.mail_check,
        // }

        axios
        .post("http://127.0.0.1:8888/company/register", {
          type: this.selectedOption2
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
    

        // this.$router.push({
        //     path:'/home',
        // });
    },
  },
  computed: {

  },
  created() {
     
  },
  watch: {
    selectedOption1: function(newValue) {
      // 첫 번째 셀렉트 요소의 선택 값이 변경될 때 호출되는 함수
      if (newValue === 'option1') {
        this.options2 = [
          { value: '1.1', label: '기획·전략·경영' },
          { value: '1.2', label: '인사·노무·교육' },
          { value: '1.3', label: '재무·세무·IR' },
          { value: '1.4', label: '경리·회계·결산' },
          { value: '1.5', label: '일반사무·총무·비서' },
          { value: '1.6', label: '법무' }
        ];
      } else if (newValue === 'option2') {
        this.options2 = [
          { value: '2.1', label: '마케팅' },
          { value: '2.2', label: '광고·홍보' }
        ];
      } else if (newValue === 'option3') {
        this.options2 = [
          { value: '3.1', label: '유통·물류·재고' },
          { value: '3.2', label: '무역·해외영업' },
          { value: '3.3', label: '구매·자재' },
          { value: '3.4', label: '운전·운송' },
          { value: '3.5', label: '상품기획·MD' }
        ];
      } else if (newValue === 'option4') {
        this.options2 = [
          { value: '4.1', label: 'QA' },
          { value: '4.2', label: '앱개발' },
          { value: '4.3', label: '웹개발' },
          { value: '4.4', label: '데이터엔지니어·분석·DBA' },
          { value: '4.5', label: '시스템프로그래머' },
          { value: '4.6', label: '응용프로그래머' },
          { value: '4.7', label: '네트워크·보안·운영' },
          { value: '4.8', label: '빅데이터·AI(인공지능)' },
          { value: '4.9', label: '게임개발' },
          { value: '4.10', label: 'HW·임베디드' },
          { value: '4.11', label: 'SW·솔루션·ERP' },
          { value: '4.12', label: '서비스기획·PM' }
        ];
      } else if (newValue === 'option5') {
        this.options2 = [
          { value: '5.1', label: '생산관리·공정관리·품질관리' },
          { value: '5.2', label: '안전·환경관리' },
          { value: '5.3', label: '생산·제조·설비·조립' },
          { value: '5.4', label: '설치·정비·AS·시공·공무' }
        ];
      } else if (newValue === 'option6') {
        this.options2 = [
          { value: '6.1', label: '제품·서비스영업' },
          { value: '6.2', label: 'IT·솔루션·기술영업' },
          { value: '6.3', label: 'B2B영업·법인영업' },
          { value: '6.4', label: '영업관리·지원·기획' },
          { value: '6.5', label: '아웃바운드' },
          { value: '6.6', label: '인바운드' },
          { value: '6.7', label: '고객응대·CS' },
          { value: '6.8', label: '금융·보험영업' }
        ];
      } else if (newValue === 'option7') {
        this.options2 = [
          { value: '7.1', label: '현장·시공·감리·공무' },
          { value: '7.2', label: '안전·품질·관리' },
          { value: '7.3', label: '전기·통신' },
          { value: '7.4', label: '기계·설비·화학' },
          { value: '7.5', label: '토목·조경·도시' },
          { value: '7.6', label: '건축·설계·인테리어' },
          { value: '7.7', label: '환경·플랜트' },
          { value: '7.8', label: '부동산·영업·견적' }
        ];
      } else if (newValue === 'option8') {
        this.options2 = [
          { value: '8.1', label: '증권·투자' },
          { value: '8.2', label: '외환·펀드·자산운용' },
          { value: '8.3', label: '보험계리사·손해사정' },
          { value: '8.4', label: '채권·심사' },
          { value: '8.5', label: '은행원' },
          { value: '8.6', label: '애널리스트' }
        ];
      } else if (newValue === 'option9') {
        this.options2 = [
          { value: '9.1', label: '자동차·기계' },
          { value: '9.2', label: '화학·에너지·환경' },
          { value: '9.3', label: '바이오·제약·식품' },
          { value: '9.4', label: '기계설계·CAD·CAM' },
          { value: '9.5', label: '전기·전자·제어' },
          { value: '9.6', label: '반도체·디스플레이' },
          { value: '9.7', label: '통신기술·네트워크 구축' },
          { value: '9.8', label: '금속·철강' },
          { value: '9.9', label: '조선·항공·우주' },
          { value: '9.10', label: '인문·사회과학' }
        ];
      } else if (newValue === 'option10') {
        this.options2 = [
          { value: '10.1', label: '광고·시각디자인' },
          { value: '10.2', label: '제품·산업디자인' },
          { value: '10.3', label: '건축·인테리어디자인' },
          { value: '10.4', label: '의류·패션·잡화디자인' },
          { value: '10.5', label: 'UI·UX디자인' }
        ];
      } else if (newValue === 'option11') {
        this.options2 = [
          { value: '11.1', label: '연출·제작·PD·작가' },
          { value: '11.2', label: '음악·영상·사진' },
          { value: '11.3', label: '아나운서·리포터·성우·기자' },
          { value: '11.4', label: '무대·스탭·오퍼레이터' },
          { value: '11.5', label: '연예·엔터테인먼트' },
          { value: '11.6', label: '인쇄·출판·편집' }
        ];
      } else if (newValue === 'option12') {
        this.options2 = [
          { value: '12.1', label: '리서치·시장조사' },
          { value: '12.2', label: '외국어·번역·통역' },
          { value: '12.3', label: '법률·특허·상표' },
          { value: '12.4', label: '회계·세무·CPA·CFA' },
          { value: '12.5', label: '보안·경비·경호' },
          { value: '12.6', label: '보건·의료' },
          { value: '12.7', label: '초·중·고 교사' },
          { value: '12.8', label: '교육개발·기획' },
          { value: '12.9', label: '외국어·자격증·기술강사' },
          { value: '12.10', label: '사회복지·요양보호·자원봉사' },
          { value: '12.11', label: '승무원·숙박·여행 서비스' },
          { value: '12.12', label: '음식서비스' }
        ];
      } else {
        this.options2 = []; // 선택 값이 없을 경우 두 번째 셀렉트 요소를 비웁니다.
      }
      this.selectedOption2 = ''; // 두 번째 셀렉트 요소의 선택 값도 초기화합니다.
    }
  }
}
</script>

<style>

</style>