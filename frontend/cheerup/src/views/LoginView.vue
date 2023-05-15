<template>
  <div style="background-color: #363533;">
    <div id="innerBox">

      <div class="title">
        <h3 style="color: white">취얼업</h3>
        <p style="font-size: 12px; color: white">귀찮은 자소서 작성을 한번에!</p>
      </div>
      <div class="login-form">
        <input class="form-control" type="text" id="id" v-model="id" placeholder="아이디">
        <input class="form-control" type="password" id="password" v-model="password" placeholder="비밀번호">
        <div
          style="
            display: flex;
            justify-content: right;
            align-items: center;
            margin-top: 10px;
            margin-right: 15px;
          "
        >
          <span
            style="
              font-size: 12px;
              margin-bottom: 8px;
              margin-right: 5px;
              color: white;
            "
            >Remember me</span
          >
          <img
            @click="changeToggle"
            v-if="save_toggle === false"
            src="../assets/off-btn.png"
            style="width: 80px; height: 40px"
          />
          <img
            @click="changeToggle"
            v-else-if="save_toggle === true"
            src="../assets/on-btn.png"
            style="width: 80px; height: 40px"
          />
        </div>
      </div>
      <div
        @click="login" class="make-account-btn">Login</div>
      <!-- <div class="make-account-btn">
      <router-link  to="/register">회원가입하기</router-link>
      </div> -->
      <router-link class="make-account-btn" to="/register">회원가입하기</router-link>
    </div>
  </div>
</template>

<script>

import axios from "axios";
export default {
  data() {
    return {
      id: "",
      password: "",
      save_toggle: false,
    };
  },
  components: {  },

  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    },

    changeToggle() {
      this.save_toggle = !this.save_toggle;
    },
        login() {
            axios
                .post("http://127.0.0.1:8000/api/user/signin", {
                    username: this.id,
                    password: this.password,
                })
                .then((res) => {
                    sessionStorage.setItem("accessToken", res.data.access_token);
                    this.$router.push("/home");
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
  
};
</script>

<style scoped>
#innerBox {
  background-color: #515151;
  padding: 50px;
  border-radius: 10px;
  margin: 100px;
  border: 1px solid #808080;
}
.title {
  margin: 40px;
  margin-right: 0px;
  margin-top: 0px;
  margin-left: 30px;
  text-align: left;
  padding-top: 60px;
  font-size: 18px;
  font-weight: 700;
  color: #363533;
}

.make-account-btn {
  width: 240px;
  height: 50px;
  border-radius: 30px;
  margin: 0 auto;
  border: 1px solid #363533;
  line-height: 50px;
  margin-bottom: 10px;
  background-color: #A46CFF; 
  color: black
}

.login-form {
  margin-top: 80px;
  margin-bottom: 90px;
}

.login-form > input {
  width: 240px;
  border: none;
  border-bottom: 1px solid #363533;
  background-color: white;
  padding: 25px;
  padding-bottom: 10px;
  outline: none;
}
</style>
