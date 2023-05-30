<!-- MY PAGE_My info -->
<template>
  <tool-bar />
  <div>
    <section id="main">
      <side-bar-cv />
      <div id="cv_content">
        <header>
          <div class="title">
            <label for="">나의 이력 - 어학점수</label>
            <div class="button-group">
              <button class="btn btn-primary" @click="addLanguage">추가</button>
              <button class="btn btn-primary" @click="removeLanguage">삭제</button>
            </div>
          </div>
        </header>
        <div v-for="(item, index) of languages" :key="index" class="info-form">
          <div class="info-set" id="line1">
            <div class="formbox">
              <label for="" class="form-label">언어</label>
              <input
                v-model="item.language"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="언어"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">어학 종류</label>
              <input
                v-model="item.type"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="어학 종류"
                required
              />
            </div>
          </div>
          <div class="info-set" id="line2">
            <div class="formbox">
              <label for="" class="form-label">어학등급/점수</label>
              <input
                v-model="item.grade"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="어학등급/점수"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">취득일자</label>
              <input
                v-model="item.acquiredDate"
                type="date"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="퇴사일"
                required
              />
            </div>
          </div>
          <div class="info-set" id="line3">
            <div class="formbox">
              <label for="" class="form-label">등록/자격 번호</label>
              <input
                v-model="item.licenseNumber"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="등록/자격 번호"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">발행기관</label>
              <input
                v-model="item.agency"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="발행기관"
                required
              />
            </div>
          </div>
          <hr> 
        </div>
        <div class="btn" id="button">
          <button class="btn btn-primary" @click="saveLanguages">저장</button>
          <!-- <input type="button" class="save-button" onclick="alert('클릭!')" />저장 -->
        </div>
      </div>
    </section>
  </div>
  <footer-bar />
</template>
<script>
import ToolBar from "../components/ToolBar.vue";
import FooterBar from "../components/FooterBar.vue";
import SideBarCv from "../components/SideBarCv.vue";
import axios from "axios";
export default {
  components: { ToolBar, FooterBar, SideBarCv },
  data() {
    return {
      seekerId: "",
      languages: [],
    };
  },
  created() {
    this.seekerId = sessionStorage.getItem("seekerId");
    console.log(this.seekerId);
    axios
      .get(this.$store.state.baseUrl + "api/languages/all/" + this.seekerId, {})
      .then((res) => {
        this.languages = res.data;
        console.log(this.languages);
      })
      .catch((err) => {
        console.log(err);
        this.check = "error";
      });
  },
  methods: {
    addLanguage() {
      this.languages.push({
        language: "",
        type: "",
        grade: "",
        acquiredDate: "",
        licenseNumber: "",
        agency: "",
      });
    },
    removeLanguage() {
      if (this.languages.length > 0) {
        this.languages.pop();
      }
    },
    saveLanguages() {
      axios
      .delete(
        this.$store.state.baseUrl + "api/languages/" + this.seekerId,{})
      .then((res) => {
        console.log(res);
        //for
        for (let i = 0; i < this.languages.length; i++) {
          //insert
          axios
          .post(
            this.$store.state.baseUrl + "api/languages",{
              language: this.languages[i].language,
              type: this.languages[i].type,
              grade: this.languages[i].grade,
              acquiredDate: this.languages[i].acquiredDate,
              licenseNumber: this.languages[i].licenseNumber,
              agency: this.languages[i].agency,
              seekerId : this.seekerId
            }
          )
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
            this.check = "error";
          });
        }
      })
      .catch((err) => {
        console.log(err);
        this.check = "error";
      });
    },
  },
};
</script>
<style scoped>
/* 전체 폼 와꾸 정리 */

#main {
  display: flex;
  flex-direction: row;
  width: 100%;
  /* grid-auto-flow: column; */
  /* grid-template-columns: 0.8fr 3fr 0.5fr; */
}

#cv_content {
  min-height: 500px;
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
  font-size: 14px;
  font-weight: bolder;
  text-align: left;
  width: 100%;
  top: 10px;
  border-bottom: 1px solid #808080;
}

/* 이미지와 라인 정리 */
#imgNline_img {
  grid-row: span 3;
}

#imgNline {
  display: grid;
  grid-template-columns: 200px 1fr;
  gap: 10px 20px;
}

/* 라인 정리 */
#line1 {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px 20px;
}

#line2 {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px 20px;
}

#line3 {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px 20px;
}
#line4 {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 10px 20px;
}
#line5 {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 10px 20px;
}

#button {
  display: flex;
  margin: auto 0 0 auto;
  gap: 10px 20px;
}

/* 폼 정리 */
.form-control {
  font-size: 14px;
  background-color: #808080;
  border-color: #808080;
}

.form-label {
  font-size: 14px;
  color: #f5f5f5;
}

/* 저장 버튼 */
/* input.save-button{
        background-image: url(../assets/등록\ 버튼.png);
        width: 100px;
    } */
.btn.btn-primary {
  height: 35px;
  margin-bottom: 5px;
  border-radius: 5px;
  border-color: #808080;
  background: #a46cff;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.3);
  color: #f5f5f5;
  font-size: 15px;
  font-weight: 700;
  text-transform: capitalize;
}
.button-group {
  display: flex;
  gap: 10px;
  margin-right: 0;
}

.button-group button {
  margin-left: auto;
}
a {
  text-decoration: none;
  color: #f5f5f5;
}
hr {
  color: #f5f5f5;
}
</style>