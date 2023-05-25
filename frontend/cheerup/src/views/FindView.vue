<template>
  <div id="main">
    <div class="main-title">
      <div class="name">
        <img src="../assets/logo.png" />
        <span class="name1">취</span>
        <span class="name2">얼업</span>
        <p class="sub-title">
          분실하셨나요? 아래 내용을 선택해주세요!
        </p>
      </div>
    </div>
    <hr />
    <div id="innerBox">
      <div class="box">
        <input
          type="radio"
          v-model="radioValues"
          class="btn-check"
          name="options"
          id="option"
          autocomplete="off"
          value="0"
        />
        <label class="btn btn-light" for="option">아이디 찾기</label>
        <input
          type="radio"
          v-model="radioValues"
          class="btn-check"
          name="options"
          id="option2"
          autocomplete="off"
          value="1"
        />
        <label class="btn btn-light" for="option2">비밀번호 찾기</label><br />
      </div>
      <div class="box2">
        <button
          @click.prevent="submitForm"
          type="submit"
          class="btn btn-primary"
        >
          선택
        </button>
      </div>
    </div>
  </div>
</template>
  
  <script>
export default {
  data() {
    return {
      radioValues: "",
    };
  },
  methods: {
    async submitForm() {
      const userData = {
        type: this.radioValues,
      };
      sessionStorage.setItem("type", userData.type);

      if (this.radioValues === "0") {
        this.$router.push({
          path: "/findid1",
        });
      } else if (this.radioValues === "1") {
        this.$router.push({
          path: "/findpw1",
        });
      }
    },
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

#innerBox {
  padding: 0 50px 0 50px;
  border-radius: 10px;
  margin: 0 100px 0;
  align-items: center;
}
.btn.btn-light {
  width: 230px;
  height: 230px;
  text-align: center;
  color: #363533;
  font-size: 28px;
  font-weight: 700;
  margin: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.btn.btn-light:hover {
  background: #a46cff;
  color: #f5f5f5;
}

#innerBox > .box2 > .btn.btn-primary {
  margin: 0 auto;

  width: 300px;
  height: 42.01px;
  background: #a46cff;
  border-width: 1;
  border-color: #363533;
  border-radius: 13px;
  text-align: center;
  color: #f5f5f5;
  font-size: 20px;
  font-weight: 700;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.3);
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
.box {
  display: flex;
  justify-content: center;
  align-items: center;
}
.box2 {
  display: flex;
  justify-content: center;
  align-items: center;
}

input[type="radio"].btn-check:checked + label.btn.btn-light {
  background-color: #a46cff;
  color: #f5f5f5;
}
</style>