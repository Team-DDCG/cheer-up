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
            <button @click="copyText(item[2])">v 복사</button>
          </div>
          <div class="answer">
            <p>{{item[2]}}</p>
          </div>
        </div>
        <div class="button-group">
          <button class="btn btn-primary" @click="saveResume">저장</button>
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
      c_label: ['','','','',''],
      fit: [0,0,0,0,0], //[0.8, 0.6, 0.7, 0.6, 0.8]
      f_label: ['','','','',''],
      answer: [],
      seekerId: sessionStorage.getItem("seekerId"),
      text: '',
      question: []
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
    saveResume() {
      //seeker-fit save
      //resumeId는 아직 생성 안되서 post못해줌
      axios
      .post(this.$store.state.baseUrl+"api/seeker-fit/", {
        "tendency1" : this.c_label[0],
        "tendency2" : this.c_label[1],
        "tendency3" : this.c_label[2],
        "tendency4" : this.c_label[3],
        "tendency5" : this.c_label[4],
        "rate1" : this.character[0],
        "rate2" : this.character[1],
        "rate3" : this.character[2],
        "rate4" : this.character[3],
        "rate5" : this.character[4],
        "seekerId" : this.seekerId,
        "position" : this.field
      })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
        this.check = 'error';
      });

      axios
      .post(this.$store.state.baseUrl+"api/company-fit/", {
        "companyName" : this.companyName,
        "companyNeeds1" : this.f_label[0],
        "companyNeeds2" : this.f_label[1],
        "companyNeeds3" : this.f_label[2],
        "companyNeeds4" : this.f_label[3],
        "companyNeeds5" : this.f_label[4],
        "companyRate1" : this.fit[0],
        "companyRate2" : this.fit[1],
        "companyRate3" : this.fit[2],
        "companyRate4" : this.fit[3],
        "companyRate5" : this.fit[4],
        "seekerId" : this.seekerId,
        "position" : this.field
      })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
        this.check = 'error';
      });


      //getQuestionId
      axios
      .get(this.$store.state.baseUrl + "api/question/"+this.companyId+"/" + this.field, {})
      .then((res) => {
        this.question = res.data;
        console.log(this.question);
      })
      .catch((err) => {
        console.log(err);
        this.check = "error";
      });



      for (let i = 0; i < this.answer.length; i++) {
        axios
        .post(this.$store.state.baseUrl+"api/resume/", {
          "content" : this.answer[i][2],
          "postCheck" : 0,
          "seekerId" : this.seekerId,
          "position" : this.field,
          "companyId" : this.companyId,
          "questionId" : this.question[i].questionId
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
      }
    }
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
          this.character = res1.data.result.map(sublist => sublist[1]/50);
          this.c_label = res1.data.result.map(sublist => sublist[0]);
          console.log(this.character);
          console.log(this.c_label);
          axios
          .get("http://127.0.0.1:5000/goodness_of_fit/"+this.userId+"/"+this.companyName, {
          })
          .then((res2) => {
            console.log(res2.data.result);
            this.fit = res2.data.result.map(sublist => sublist[1]/100); 
            this.f_label = res2.data.result.map(sublist => sublist[0]);
            console.log(this.fit);
            console.log(this.f_label);
            axios
              .get("http://127.0.0.1:5000/resume_create/"+this.userId+"/"+this.companyId+"/"+this.companyName+"/"+this.field, {
              })
              .then((res3) => {
                console.log(res3.data.result);
                this.answer = res3.data.result;
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
.button-group {
  display: flex;
  gap: 10px;
  margin-right: 0;
}

.button-group button {
  margin-left: auto;
}
.btn.btn-primary {
  height: 42.01px;
  margin-right: 105px;
  border-radius: 5px;
  border-color: #808080;
  background: #a46cff;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.3);
  color: #f5f5f5;
  font-size: 15px;
  font-weight: 700;
  text-transform: capitalize;
}
</style>