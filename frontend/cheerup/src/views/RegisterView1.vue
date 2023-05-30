<template>
  <div class="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/login_logo.png" />

        <p class="sub-title">
          약관에 동의해주셔야 취얼업과 함께할 수 있어요!😥
        </p>
        <!-- <progress value="30" max="100" class="progress"></progress> -->
        <div class="progress-container">
          <div class="progress-bar">
            <div class="progress" :style="{ width: progressBarWidth, transform: progressBarTransform }"></div>
          </div>
        </div>
      </div>
    </div>



      <div class="mb-3">
        <div class="switch-container">
          <label class="switch">
            <input type="checkbox" v-model="isChecked"> 
            <div class="slider">
              <div class="circle">
                <svg class="cross" xml:space="preserve" style="enable-background:new 0 0 512 512" viewBox="0 0 365.696 365.696" y="0" x="0" height="6" width="6" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xmlns="http://www.w3.org/2000/svg">
                  <g>
                    <path data-original="#000000" fill="currentColor" d="M243.188 182.86 356.32 69.726c12.5-12.5 12.5-32.766 0-45.247L341.238 9.398c-12.504-12.503-32.77-12.503-45.25 0L182.86 122.528 69.727 9.374c-12.5-12.5-32.766-12.5-45.247 0L9.375 24.457c-12.5 12.504-12.5 32.77 0 45.25l113.152 113.152L9.398 295.99c-12.503 12.503-12.503 32.769 0 45.25L24.48 356.32c12.5 12.5 32.766 12.5 45.247 0l113.132-113.132L295.99 356.32c12.503 12.5 32.769 12.5 45.25 0l15.081-15.082c12.5-12.504 12.5-32.77 0-45.25zm0 0"></path>
                  </g>
                </svg>
                <svg class="checkmark" xml:space="preserve" style="enable-background:new 0 0 512 512" viewBox="0 0 24 24" y="0" x="0" height="10" width="10" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xmlns="http://www.w3.org/2000/svg">
                  <g>
                    <path class="" data-original="#000000" fill="currentColor" d="M9.707 19.121a.997.997 0 0 1-1.414 0l-5.646-5.647a1.5 1.5 0 0 1 0-2.121l.707-.707a1.5 1.5 0 0 1 2.121 0L9 14.171l9.525-9.525a1.5 1.5 0 0 1 2.121 0l.707.707a1.5 1.5 0 0 1 0 2.121z"></path>
                  </g>
                </svg>
              </div>
            </div>
          </label>
          <div class="agree">
            <em>[필수]&nbsp;</em> 개인정보 동의서
          </div>
        </div>
        <label for="exampleFormControlInput1" class="form-label"></label>
        <textarea v-model="privacyPolicy" class="form-control custom-scrollbar" id="exampleFormControlTextarea2" rows="10" style="height: 150px; white-space: pre-line;" readonly>
        </textarea>
      </div>

      <div class="button-space"></div>
    
      <div class="mb-3">
        <div class="switch-container">
          <label class="switch">
            <input type="checkbox" v-model="isChecked2"> 
            <div class="slider">
              <div class="circle">
                <svg class="cross" xml:space="preserve" style="enable-background:new 0 0 512 512" viewBox="0 0 365.696 365.696" y="0" x="0" height="6" width="6" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xmlns="http://www.w3.org/2000/svg">
                  <g>
                    <path data-original="#000000" fill="currentColor" d="M243.188 182.86 356.32 69.726c12.5-12.5 12.5-32.766 0-45.247L341.238 9.398c-12.504-12.503-32.77-12.503-45.25 0L182.86 122.528 69.727 9.374c-12.5-12.5-32.766-12.5-45.247 0L9.375 24.457c-12.5 12.504-12.5 32.77 0 45.25l113.152 113.152L9.398 295.99c-12.503 12.503-12.503 32.769 0 45.25L24.48 356.32c12.5 12.5 32.766 12.5 45.247 0l113.132-113.132L295.99 356.32c12.503 12.5 32.769 12.5 45.25 0l15.081-15.082c12.5-12.504 12.5-32.77 0-45.25zm0 0"></path>
                  </g>
                </svg>
                <svg class="checkmark" xml:space="preserve" style="enable-background:new 0 0 512 512" viewBox="0 0 24 24" y="0" x="0" height="10" width="10" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xmlns="http://www.w3.org/2000/svg">
                  <g>
                    <path class="" data-original="#000000" fill="currentColor" d="M9.707 19.121a.997.997 0 0 1-1.414 0l-5.646-5.647a1.5 1.5 0 0 1 0-2.121l.707-.707a1.5 1.5 0 0 1 2.121 0L9 14.171l9.525-9.525a1.5 1.5 0 0 1 2.121 0l.707.707a1.5 1.5 0 0 1 0 2.121z"></path>
                  </g>
                </svg>
              </div>
            </div>
          </label>
          <div class="agree">
            <em>[필수]&nbsp;</em> 이용약관 동의서
          </div>
        </div>
        <label for="exampleFormControlInput1" class="form-label"></label>
        <!-- <input
          v-model="name"
          type="text"
          class="form-control"
          id="exampleFormControlInput1"
          placeholder="Name"
        /> -->
        <textarea v-model="privacyPolicy2" class="form-control custom-scrollbar" id="exampleFormControlTextarea2" rows="10" 
         style="height: 150px; white-space: pre-line; " readonly>

        </textarea>
      </div>
    
    
    <div class="mb-3-button">
      <!-- <button @click.prevent="goBack" type="submit" class="btn btn-secondary">
        이전
      </button> -->
      <div class="button-space"></div>
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary" :disabled="!bothCheckboxesChecked " >
        다음
      </button>
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
      progressBarWidth: '45%',
      progressBarTransform: 'translateX(-55%)',
      agreement: '',
      privacyPolicy: `개인정보 동의서

        취얼업(이하 '회사'라고 합니다)은 개인정보보호법 등 관련 법령상의 개인정보보호 규정을 준수하며 귀하의 개인정보보호에 최선을 다하고 있습니다. 회사는 개인정보보호법에 근거하여 다음과 같은 내용으로 개인정보를 수집 및 처리하고자 합니다. 다음의 내용을 자세히 읽어보시고 모든 내용을 이해하신 후에 동의 여부를 결정해주시기 바랍니다.

        제1조(개인정보 수집 및 이용 목적)

        이용자가 제공한 모든 정보는 다음의 목적을 위해 활용하며, 목적 이외의 용도로는 사용되지 않습니다.
        - 본인확인 및 이력서, 자기소개서 작성 기능을 위한 정보


        제2조(개인정보 수집 및 이용 항목)

        회사는 개인정보 수집 목적을 위하여 다음과 같은 정보를 수집합니다.
        - 성명, 주소, 전화번호, 이메일, 성별, 나이 및 생년월일


        제3조(개인정보 보유 및 이용 기간)

        수집한 개인정보는 수집·이용 동의일로부터 회원 탈퇴 시 까지 보관 및 이용합니다.
        개인정보 보유기간의 경과, 처리목적의 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.`,
      privacyPolicy2: `이용약관 동의서

        취얼업(이하 '회사'라고 합니다)은 개인정보보호법 등 관련 법령상의 개인정보보호 규정을 준수하며 귀하의 개인정보보호에 최선을 다하고 있습니다. 회사는 개인정보보호법에 근거하여 다음과 같은 내용으로 개인정보를 수집 및 처리하고자 합니다. 다음의 내용을 자세히 읽어보시고 모든 내용을 이해하신 후에 동의 여부를 결정해주시기 바랍니다.

        제1조(개인정보 수집 및 이용 목적)

        이용자가 제공한 모든 정보는 다음의 목적을 위해 활용하며, 목적 이외의 용도로는 사용되지 않습니다.
        - 본인확인 및 이력서, 자기소개서 작성 기능을 위한 정보


        제2조(개인정보 수집 및 이용 항목)

        회사는 개인정보 수집 목적을 위하여 다음과 같은 정보를 수집합니다.
        - 성명, 주소, 전화번호, 이메일, 성별, 나이 및 생년월일


        제3조(개인정보 보유 및 이용 기간)

        수집한 개인정보는 수집·이용 동의일로부터 회원 탈퇴 시 까지 보관 및 이용합니다.
        개인정보 보유기간의 경과, 처리목적의 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.`,
      isChecked: false,
      isChecked2: false
    };
  },
   mounted() {
    this.startLoading();
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
        path: "/register2",
      });
    },

    startLoading() {
      setTimeout(() => {
        this.progressBarWidth = '65%';
        this.progressBarTransform = 'translateX(-35%)';
      }, 250); 
    }

  },
  created() {
    // this.sessionDataType = sessionStorage.getItem('type');
    sessionStorage.setItem("type", 1);
  },
  computed: {
    bothCheckboxesChecked() {
      return this.isChecked && this.isChecked2;
    },
    // noneChecked() {
    //   return !this.isChecked && !this.isChecked2;
    // }
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
  width: 70%;
  /* height: 100px; */
  margin: 0px auto 90px 25%;
  align-items: center;
}

.mb-3 > .form-label {
  color: #f5f5f5;
}
/* #id-box{align-items: center;} */
.form-control{
  width: 70%;
  height: 100px;
}
.btn.btn-primary {
  background: #a46cff;
  border-color: #515151;
}

#duplicate-box .btn.btn-primary {
  font-family: "Montserrat", sans-serif;
  font-size: 13px;
  width: 80px;
  margin-left: 10px;
}

.mb-3-button {
  display: flex; 
  justify-content: center;
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 70px;
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

.custom-scrollbar {
  scrollbar-width: thin;
  scrollbar-color: #a46cff #363533;
  resize: none; /* 세로 방향 크기 조정 불가능하도록 설정 */
}

.custom-scrollbar::-webkit-scrollbar {
  width: 8px;
}

.custom-scrollbar::-webkit-scrollbar-thumb {
  background-color: #a46cff;
  border-radius: 4px;
}

.custom-scrollbar::-webkit-scrollbar-track {
  background-color: white;
  border-radius: 4px; /* 바깥쪽 바에도 동글동글한 효과 적용 */
}

.radio-buttons {
  display: flex;
  flex-direction: column;
}
.form-check-label {
  color: white;
}

/* input[type="radio"] {
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  outline: none;
  margin-right: 5px;
}

input[type="radio"]:before {
  content: "";
  display: inline-block;
  width: 15px;
  height: 15px;
  border-radius: 50%;
  border: 2px solid white;
  margin-right: 5px;
}

input[type="radio"]:checked:before {
  background-color: white;
} */
/* 
input[type="radio"]:checked + label {
  font-weight: bold;
  color:#a46cff;
} */

.switch {
  /* switch */
  --switch-width: 46px;
  --switch-height: 24px;
  --switch-bg: rgb(131, 131, 131);
  --switch-checked-bg: #a46cff;
  --switch-offset: calc((var(--switch-height) - var(--circle-diameter)) / 2);
  --switch-transition: all .2s cubic-bezier(0.27, 0.2, 0.25, 1.51);
  /* circle */
  --circle-diameter: 18px;
  --circle-bg: #fff;
  --circle-shadow: 1px 1px 2px rgba(146, 146, 146, 0.45);
  --circle-checked-shadow: -1px 1px 2px rgba(163, 163, 163, 0.45);
  --circle-transition: var(--switch-transition);
  /* icon */
  --icon-transition: all .2s cubic-bezier(0.27, 0.2, 0.25, 1.51);
  --icon-cross-color: var(--switch-bg);
  --icon-cross-size: 6px;
  --icon-checkmark-color: var(--switch-checked-bg);
  --icon-checkmark-size: 10px;
  /* effect line */
  --effect-width: calc(var(--circle-diameter) / 2);
  --effect-height: calc(var(--effect-width) / 2 - 1px);
  --effect-bg: var(--circle-bg);
  --effect-border-radius: 1px;
  --effect-transition: all .2s ease-in-out;
}

.switch input {
  display: none;
}

.switch {
  display: inline-block;
}

.switch svg {
  -webkit-transition: var(--icon-transition);
  -o-transition: var(--icon-transition);
  transition: var(--icon-transition);
  position: absolute;
  height: auto;
}

.switch .checkmark {
  width: var(--icon-checkmark-size);
  color: var(--icon-checkmark-color);
  -webkit-transform: scale(0);
  -ms-transform: scale(0);
  transform: scale(0);
}

.switch .cross {
  width: var(--icon-cross-size);
  color: var(--icon-cross-color);
}

.slider {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: var(--switch-width);
  height: var(--switch-height);
  background: var(--switch-bg);
  border-radius: 999px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  position: relative;
  -webkit-transition: var(--switch-transition);
  -o-transition: var(--switch-transition);
  transition: var(--switch-transition);
  cursor: pointer;
}

.circle {
  width: var(--circle-diameter);
  height: var(--circle-diameter);
  background: var(--circle-bg);
  border-radius: inherit;
  -webkit-box-shadow: var(--circle-shadow);
  box-shadow: var(--circle-shadow);
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  -webkit-transition: var(--circle-transition);
  -o-transition: var(--circle-transition);
  transition: var(--circle-transition);
  z-index: 1;
  position: absolute;
  left: var(--switch-offset);
}

.slider::before {
  content: "";
  position: absolute;
  width: var(--effect-width);
  height: var(--effect-height);
  left: calc(var(--switch-offset) + (var(--effect-width) / 2));
  background: var(--effect-bg);
  border-radius: var(--effect-border-radius);
  -webkit-transition: var(--effect-transition);
  -o-transition: var(--effect-transition);
  transition: var(--effect-transition);
}

/* actions */

.switch input:checked+.slider {
  background: var(--switch-checked-bg);
}

.switch input:checked+.slider .checkmark {
  -webkit-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
}

.switch input:checked+.slider .cross {
  -webkit-transform: scale(0);
  -ms-transform: scale(0);
  transform: scale(0);
}

.switch input:checked+.slider::before {
  left: calc(100% - var(--effect-width) - (var(--effect-width) / 2) - var(--switch-offset));
}

.switch input:checked+.slider .circle {
  left: calc(100% - var(--circle-diameter) - var(--switch-offset));
  -webkit-box-shadow: var(--circle-checked-shadow);
  box-shadow: var(--circle-checked-shadow);
}
em{
  font-style: normal;
  color: #a46cff;
  font-weight: bold;
}

.switch-container {
  display: flex;
  align-items: center;
}

.switch {
  margin-right: 10px;
}

.agree {
  display: flex;
  align-items: center;
  color: #fff;
}

textarea {
  height: 500px;
  box-sizing: border-box;
}

.button-space {
  margin-top: 25px;
}
</style>