<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/login_logo.png" />

        <p class="sub-title">
          취얼업과 함께 취뽀할 준비 되셨나요?😉💕
        </p>
        <!-- <progress value="90" max="100" class="progress"></progress> -->
        <div class="progress-container">
          <div class="progress-bar">
            <div class="progress" :style="{ width: progressBarWidth, transform: progressBarTransform }"></div>
          </div>
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
      <div class="button-space"></div>
      <button @click.prevent="goBack()" type="submit" class="btn btn-secondary">
        이전
      </button>
      <div class="buttons">
        <button @click.prevent="makeAccount()" type="submit" class="btn"><span></span><p data-start="" data-text="start!" data-title="취얼업과 함께할 준비완료"></p></button>
      </div>
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
      progressBarWidth: '90%',
      progressBarTransform: 'translateX(-10%)'
    };
  },
  mounted() {
    this.startLoading();
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
        .post("http://127.0.0.1:8080/api/info/register", {
          // type: this.sessionDataType,
          id: this.sessionDataId,
          password: this.sessionDataPassword,
          userName: this.sessionDataName,
          birthdate: this.sessionDataBirth,
          sex: this.sessionDataSex,
          email: this.email,
          phone: this.sessionDataPhone,
          userStatus: this.sessionDataType,
          mailCheck: this.mail_check,
          address: this.address,
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));

      this.$router.push({
        path: "/",
      });
    },
    startLoading() {
      setTimeout(() => {
        this.progressBarWidth = '100%';
        this.progressBarTransform = 'translateX(0)'
      }, 250); 
    }
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
  display: flex; 
  justify-content: center;
  flex-direction: column;
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 50px;
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

/*bg*/
/*txt*/
/*success*/
.buttons {
  display: flex;
  justify-content: space-around;
  top: 20px;
  left: 20px;
}
/* #515151 */
.buttons button {
  width: 250px;
  height: 50px;
  background-color: #a46cff;
  margin: 10px;
  color: white;
  position: relative;
  overflow: hidden;
  font-size: 14px;
  letter-spacing: 1px;
  font-weight: 500;
  text-transform: uppercase;
  transition: all 0.3s ease;
  cursor: pointer;
  border: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 5px;
}

.buttons button:before, .buttons button:after {
  content: "";
  position: absolute;
  width: 0;
  height: 2px;
  background-color: whitesmoke;
  transition: all 0.3s cubic-bezier(0.35, 0.1, 0.25, 1);
}

.buttons button:before {
  right: 0;
  top: 0;
  transition: all 0.5s cubic-bezier(0.35, 0.1, 0.25, 1);
}

.buttons button:after {
  left: 0;
  bottom: 0;
}

.buttons button span {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  margin: 0;
  padding: 0;
  z-index: 1;
}

.buttons button span:before, .buttons button span:after {
  content: "";
  position: absolute;
  width: 2px;
  height: 0;
  background-color: white;
  transition: all 0.3s cubic-bezier(0.35, 0.1, 0.25, 1);
}

.buttons button span:before {
  right: 0;
  top: 0;
  transition: all 0.5s cubic-bezier(0.35, 0.1, 0.25, 1);
}

.buttons button span:after {
  left: 0;
  bottom: 0;
}

.buttons button p {
  padding: 0;
  margin: 0;
  transition: all 0.4s cubic-bezier(0.35, 0.1, 0.25, 1);
  position: absolute;
  width: 100%;
  height: 100%;
}

.buttons button p:before, .buttons button p:after {
  position: absolute;
  width: 100%;
  transition: all 0.4s cubic-bezier(0.35, 0.1, 0.25, 1);
  z-index: 1;
  left: 0;
}

.buttons button p:before {
  content: attr(data-title);
  top: 50%;
  transform: translateY(-50%);
}

.buttons button p:after {
  content: attr(data-text);
  top: 150%;
  color: white;
}

.buttons button:hover:before, .buttons button:hover:after {
  width: 100%;
}

.buttons button:hover span {
  z-index: 1;
}

.buttons button:hover span:before, .buttons button:hover span:after {
  height: 100%;
}

.buttons button:hover p:before {
  top: -50%;
  transform: rotate(5deg);
}

.buttons button:hover p:after {
  top: 50%;
  transform: translateY(-50%);
}

.buttons button.start {
  background-color: #a46cff;
  box-shadow: 0px 5px 10px -10px rgba(0, 0, 0, 0.2);
  transition: all 0.2s ease;
}

.buttons button.start p:before {
  top: -50%;
  transform: rotate(5deg);
}

.buttons button.start p:after {
  color: white;
  transition: all 0s ease;
  content: attr(data-start);
  top: 50%;
  transform: translateY(-50%);
  animation: start 0.3s ease;
  animation-fill-mode: forwards;
}

@keyframes start {
  from {
    top: -50%;
  }
}

.buttons button.start:hover:before, .buttons button.start:hover:after {
  display: none;
}

.buttons button.start:hover span {
  display: none;
}

.buttons button:active {
  outline: none;
  border: none;
}

.buttons button:focus {
  outline: 0;
}

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
  margin-top: 25px;
}
</style>