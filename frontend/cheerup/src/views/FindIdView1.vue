<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <router-link to="/main">
          <img src="../assets/main_logo.png" />
          <!-- <span class="name1">취</span>
          <span class="name2">얼업</span> -->
        </router-link>
        <p class="sub-title">
          취업 준비의 시간을 아끼려면 가입하세요!
        </p>
        <hr />
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
      <label for="exampleFormControlInput2" class="form-label">연락처(- 없이 숫자만 기입)</label>
      <input
        v-model="phone"
        type="tel"
        class="form-control"
        id="exampleFormControlInput2"
        placeholder="01000000000"
      />
    </div>
    <div class="mb-3-button">
      <!-- <button @click.prevent="goBack" type="submit" class="btn btn-secondary">
        이전
      </button> -->
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary">
        아이디 확인
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
        path: "/findid2",
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

.mb-3-button > .btn.btn-primary {
  width: 300px;
  height: 42.01px;
  border-radius: 13px;
  background: #a46cff;
  border-color: #515151;
  box-shadow: 0px 4px 4px 0 rgba(0,0,0,0.3);
}

.mb-3-button {
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  align-items: center;
  margin-bottom: 90px;
}
a{
  text-decoration: none;
}
</style>