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
            <button>v 복사</button>
          </div>
          <div class="answer">
            <p>{{item[2]}}</p>
          </div>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";
import PentagonGraph from '../components/PentagonGraph.vue';
// import axios from "axios";

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
      c_label: [],
      fit: [0,0,0,0,0], //[0.8, 0.6, 0.7, 0.6, 0.8]
      f_label: [],
      answer: [],
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

    const id = this.$route.params.id;
    console.log(id); // "11"

    // http://localhost:8080/api/resume/11
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