<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/logo.png" />
        <span class="name1">취</span>
        <span class="name2">얼업</span>
        <p class="sub-title">
          가입 유형을 선택하고, 취얼업의 다양한 기능을 누려보세요!
        </p>
      
        <div class="progress">
          <div
            class="progress-bar"
            role="progressbar"
            aria-valuenow="0"
            aria-valuemin="0"
            aria-valuemax="100"
          ></div>
        </div>
      </div>
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">이름</label>
      <input
        v-model="name"
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="Name"
      />
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">아이디</label>
      <input
        type="radio"
        v-model="radioValues"
        class="btn-check"
        name="options"
        id="option2"
        autocomplete="off"
        value="1"
      />

      <input
        v-model="id"
        type="text"
        class="form-control"
        id="exampleFormControlInput2"
        placeholder="ID"
      />
    </div>
    <div class="mb-3">
      <label for="inputPassword" class="form-label">비밀번호</label>
      <input
        v-model="password"
        type="password"
        id="inputPassword"
        class="form-control"
        placeholder="Password"
        aria-labelledby="passwordHelpBlock"
      />
      <div id="passwordHelpBlock" class="form-text"></div>
    </div>
    <div class="mb-3">
      <label for="inputPassword2" class="form-label">비밀번호 확인</label>
      <input
        type="password"
        id="inputPassword2"
        class="form-control"
        placeholder="Password"
      />
    </div>
    <div class="mb-3-button">
      <button @click.prevent="goBack" type="submit" class="btn btn-secondary">
        이전
      </button>
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
      // sessionDataType: '',
      name: "",
      id: "",
      password: "",
    };
  },
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    },
    async submitForm() {
      const userData = {
        // type: this.sessionDataType,
        name: this.name,
        id: this.id,
        password: this.password,
      };

      // sessionStorage.setItem('type', userData.type);
      sessionStorage.setItem("name", userData.name);
      sessionStorage.setItem("id", userData.id);
      sessionStorage.setItem("password", userData.password);

      this.$router.push({
        path: "/register3",
      });
    },
  },
  created() {
    // this.sessionDataType = sessionStorage.getItem('type');
  },
};
</script>
  
  <style scoped>
img {
  vertical-align: 0%;
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

.mb-3-button > .btn.btn-primary {
  background: #a46cff;
}

.mb-3-button {
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  align-items: center;
  margin-bottom: 90px;
}
.main > .main-title .progress{
   display: flex;
   margin: 0 auto;
   width: 1000px;
   height: 20px; 
   background: #515151;
}

</style>