<template>
  <div>
    <tool-bar></tool-bar>
    <div class="container">
      <div id="myDiv">
        <div class="header">
          <div class="line">
            <div class="line1">
              <p id="title1">AI 자기소개서 생성</p>
              <div id="line2">
                <p class="title2">{{company.title}}</p>
                <p class="deadline">시작일: {{company.startDate}} | 마감일: {{ company.endDate }}</p>

              </div>
              <hr>
          </div>
          </div>

        </div>
        <div class="info">
          <p class="text2">
            <span class="bold">{{userName}}</span>
            <span>님의</span>
          </p>
          <p class="text1">
            <span class="bold">{{companyName}}</span>
            <span>에 대한 기업적합도 분석입니다.</span>
          </p>
        </div>
        <div class="graph-box">
          <div>
            <p>내 자기소개서 분석</p>
            <pentagon-graph :data="processedCharacter"></pentagon-graph>
          </div>
          <div>
            <p>기업적합도 분석</p>
            <pentagon-graph :data="processedFit"></pentagon-graph>
          </div>
          
        </div>
        <div class="info">
          <p class="text2">
            <span class="bold">{{ userName }}</span>
            <span>님의</span>
          </p>
          <p class="text1">
            <span class="bold">{{companyName}}</span>
            <span>에 대해 작성된 자기소개서입니다.</span>
          </p>
        </div>
        <div class="info" id="qna">
          <p class="text1">
            <span>질문 1. 자신의 장점과 단점을 관련 경험과 작성하시오. (500자 이내)</span>
          </p>
          <button>v 복사</button>
        </div>
        <div class="answer">
          <p>[다재다능함]
            히히 제 장점은 ~~~~~~~~~~~~입니다.
            ㅇ아ㅡㄹ어마ㅣ러ㅏ밂ㄴ;ㅓ

            [오지랖이 넓음]
            단점을</p>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";
import PentagonGraph from '../components/PentagonGraph.vue';
import axios from "axios";

export default {
  components: { ToolBar, PentagonGraph },
  
  data() {
    return {
      company: '',
      field: '',
      companyName: '',
      companyId: '',
      userId: '',
      userName: '',
      character: [0,0,0,0,0], //[0.6, 0.9, 0.6, 0.8, 0.6]
      fit: [0,0,0,0,0], //[0.8, 0.6, 0.7, 0.6, 0.8]
      
    }
  },
  mounted() {
    console.log(this.$route.query.field);
  },
  methods: {

  },
  created() {
    this.userName = sessionStorage.getItem("name");
    this.field = this.$route.query.field;
    this.companyName = this.$route.query.companyName;
    this.companyId = this.$route.query.companyId;
    this.userId =  sessionStorage.getItem("id");
    console.log(this.field);
    console.log(this.companyName);
    console.log(this.companyId);
    console.log(this.userId);

    axios
      .get(this.$store.state.baseUrl+"api/companies/"+this.companyName, {
      })
      .then((res) => {
        console.log(res);
        this.company = res.data;
        console.log(this.company);
      })
      .catch((err) => {
        console.log(err);
        this.check = 'error';
      });

     axios
        .get("http://127.0.0.1:5000/my_characteristic/"+this.userId, {
        })
        .then((res1) => {
          console.log(res1.data.result);
          this.character = res1.data.result.map(sublist => sublist[1]/100);
          console.log(this.character);

          axios
          .get("http://127.0.0.1:5000/goodness_of_fit/"+this.userId+"/"+this.companyName, {
          })
          .then((res2) => {
            console.log(res2.data.result);
            this.fit = res2.data.result.map(sublist => sublist[1]/100);          
            console.log(this.fit);

            axios
              .get("http://127.0.0.1:5000/resume_create/"+this.userId+"/"+this.companyId+"/"+this.companyName+"/"+this.field, {
              })
              .then((res3) => {
                console.log(res3.data.result);

              })
              .catch((err3) => {
                console.log(err3);
                this.check = 'error3';
              });

          })
          .catch((err2) => {
            console.log(err2);
            this.check = 'error2';
          });
        })
        .catch((err1) => {
          console.log(err1);
          this.check = 'error1';
        });
  },
  computed: {
    processedCharacter() {
      // character 데이터를 처리한 결과를 반환하는 계산형 속성
      console.log('processedCharacter');
      console.log(this.character);
      
      return this.character;
    },
    processedFit() {
      // fit 데이터를 처리한 결과를 반환하는 계산형 속성
      console.log('processedFit');
      console.log(this.fit);
      
      return this.fit;
    }
  },
  // watch: {
  //   character: function(){
  //     console.log(this.character);
  //   },
  //   fit: function(){
  //     console.log(this.fit);
  //   }
  // }
};
</script>



<style scoped>
.graph-box div {
  display: flex;
  flex-direction:column;
  align-items: center;
  margin: 20px;
}
.answer {
  margin: 5px auto;
  width: 80%;
  background-color: #808080;
  height: 100px;
  padding: 10px;
}
#qna{
  display: flex;
  justify-content: space-between;
}
#qna button{
  text-align: center;
  width: 68px;
  height: 21px;
  border-radius: 30px;
  border: 1px solid #363533;
  border-radius: 5px;
  background-color: white;
  color: black;
  font-family: "Montserrat", sans-serif;
  font-size: 13px;
  font-weight: bold;
}
p{
  margin: 0;
  font-family: "Montserrat", sans-serif;
  color: white;
}
hr{
  background-color: #F5F5F5;
  margin: 0;
  height: 2px;
}
#title1{
  font-weight:bold;
  font-size: 15px;
}
#date{
  display: flex;
}
#line2{
  display: flex;
  justify-content: space-between;
}
.container {
  display: flex;
  justify-content: center;
  padding: 30px;
}

#myDiv {
  width: 1070px;
  height: 1481px;
  border-radius: 5px;
  background: #515151;
  border-width: 1px;
  border-color: #808080;
}

.graph-box {
  width: 80%;
  border-radius: 33px;
  background: #363533;
  border-width: 5px;
  border-color: #363533;
  justify-content: center;
  display: flex;
  margin: 10px auto;
}
.text1,
.text2 {
  left: 165px;
  font-size: 15px;
  text-align: left;
  color: #f5f5f5;
}

.text1 {
  top: 265px;
}

.text2 {
  top: 241px;
}

.bold {
  font-weight: 700;
}
.container > #myDiv > .info {
  /* padding-left: 100px; */
  /* margin-top: 30px; */
  margin: 0 auto;
  margin-top: 30px;
  width: 80%;
}
.container > #myDiv > .header {
  padding-top: 30px;
  padding-left: 100px;
  display: flex;
  color: #f5f5f5;
}
.container > #myDiv > .header > .title1 {
  width: 112px;
    height: 14px;
    font-Size: 15px;
    font-Weight: 700
}

.container > #myDiv > .header > .title1 {
  width: 300px; 
  height: 14px; 
  font-Size: 15px; 
  text-Align: left; 
  color: #f5f5f5;
}
.line1{
  width: 900px;
}

</style>