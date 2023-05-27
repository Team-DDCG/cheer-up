<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/login_logo.png" />

        <p class="sub-title">
          가입 유형을 선택하고, 취얼업의 다양한 기능을 누려보세요!
        </p>
        <progress value="30" max="100" class="progress"></progress>
      </div>
    </div>
    <div>
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
    <div class="mb-3" id="id-box">
      <label for="exampleFormControlInput2" class="form-label">아이디</label>
      <div id="duplicate-box">
        <input
        v-model="id"
        type="text"
        class="form-control"
        id="exampleFormControlInput2"
        placeholder="ID"
      />
      <button @click.prevent="duplicateCheck" type="submit" class="btn btn-primary">중복확인</button>
      </div>
     
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
      <!-- <div id="passwordHelpBlock" class="form-text"></div> -->
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
    
  </div>
</template>
  
  <script>
  import axios from "axios";
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
    duplicateCheck() {
      axios
        //id duplicate api calling
        .get("http://127.0.0.1:8080/api/user-info/register", {
          id:this.id
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => console.log(err));
    },
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
  width: 386px;
  height: 42.01px;
  margin: 40px auto 90px 39%;
  align-items: center;
}

.mb-3 > .form-label {
  color: #f5f5f5;
}
/* #id-box{align-items: center;} */
.form-control{
  width: 300px;
}
.btn.btn-primary {
  background: #a46cff;
}

#duplicate-box .btn.btn-primary {
  font-family: "Montserrat", sans-serif;
  font-size: 13px;
  width: 76px;
  margin-left: 10px;
}

.mb-3-button {
  display: flex; 
  justify-content: center;
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  align-items: center;
  margin-bottom: 90px;
}
#duplicate-box{
  display: flex;
  flex-direction:row;
}
.progress{
   display: flex;
   margin: 0 auto;
   width: 1000px;
   height: 20px; 
   background: #515151;
}

/* 프로그레스 바의 색상을 변경합니다 */
progress::-webkit-progress-value {
  background-color: #a46cff;
}

progress::-moz-progress-bar {
  background-color: #a46cff;
}

progress::-ms-fill {
  background-color: #a46cff;
}

</style>