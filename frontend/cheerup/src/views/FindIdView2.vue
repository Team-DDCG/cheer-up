<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/logo.png" />
        <span class="name1">취</span>
        <span class="name2">얼업</span>
        <p class="sub-title">취업 준비의 시간을 아끼려면 가입하세요!</p>
        <hr />
      </div>
    </div>
    <div id="innerBox">
      <span class="content">
        당신의 아이디는<br />
        0000000입니다😁
      </span>
    </div>

    <div class="mb-3-button">
      <!-- <button @click.prevent="goBack" type="submit" class="btn btn-secondary">
        이전
      </button> -->
      <button  class="btn btn-primary"><router-link to="/login">
        로그인 하기</router-link>
      </button>
      <button class="btn btn-primary"><router-link to="/findpassword">
        비밀번호 찾기</router-link>
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
        path: "/findid3",
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
  margin-bottom: 90px;
  align-items: center;
}

.mb-3 > .form-label {
  color: #f5f5f5;
}

.mb-3-button > .btn.btn-primary {
  width: 300px;
  height: 42.01px;
  border-radius: 13px;
  background: #f5f5f5;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.3);
  color: #a46cff;
  font-size: 15px;
  font-weight: 700;
  text-transform: capitalize;
  margin-bottom: 10%;
  
}

.mb-3-button {
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  margin-bottom: 90px;
  align-items: center;
}
#innerBox {
  display: flex;
  margin: 0 auto;
  width: 300px;
  height: 197px;
  border-radius: 16px;
  background: #515151;
  border: 1px solid #808080;
}
#innerBox > .content {
  width: 300px;
  height: 27.36px;
  font-size: 14px;
  text-align: center;
  color: #f5f5f5;
  margin-top: 25%;

}
a {
  text-decoration: none;
  color: #a46cff;
}
</style>