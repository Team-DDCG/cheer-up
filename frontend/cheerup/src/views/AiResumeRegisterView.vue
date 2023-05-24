<template>
  <tool-bar></tool-bar>
  <div class="container">
    <div id="myDiv">
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
</style>