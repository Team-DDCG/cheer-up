<template>
  <div>
    <tool-bar></tool-bar>
    <div id="main">
      <div class="container">
        <div id="myDiv">
          <div class="header">
            <div class="line">
              <div class="line1">
                <p id="title1">자기소개서 조회 > 첨삭게시판</p>
                <br />
              </div>
              <div class="table">
                <table>
                  <tr>
                    <th class="c1">회사명</th>
                    <th class="c2">공고제목</th>
                    <th class="c3">작성자</th>
                  </tr>
                  <tr>
                    <td class="c1">KB국민은행</td>
                    <td class="c2">[신입]kb국민은행 신입 채용</td>
                    <td class="c3">임찬연</td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
          <div id="filter">
            <div id="input">
              <div>
                <div>
                  <select class="form-select" v-model="selectedOption1">
                    <option value="option1">회사명</option>
                    <option value="option2">공고 제목</option>
                    <option value="option2">작성자</option>
                  </select>
                  <div>
                    | &nbsp;<img
                      src="https://d2bovrvbszerbl.cloudfront.net/assets/icon/ic_search-c35fc43a726d9245c9bf98a8d5b101c1a54f7e71d063e2950d4c81b38873b023.svg"
                    />
                    <div>
                      <input
                        type="text"
                        placeholder="검색"
                        v-model="searchInput"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- <button @click.prevent="saveOption" type="submit">저장</button> -->
            <!-- <select class="form-select2" v-model="selectedOption2">
              <option value="option1">조회순</option>
              <option value="option2">?</option>
              <option value="option2">?</option>
            </select> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";

export default {
  components: { ToolBar },
  data() {
    return {};
  },
  mounted() {},
  methods: {},
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
#filter {
  width: 100%;
  display: flex;
  justify-content: flex-start; /* Align to the right */
  margin-top: 450px; /* Move to the bottom */
  padding: 20px;
}
#post {
  width: 80%;
  padding: 20px;
  border: 1px solid #808080;
  border-radius: 5px;
  background-color: #515151;
  color: white;
  font-family: "Montserrat", sans-serif;
  font-size: 20px;
}
#main {
  width: 90%;
  text-align: center;
  padding-top: 10px;
  background-color: #363533;
  margin: 0 auto;
}
#input {
  width: 80%;
  height: 40px;
  border-radius: 5px;
  border: 1px solid #808080;
  background-color: #808080;
  margin-right: 1.5%;
  color: white;

  display: flex;
  align-items: center;
  position: relative;
  cursor: text;
  padding: 8px 16px;
}
#input div {
  display: flex;
  align-items: center;
  flex: auto;
  border: 1px solid transparent;
  box-sizing: content-box;
}
input {
  background-color: #808080;
  color: white;
  width: 100%;
  padding: 0;
  border: none;
  outline: none;
  font-weight: 350;
  font-family: "Montserrat", sans-serif;
  font-size: 15px;
}
input::placeholder {
  font-family: "Montserrat", sans-serif;
  font-size: 15px;
  color: white;
}
select {
  width: 30%;
  height: 40px;
  border-radius: 5px;
  border: 1px solid #808080;
  background-color: #808080;
  color: white;
  overflow-y: auto;
}
option {
  overflow-y: scroll;
}
button {
  text-align: center;
  width: 92px;
  height: 40px;
  border: 1px solid #363533;
  border-radius: 5px;
  line-height: 40px;
  background-color: #a46cff;
  color: white;
  font-family: "Montserrat", sans-serif;
  font-size: 15px;
  text-decoration: none;
}
.form-select2 {
  text-align: center;
  width: 92px;
  height: 40px;
  border: 1px solid #363533;
  border-radius: 5px;
  line-height: 40px;
  background-color: #a46cff;
  color: white;
  font-family: "Montserrat", sans-serif;
  font-size: 15px;
  text-decoration: none;
}
</style>