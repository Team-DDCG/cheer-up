<!-- MY PAGE_My info -->
<template>
  <tool-bar />
  <div>
    <section id="main">
      <side-bar-cv />
      <div id="cv_content">
        <header>
          <div class="title">
            <label for="">나의 이력 - 학력정보</label>
            <div class="button-group">
              <button class="btn btn-primary" @click="addSchool">추가</button>
              <button class="btn btn-primary" @click="removeSchool">
                삭제
              </button>
            </div>
          </div>
        </header>
        <div v-for="(item, index) of schools" :key="index" class="info-form">
          <div class="info-set" id="imgNline_line">
            <div class="info-set" id="line1">
              <div class="formbox">
                <label for="" class="form-label">학교명</label>
                <input
                  v-model="item.schoolName"
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="학교명"
                  required
                />
              </div>

              <!-- <div class="formbox">
                <label for="" class="form-label">학위</label>
                <input
                  v-model="Ename"
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="학위"
                  required
                />
              </div> -->
              <div class="formbox">
                <label for="exampleFormControlInput2" class="form-label"
                  >학위</label
                ><br />
                <select
                  v-model="item.educationType"
                  class="form-control"
                  id="exampleFormControlSelect1"
                  required
                >
                  <option value="0">고졸</option>
                  <option value="1">초대졸</option>
                  <option value="2">학사</option>
                  <option value="3">석사</option>
                  <option value="4">박사</option>
                </select>
              </div>
              <div class="formbox">
                <label for="exampleFormControlInput2" class="form-label"
                  >최종학력여부</label
                ><br />
                <select
                  v-model="item.highestCheck"
                  class="form-control"
                  id="exampleFormControlSelect1"
                  required
                >
                  <option value="0">예</option>
                  <option value="1">아니오</option>
                </select>
              </div>
            </div>
          </div>
          <div class="info-set" id="line2">
            <div class="formbox">
              <label for="" class="form-label">전공</label>
              <input
                v-model="item.major"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="전공"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">입학일</label>
              <input
                v-model="item.entranceDate"
                type="date"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="입학일"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">졸업일</label>
              <input
                v-model="item.graduationDate"
                type="date"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="졸업일"
                required
              />
            </div>
          </div>
          <div class="info-set" id="line3">
            <div class="formbox">
              <label for="exampleFormControlInput2" class="form-label"
                >재학여부</label
              ><br />
              <select
                v-model="item.attendingCheck"
                class="form-control"
                id="exampleFormControlSelect1"
                required
              >
                <option value="0">재학</option>
                <option value="1">휴학</option>
                <option value="2">졸업</option>
              </select>
            </div>
            <div class="formbox">
              <label for="exampleFormControlInput2" class="form-label"
                >편입여부</label
              ><br />
              <select
                v-model="item.transferCheck"
                class="form-control"
                id="exampleFormControlSelect1"
                required
              >
                <option value="0">대상</option>
                <option value="1">비대상</option>
              </select>
            </div>
          </div>
          <div class="info-set" id="line4">
            <div class="formbox">
              <label for="" class="form-label">복수전공</label>
              <input
                v-model="item.doubleMajor"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="복수전공"
                required
              />
            </div>
            <div class="formbox">
              <label for="" class="form-label">학점</label>
              <input
                v-model="item.gpa"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="학점"
                required
              />
            </div>
          </div>
          <hr />
        </div>
        <div class="btn" id="button">
          <button class="btn btn-primary" @click="saveForm">저장</button>
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
      schools: [],
    };
  },
  created() {
    this.seekerId = sessionStorage.getItem("seekerId");
    console.log(this.seekerId);
    axios
      .get(this.$store.state.baseUrl + "api/schools/all/" + this.seekerId)
      .then((res) => {
        this.schools = res.data;
        console.log(this.schools);
      })
      .catch((err) => {
        console.log(err);
        this.check = "error";
      });
  },
  methods: {
    addSchool() {
      this.schools.push({
        schoolName: "",
        educationType: "",
        highestCheck: "",
        major: "",
        entranceDate: "",
        graduationDate: "",
        attendingCheck: "",
        transferCheck: "",
        doubleMajor: "",
        gpa: "",
      });
    },
    removeSchool() {
      if (this.schools.length > 0) {
        this.schools.pop();
      }
    },
    saveForm() {
      axios
      .delete(
        this.$store.state.baseUrl + "api/schools/" + this.seekerId,{})
      .then((res) => {
        console.log(res);
        //for
        for (let i = 0; i < this.schools.length; i++) {
          //insert
          axios
          .post(
            this.$store.state.baseUrl + "api/schools",{
              schoolName: this.schools[i].schoolName, 
              educationType: this.schools[i].educationType, 
              highestCheck: this.schools[i].highestCheck, 
              major: this.schools[i].major, 
              entranceDate: this.schools[i].entranceDate, 
              graduationDate: this.schools[i].graduationDate, 
              attendingCheck: this.schools[i].attendingCheck, 
              transferCheck: this.schools[i].transferCheck,
              doubleMajor: this.schools[i].doubleMajor,  
              gpa: this.schools[i].gpa,  
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
  grid-template-columns: 1fr 1fr 1fr;
  gap: 10px 20px;
}

#line2 {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
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