<template>
  <div>
    <tool-bar></tool-bar>
    <div class="container">
      <div id="myDiv">
        <div class="header">
          <div class="line">
          <div class="line1">
              <p class="title1">AI 자기소개서 생성</p>
              <p class="title2">[KB증권] 2023 대졸 신입사원 공개채용</p>
            <div class="line2">
              <p class="start-date">시작일: 2023-05-10</p>
              <p class="deadline">마감일: 2023-05-24</p>
            </div>
            <hr>
          </div>
          </div>
          <!-- <div class="line2">
            <p class="start-date">시작일: 2023-05-10</p><br>
            <p class="deadline">마감일: 2023-05-24</p>
            <hr>
          </div> -->
        </div>
        <div class="info">
          <p class="text2">
            <span class="bold">KB_12445</span>
            <span>님의</span>
          </p>
          <p class="text1">
            <span class="bold">케이비증권(주)</span>
            <span>에 대한 기업적합도 분석입니다.</span>
          </p>
        </div>
        <div class="graph-box"></div>
      </div>
    </div>
  </div>
</template>

<script>
import ToolBar from "../components/ToolBar.vue";

export default {
  components: { ToolBar },
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
  height: 1481px;
  border-radius: 5px;
  background: #515151;
  border-width: 1px;
  border-color: #808080;
}

.graph-box {
  width: 870px;
  height: 303px;
  border-radius: 33px;
  background: #363533;
  border-width: 5px;
  border-color: #363533;
  justify-content: center;
  display: flex;
  margin: 0 auto;
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
  padding-left: 100px;
  margin-top: 30px;
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