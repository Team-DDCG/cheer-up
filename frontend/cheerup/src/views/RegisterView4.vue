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
      <label for="exampleFormControlInput1" class="form-label">주소</label>
      <input
        v-model="address"
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="Address"
      />
    </div>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">이메일</label>
      <input
        v-model="email"
        type="email"
        class="form-control"
        id="exampleFormControlInput2"
        placeholder="Email"
      />
    </div>
    <div class="mb-3">
      <div class="form-check">
        <input
          v-model="mail_check"
          class="form-check-input"
          type="checkbox"
          true-value=1
          lse-value=0
          id="flexCheckChecked"
          checked
        />
        <label class="form-check-label" for="flexCheckChecked">
          (선택) 3일 동안 유료 채용 공고 및 자동 자기소개서 <br />
          생성 후 전송을 위한 이메일 수신에 동의하시겠습니까?
        </label>
      </div>
    </div>
    <div class="mb-3-button">
      <button @click.prevent="goBack()" type="submit" class="btn btn-secondary">
        이전
      </button>
      <button @click.prevent="makeAccount()" type="submit" class="btn btn-primary">
  취얼업과 함께할 준비 완료
</button>
    </div>
  </div>
</template>
  
  <script>
import axios from "axios";

export default {
  data() {
    return {
      address: "",
      email: "",
      mail_check: 0,
    };
  },
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    },
    async makeAccount() {
      // const userData = {
      //     address: this.address,
      //     email: this.email,
      //     mail_check: this.mail_check,
      // }
      axios
        .post("http://127.0.0.1:8080/api/user-info/register", {
          type: this.sessionDataType,
          userName: this.sessionDataName,
          id: this.sessionDataId,
          password: this.sessionDataPassword,
          birthdate: this.sessionDataBirth,
          sex: this.sessionDataSex,
          phone: this.sessionDataPhone,
          userStatus: 1,
          mailCheck: this.mail_check,
          address: this.address,
          email: this.email,
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));

      this.$router.push({
        path: "/",
      });
    },
  },
  created() {
    this.sessionDataType = sessionStorage.getItem("type");
    this.sessionDataName = sessionStorage.getItem("name");
    this.sessionDataId = sessionStorage.getItem("id");
    this.sessionDataPassword = sessionStorage.getItem("password");
    this.sessionDataBirth = sessionStorage.getItem("birth");
    this.sessionDataSex = sessionStorage.getItem("sex");
    this.sessionDataPhone = sessionStorage.getItem("phone");
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
.mb-3 > .form-label {
  color: #f5f5f5;
}

.mb-3 .form-check-label {
  color: #f5f5f5;
  font-size: 11px;
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