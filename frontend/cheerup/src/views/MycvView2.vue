<!-- MY PAGE_My info -->
<template>
  <tool-bar />
  <div>
    <section id="main">
      <side-bar-cv />
      <div id="cv_content">
        <header>
          <div class="title">
            <label for="">나의 이력 - 경력사항</label>
            <div class="button-group">
              <button class="btn btn-primary" @click="addCareer">추가</button>
              <button
                class="btn btn-primary"
                @click="removeCareer(career.length - 1)"
              >
                삭제
              </button>
            </div>
          </div>
        </header>
        <div v-for="(item, index) of career" :key="index" class="info-form">
          <div class="info-set" id="imgNline_line">
            <div class="info-set" id="line1">
              <div class="formbox">
                <label for="exampleFormControlInput1" class="form-label"
                  >회사명</label
                >
                <input
                  v-model="item.companyName"
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="회사명"
                  required
                />
              </div>
              <div class="formbox">
                <label for="exampleFormControlInput2" class="form-label"
                  >부서</label
                >
                <input
                  v-model="item.department"
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput2"
                  placeholder="부서"
                  required
                />
              </div>
              <div class="formbox">
                <label for="exampleFormControlInput3" class="form-label"
                  >직위</label
                >
                <input
                  v-model="item.position"
                  type="text"
                  class="form-control"
                  id="exampleFormControlInput3"
                  placeholder="부서"
                  required
                />
              </div>
            </div>
          </div>
          <div class="info-set" id="line2">
            <div class="formbox">
              <label for="exampleFormControlInput4" class="form-label"
                >입사일</label
              >
              <input
                v-model="item.startDate"
                type="date"
                class="form-control"
                id="exampleFormControlInput4"
                placeholder="입사일"
                required
              />
            </div>
            <div class="formbox">
              <label for="exampleFormControlInput5" class="form-label"
                >퇴사일</label
              >
              <input
                v-model="item.endDate"
                type="date"
                class="form-control"
                id="exampleFormControlInput5"
                placeholder="퇴사일"
                required
              />
            </div>
            <div class="formbox">
              <!-- <label for="exampleFormControlInput6" class="form-label">재직여부</label>
              <input
                v-model="item.attendingCheck"
                type="text"
                class="form-control"
                id="exampleFormControlInput6"
                placeholder="재직여부"
              /> -->
              <label for="exampleFormControlInput6" class="form-label"
                >재직여부</label
              ><br />
              <select
                v-model="item.attendingCheck"
                class="form-control"
                id="exampleFormControlInput6"
                required
              >
                <option value="0">재직중</option>
                <option value="1">퇴사</option>
              </select>
            </div>

            <div class="formbox">
              <!-- <label for="exampleFormControlInput7" class="form-label">고용형태</label>
              <input
                v-model="item.hireType"
                type="text"
                class="form-control"
                id="exampleFormControlInput7"
                placeholder="고용형태"
              /> -->
              <label for="exampleFormControlInput7" class="form-label"
                >고용형태</label
              ><br />
              <select
                v-model="item.hireType"
                class="form-control"
                id="exampleFormControlInput7"
                required
              >
                <option value="0">정규직</option>
                <option value="1">비정규직</option>
                <option value="2">인턴</option>
              </select>
            </div>
          </div><hr>
        </div>
        <div class="button-group">
          <button class="btn btn-primary" @click="saveCareer">저장</button>
          <!-- <input type="button" class="save-button" onclick="alert('클릭!')" />저장 -->
        </div>
      </div>
    </section>
  </div>
  <div class="footer">
    <footer-bar></footer-bar>
  </div>
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
      career: "",
    };
  },
  created() {
    this.seekerId = sessionStorage.getItem("seekerId");
    console.log(this.seekerId);
    axios
      .get(
        this.$store.state.baseUrl + "api/careers/seeker/" + this.seekerId,
        {}
      )
      .then((res) => {
        this.career = res.data;
        console.log(this.career);
        console.log(this.career.length);
      })
      .catch((err) => {
        console.log(err);
        this.check = "error";
      });
  },
  methods: {
    addCareer() {
      this.career.push({
        companyName: "",
        department: "",
        position: "",
        startDate: "",
        endDate: "",
        attendingCheck: "0",
        hireType: "0",
      });
    },
    removeCareer(index) {
      this.career.splice(index, 1);
    },
    saveCareer() {
      // Perform your save logic here
      // You can access the career data using 'this.career'
      // 동일한 seekerId를 가지는 모든 career를 지우는 함수 필요
      // 이후 위의 career.length 만큼 반복하면서 career등록
      axios
      .delete(
        this.$store.state.baseUrl + "api/careers/" + this.seekerId,{})
      .then((res) => {
        console.log(res);
        //for
        for (let i = 0; i < this.career.length; i++) {
          //insert
          axios
          .post(
            this.$store.state.baseUrl + "api/careers/register/",{
              companyName : this.career[i].companyName,
              department : this.career[i].department,
              position : this.career[i].position,
              startDate : this.career[i].startDate,
              endDate : this.career[i].endDate,
              attendingCheck : this.career[i].attendingCheck,
              hireType : this.career[i].hireType,
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
  grid-template-columns: 1fr 1fr 1fr 1fr;
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

.button-group {
  display: flex;
  gap: 10px;
  margin-right: 0;
}

.button-group button {
  margin-left: auto;
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
a {
  text-decoration: none;
  color: #f5f5f5;
}
.footer {
  margin-top: 485px;
}
hr{
  color: #f5f5f5;
}
</style>