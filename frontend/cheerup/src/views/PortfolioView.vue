<template>
  <div>
    <tool-bar></tool-bar>
    <div class="container" v-if="seekerId && id">
      <div id="option">
        <div class="option1" @click="showPortfolio('portfolio_1.png')" @mouseover="highlightOption(1)" @mouseleave="unhighlightOption(1)">
          OPTION1
        </div>
        <div class="option2" @click="showPortfolio('portfolio_2.png')" @mouseover="highlightOption(2)" @mouseleave="unhighlightOption(2)">
          OPTION2
        </div>
      </div>
      <div id="myDiv">
        <header>
          <div class="title">
            <label for="">포트폴리오</label>
          </div>
        </header>
        <div class="image-container">
          <img :src="portfolioImage" class="portfolio-image" />
        </div>
        <div class="footer">
        <div class="mb-3-button" id="end">
          <div class="button-container">
            <button @click="downloadFile" class="btn btn-primary">
              출력
            </button>
          </div>
        </div>
        </div>
      </div>
    </div>
    <footer-bar />
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";
import FooterBar from "../components/FooterBar.vue";
import axios from "axios";
export default {
  components: { ToolBar,FooterBar },
  data() {
    return {
      seekerId: sessionStorage.getItem("seekerId"),
      id: sessionStorage.getItem("id"),
      flag: 0,
      portfolioImage: "", // 이미지 경로를 저장할 데이터
      isOption1Highlighted: false,
      isOption2Highlighted: false,
    };
  },
  mounted() {},
  methods: {
    downloadFile() {
      // Flask 서버에 API 요청을 보냅니다.
      axios.get('http://127.0.0.1:5000/make_portfolio/'+this.seekerId+"/"+this.flag, {
        responseType: 'blob'  // 파일을 블롭 형태로 받습니다.
      })
      .then(response => {
        // 파일 다운로드를 위한 코드
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'portfolio.docx');  // 다운로드될 파일의 이름
        document.body.appendChild(link);
        link.click();
      })
      .catch(error => {
        console.error(error);
      });
    },
  

    showPortfolio(image) {
      this.portfolioImage = require(`../assets/${image}`);
      if (image == 'portfolio_1.png') {
        this.flag = 1;
      } else {
        this.flag = 2;
      }

    },
    highlightOption(option) {
      if (option === 1) {
        this.isOption1Highlighted = true;
      } else if (option === 2) {
        this.isOption2Highlighted = true;
      }
    },
    unhighlightOption(option) {
      if (option === 1) {
        this.isOption1Highlighted = false;
      } else if (option === 2) {
        this.isOption2Highlighted = false;
      }
    },
  },
};
</script>

<style scoped>
#end{
  position: absolute;
  bottom: 0;
  right: 0;
}
.image-container {
  display: flex;
  justify-content: center;
}

img.portfolio-image {
  width: 100%;
  height: auto;
  margin-top: 25px;
  margin-bottom: 25px;
}

.container {
  display: flex;
  justify-content: center;
  padding: 30px;
}

#option {
  flex-direction: column;
  align-items: center;
  color: #f5f5f5;
  margin-top: 100px;
  margin-right: 15px;
}

#option .option1:hover {
  background-color: #a46cff;
  color: white;
  cursor: pointer;
}

#option .option2:hover {
  background-color: #a46cff;
  color: white;
  cursor: pointer;
}

#myDiv {
  min-height: 600px;
  display: flex;
  flex-direction: row;
  display: grid;
  width: 80%;
  /* row-gap: 10px;
        column-gap: 20px; */
  background-color: #515151;
  padding: 4%;
  margin-bottom: 17%;
  margin-top: 5%;
  border-radius: 5px;
}

.title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  color: #f5f5f5;
  font-size: 15px;
  font-weight: bolder;
  text-align: left;
  width: 100%;
  top: 10px;
  border-bottom: 1px solid #808080;
}

.header {
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  display: flex;
  color: #f5f5f5;
}

#title1 {
  width: 300px;
  height: 14px;
  font-size: 15px;
  text-align: left;
  color: #f5f5f5;
}

.line1 {
  width: 900px;
}

.post-check {
  width: 60px;
}

.c1 {
  width: 300px;
}

.c2 {
  width: 600px;
}

.c3 {
  width: 250px;
}

.c4 {
  width: 250px;
}

.c5 {
  width: 300px;
}

.button-container {
  display: flex;
  justify-content: right;
  padding-right: 30px;
}

.btn.btn-secondary {
  background: #a46cff;
  border-Color: #808080;
  margin-right: 5px;
}

.btn.btn-primary {
  background: #a46cff;
  border-Color: #808080;
}

.footer {
  /* margin-top: 550px; */
  position: relative;
}

.btn.btn-info {
  background: #a46cff;
  display: flex;
  margin: 0 auto;
  margin-right: 730px;
  color: white;
  border-Color: #808080;
}

a {
  text-decoration: none;
  color: #f5f5f5;
}
</style>
