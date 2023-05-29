<template>
  <div>
    <tool-bar></tool-bar>
    <div class="container">
      <div id="myDiv">
        <div class="header">
          <div class="line">
            <div class="line1">
              <p id="title1">자기소개서 조회</p>
              <br />
            </div>
            <div class="table">
              <table>
                <tr>
                  <th class="post-check">선택</th>
                  <th class="c1">회사명</th>
                  <th class="c2">공고제목</th>
                  <th class="c3">채용시작일</th>
                  <th class="c4">채용마감일</th>
                  <th class="c5">게시 여부</th>
                </tr>
                <tr v-for="item of resume" :key="item">
                  <td><input type="checkbox" class="post-check" /></td>
                  <td class="c1">{{ item.name }}</td>
                  <td class="c2">{{ item.title }}</td>
                  <td class="c3">{{ item.startDate }}</td>
                  <td class="c4">{{ item.endDate }}</td>
                  <td class="c5">{{ item.postCheck }}</td>
                </tr>
              </table>
            </div>
          </div>
        </div>
        <div class="footer">
          <div class="mb-3-button">
            <div class="button-container">
              <button type="submit" class="btn btn-info">
                <router-link to="/airesume"> 자기소개서 AI 작성</router-link>
              </button>
              <button type="submit" class="btn btn-secondary">저장</button>
              <button type="submit" class="btn btn-primary">삭제</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";
import axios from "axios";
export default {
  components: { ToolBar },
  data() {
    return {
      seekerId: '',
      resume: '',
    };
  },
  created() {
    this.seekerId = sessionStorage.getItem("seekerId");
    console.log(this.seekerId);
    axios
      .get(this.$store.state.baseUrl+"api/resume/all/"+this.seekerId, {
      })
      .then((res) => {
        this.resume = res.data;
        console.log(this.resume);
      })
      .catch((err) => {
        console.log(err);
        this.check = 'error';
      });
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  padding: 30px;
}

#myDiv {
  width: 1070px;
  height: 800px;
  border-radius: 5px;
  background: #515151;
  border-width: 1px;
  border-color: #808080;
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

.table {
  border-collapse: collapse;
  width: 100%;
  max-width: 100%;
  overflow-x: auto;
}

th {
  padding: 8px;
  padding-left: 20px;
  padding-right: 20px;
  text-align: center;
  font-weight: 700;
  color: #f5f5f5;
}

td {
  padding: 8px;
  padding-left: auto;
  padding-right: auto;
  text-align: center;
  color: #f5f5f5;
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
  border-color: #808080;
  margin-right: 5px;
}
.btn.btn-primary {
  background: #a46cff;
  border-color: #808080;
}
.footer {
  margin-top: 550px;
}
.btn.btn-info {
  background: #a46cff;
  display: flex;
  margin: 0 auto;
  margin-right: 730px;
  color: white;
  border-color: #808080;
}
a {
  text-decoration: none;
  color: #f5f5f5;
}
.checkbox-wrapper-9 {
  display: flex;
  justify-content: center;
  align-items: center;
}
.checkbox-wrapper-9 .tgl {
  display: none;
}

.checkbox-wrapper-9 .tgl,
  .checkbox-wrapper-9 .tgl:after,
  .checkbox-wrapper-9 .tgl:before,
  .checkbox-wrapper-9 .tgl *,
  .checkbox-wrapper-9 .tgl *:after,
  .checkbox-wrapper-9 .tgl *:before,
  .checkbox-wrapper-9 .tgl + .tgl-btn {
  box-sizing: border-box;
}

.checkbox-wrapper-9 .tgl::-moz-selection,
  .checkbox-wrapper-9 .tgl:after::-moz-selection,
  .checkbox-wrapper-9 .tgl:before::-moz-selection,
  .checkbox-wrapper-9 .tgl *::-moz-selection,
  .checkbox-wrapper-9 .tgl *:after::-moz-selection,
  .checkbox-wrapper-9 .tgl *:before::-moz-selection,
  .checkbox-wrapper-9 .tgl + .tgl-btn::-moz-selection,
  .checkbox-wrapper-9 .tgl::selection,
  .checkbox-wrapper-9 .tgl:after::selection,
  .checkbox-wrapper-9 .tgl:before::selection,
  .checkbox-wrapper-9 .tgl *::selection,
  .checkbox-wrapper-9 .tgl *:after::selection,
  .checkbox-wrapper-9 .tgl *:before::selection,
  .checkbox-wrapper-9 .tgl + .tgl-btn::selection {
  background: none;
}

.checkbox-wrapper-9 .tgl + .tgl-btn {
  outline: 0;
  display: block;
  width: 2em;
  height: 1.5em;
  position: relative;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.checkbox-wrapper-9 .tgl + .tgl-btn:after,
  .checkbox-wrapper-9 .tgl + .tgl-btn:before {
  position: relative;
  display: block;
  content: "";
  width: 50%;
  height: 100%;
}

.checkbox-wrapper-9 .tgl + .tgl-btn:after {
  left: 0;
}

.checkbox-wrapper-9 .tgl + .tgl-btn:before {
  display: none;
}

.checkbox-wrapper-9 .tgl:checked + .tgl-btn:after {
  left: 50%;
}

.checkbox-wrapper-9 .tgl-flat + .tgl-btn {
  padding: 2px;
  transition: all 0.2s ease;
  background: #fff;
  border: 4px solid #f2f2f2;
  border-radius: 2em;
}

.checkbox-wrapper-9 .tgl-flat + .tgl-btn:after {
  transition: all 0.2s ease;
  background: #f2f2f2;
  content: "";
  border-radius: 1em;
}

.checkbox-wrapper-9 .tgl-flat:checked + .tgl-btn {
  border: 4px solid #a46cff;
}

.checkbox-wrapper-9 .tgl-flat:checked + .tgl-btn:after {
  left: 50%;
  background: #a46cff;
}
</style>