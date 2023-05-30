<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/login_logo.png" />

        <p class="sub-title">
          거의 다 왔어요!🥰
        </p>
        <!-- <progress value="60" max="100" class="progress"></progress> -->
        <div class="progress-container">
          <div class="progress-bar">
            <div class="progress" :style="{ width: progressBarWidth, transform: progressBarTransform }"></div>
          </div>
        </div>

      </div>
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">생년월일</label>
      <input
        v-model="birth"
        type="date"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="Birth date"
      />
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">전화번호</label>
      <input
        v-model="phone"
        type="tel"
        class="form-control"
        id="exampleFormControlInput2"
        placeholder="phone"
      />
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">성별</label
      ><br />
      <div class="form-check form-check-inline">
        <input
          v-model="sex"
          class="form-check-input"
          type="radio"
          name="inlineRadioOptions"
          id="inlineRadio1"
          value="0"
        />
        <label class="form-check-label" for="inlineRadio1">남성</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-model="sex"
          class="form-check-input"
          type="radio"
          name="inlineRadioOptions"
          id="inlineRadio2"
          value="1"
        />
        <label class="form-check-label" for="inlineRadio2">여성</label>
      </div>
    </div>
    <div class="mb-3-button">
      <button @click.prevent="goBack" type="submit" class="btn btn-secondary">
        이전
      </button>
      <div class="button-space"></div>
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary">
        다음
      </button>
    </div>
  </div>
</template>
  
  <script>
export default {
  data() {
    return {
      birth: "",
      phone: "",
      sex: "",
      progressBarWidth: '80%',
      progressBarTransform: 'translateX(-20%)'
    };
  },
  mounted() {
    this.startLoading();
  },
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    },
    async submitForm() {
      const userData = {
        // type: this.sessionDataType,
        birth: this.birth,
        phone: this.phone,
        sex: this.sex,
      };

      // sessionStorage.setItem('type', userData.type);
      sessionStorage.setItem("birth", userData.birth);
      sessionStorage.setItem("phone", userData.phone);
      sessionStorage.setItem("sex", userData.sex);

      this.$router.push({
        path: "/register4",
      });
    },

    startLoading() {
      setTimeout(() => {
        this.progressBarWidth = '90%';
        this.progressBarTransform = 'translateX(-10%)'
      }, 250); 
    }
  },
  created() {
    // this.sessionDataType = sessionStorage.getItem('type');
    // this.sessionDataName = sessionStorage.getItem('name');
    // this.sessionDataId = sessionStorage.getItem('id');
    // this.sessionDataPassword = sessionStorage.getItem('password');
  },
};
</script>
  
  <style scoped>
img {
  vertical-align: 0%;
  width: 280px;
  height: 70px;
  margin-bottom: 25px;
}
#main {
  margin: 0 auto;
}
.main-title {
  margin: 50px;
  align-items: center;
  color: #f5f5f5;
  background: #515151;
}

.main-title > .name .name1 {
  font-weight: 700;
  font-family: "Montserrat", sans-serif;
  font-size: 64px;
  text-align: center;
  color: #a46cff;
}

.main-title > .name .name2 {
  font-weight: 700;
  font-family: "Montserrat", sans-serif;
  font-size: 64px;
  font-weight: 700px;
  text-align: center;
  color: #f5f5f5;
}
.main-title > .name {
  margin: 0 auto;
  text-align: center;
  background: #363533;
}

.mb-3 {
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  align-items: center;
  margin-bottom: 90px;
}

.mb-3 > .form-label {
  color: #f5f5f5;
}

.mb-3 .form-check-label {
  color: #f5f5f5;
}

.mb-3-button > .btn.btn-primary {
  background: #a46cff;
  border-color: #515151;

}

.mb-3-button {
  display: flex; 
  justify-content: center;
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 60px;
  align-items: center;
  margin-bottom: 90px;
}
.progress{
   display: flex;
   margin: 0 auto;
   width: 1000px;
   height: 20px; 
   background: #515151;
}

/* 프로그레스 바의 색상을 변경합니다 */
/* progress::-webkit-progress-value {
  background-color: #a46cff;
}

progress::-moz-progress-bar {
  background-color: #a46cff;
}

progress::-ms-fill {
  background-color: #a46cff;
} */

.progress-container {
  width: 60%;
  margin: 0 auto;
  text-align: center;
}
.progress-bar {
  position: relative;
  width: 100%;
  height: 20px;
  background-color: #515151;
  border-radius: 10px;
  overflow: hidden;
}

.progress {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  background-color: #a46cff;
  transition: transform 0.3s;
}
.button-space {
  margin: 0 10px;
}
</style>