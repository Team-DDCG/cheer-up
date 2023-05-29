<template>
<div>
  <tool-bar></tool-bar>
    <div class="container" v-if="seekerId && id">
      <div id="myDiv">
        <div class="header">
          <div class="line">
            <div class="line1">
              <p id="title1">포트폴리오</p>
              <br />
            </div>
            
          </div>
        </div>
        <div class="footer">
        <div class="mb-3-button">
          <div class="button-container">
            <button type="submit" class="btn btn-primary">
              출력
            </button>
          </div>
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
    return {
      seekerId: sessionStorage.getItem("seekerId"),
      id: sessionStorage.getItem("id"),
    };
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
.btn.btn-secondary{
  background: #a46cff;
  border-Color: #808080;
  margin-right: 5px;
}
.btn.btn-primary {
  background: #a46cff;
  border-Color: #808080;
}
.footer{
  margin-top: 550px;
}
.btn.btn-info{
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