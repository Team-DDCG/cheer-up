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
                <p class="title2">{{companyName}}</p>
                <!-- <p class="deadline">시작일: {{company.startDate}} | 마감일: {{ company.endDate }}</p> -->

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
            <pentagon-graph :data="processedCharacter" :labels="c_label"></pentagon-graph>
          </div>
          <div>
            <p>기업적합도 분석</p>
            <pentagon-graph :data="processedFit" :labels="f_label"></pentagon-graph>
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
        <div v-for="item of answer" :key="item" class="wrapper">
          <div class="info" id="qna">
            <p class="text1">
              <span>{{item[0]}} {{item[1]}}</span>
            </p>
            <button @click="copyText(item[2])">v 복사</button>
          </div>
          <div class="answer">
            <p>{{item[2]}}</p>
          </div>
        </div>
      </div>
      
    </div>
    <footer-bar />
  </div>
  
</template>

<script>
import ToolBar from "../components/ToolBar.vue";
import PentagonGraph from '../components/PentagonGraph.vue';
import FooterBar from "../components/FooterBar.vue";
import axios from "axios";

export default {
  components: { ToolBar, PentagonGraph,FooterBar },
  
  data() {
    return {
      company: '',
      field: '',
      companyName: '',
      companyId: '',
      userId: '',
      userName: '',
      character: [0,0,0,0,0], //[0.6, 0.9, 0.6, 0.8, 0.6]
      c_label: [],
      fit: [0,0,0,0,0], //[0.8, 0.6, 0.7, 0.6, 0.8]
      f_label: [],
      answer: [],


      resume: []
    }
  },
  mounted() {
    console.log(this.$route.query.field);
  },
  methods: {
    copyText(text) {
      /* 텍스트를 클립보드에 복사합니다. */
      navigator.clipboard.writeText(text)
        .then(() => {
          console.log("텍스트가 복사되었습니다.");
          alert("텍스트가 복사되었습니다.");
        })
        .catch((error) => {
          console.error("텍스트 복사에 실패했습니다.", error);
        });
    },
  },
  created() {
    this.userName = sessionStorage.getItem("name");
    this.field =  this.$route.params.id;
    this.companyName = "";
    // this.companyId = this.$route.query.companyId;
    this.userId =  sessionStorage.getItem("id");
    // console.log(this.companyId);
    console.log(this.userId);

    console.log(this.field); // 해외영업

    axios
      .get(this.$store.state.baseUrl+"api/resume/data/"+this.field, {
      })
      .then((res) => {
        this.resume = res.data;
        console.log(this.resume);


        for (let i = 0; i < this.resume.length; i++) {
          this.character = [this.resume[i].rate1,this.resume[i].rate2,this.resume[i].rate3,this.resume[i].rate4,this.resume[i].rate5];
          this.c_label = [this.resume[i].tendency1,this.resume[i].tendency2,this.resume[i].tendency3,this.resume[i].tendency4,this.resume[i].tendency5];
          this.fit = [this.resume[i].companyRate1,this.resume[i].companyRate2,this.resume[i].companyRate3,this.resume[i].companyRate4,this.resume[i].companyRate5];
          this.f_label = [this.resume[i].companyNeeds1,this.resume[i].companyNeeds2,this.resume[i].companyNeeds3,this.resume[i].companyNeeds4,this.resume[i].companyNeeds5];
          this.companyName = this.resume[i].companyName;
          this.answer.push([this.resume[i].question,this.resume[i].length,this.resume[i].content]);
        }
        console.log(this.answer)

      })
      .catch((err) => {
        console.log(err);
        this.check = 'error';
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
};
</script>



<style scoped>
.wrapper {
    width: 80%;
    margin: 0 auto;
}
.graph-box div {
  display: flex;
  flex-direction:column;
  align-items: center;
  margin: 20px;
}
.answer {
  margin: 5px auto;
  background-color: #808080;
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