<template>
  <div>
    <tool-bar></tool-bar>
    <div class="container">
      <div id="error">
        <div class="warning">
          <div class="warning-box">
            <p class="warning-icon">⚠️</p>
            <p class="title">주의 내용 제목으로 지정</p>
          </div>
            <p class="content">주의 사항 여기에 내용을 블라블라 적어보쟈 훌룰룰룰랄라랄ㄹ라라랄라라</p>        
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

    }
  },
  mounted() {

  },
  methods: {
    
  },
};
</script>



<style scoped>
.container {
  display: flex;
  justify-content: center;
  padding-top: 100px;
  padding-bottom: 100px;
  
}

#error {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  overflow: hidden;
  gap: 10px;
  padding-left: 700px;
  padding-right: 700px;
  padding-top: 190px;
  padding-bottom: 190px;
  border-radius: 25px;
  background: #f5f5f5;
  border-width: 3px;
  border-color: #a46cff;
}

.warning-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 360px;
  height: 250px;
  left: 54px;
  top: 0;
}

.warning-icon {
  font-size: 100px;
  font-weight: 700;
  text-align: center;
  color: #000;
  margin-bottom: 10px;
}

.title {
  font-size: 32px;
  font-weight: 700;
  text-align: center;
  color: #515151;
  margin-bottom: 10px;
}

.content {
  font-size: 15px;
  font-weight: 700;
  text-align: center;
  color: #a46cff;
}


</style>