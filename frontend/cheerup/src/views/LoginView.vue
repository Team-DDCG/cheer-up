<template>
  <div class="main">
    <div id="innerBox">

      <div class="main-title">

        <div class="name">
          <img src="../assets/logo.png"/>
          <span class ="name1">취</span>
          <span class ="name2">얼업</span>
          
          <p class ="sub-title">귀찮은 자소서 작성을 한번에!</p>
        </div>
      </div>
      <div class="login-form">
        <input class="form-control" type="text" id="id" v-model="id" placeholder="ID">
        <input class="form-control" type="password" id="password" v-model="password" placeholder="Password">
      </div>
      <div class ="remember">
       <input type="checkbox" name="xxx" value="yyy" checked>
          <!-- <img
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
          /> -->
          <span class="remember1">&nbsp;Remember me</span>
          <span class="find">아이디/비밀번호찾기</span>
          
        </div>
      <div class="button">
      <div
        @click="login" class="make-account-btn">login</div>
      <router-link  to="/register"><div class="make-account-btn">회원가입</div></router-link>
    </div>
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
                .post("http://127.0.0.1:8888/user/login", {
                    id: this.id,
                    password: this.password,
                })
                .then((res) => {
                    // sessionStorage.setItem("accessToken", res.data.access_token);
                    sessionStorage.setItem("name", res.data.userName);
                    this.$router.push("/");
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
  
};
</script>

<style scoped>
img {
  vertical-align:0% ;
}
.main {
	width:100vw;
	height:100vh;
	display:flex;
	justify-content:center;
	align-items:center;
  background-color: #363533;
}
#innerBox {
 width: 450px;
    height: 515px;
    border-Radius: 16px;
    background: #515151;
    border: 1px solid #808080;
}
.main-title {
  margin: 50px;
  align-items: center;
  font-size: 18px;
  font-weight: 700;
  color: #f5f5f5;
  background: #515151;
}
.main-title > h3{
     width: 230;
      height: 81;
      left: 560;
      top: 243;
      font-Size: 64;
      text-align: center;
}
.main-title > .name .name1 {
  font-size: 64px;
  font-weight: 700px;
  text-align: center;
  color: #a46cff;
}

.main-title > .name .name2 {
   width: 230px;
        height: 81px;
        font-Size: 64px;
        font-Weight: 700px;
        text-Align: center;
        color: #f5f5f5;
}

.main-title > .name{
  margin: 0 auto;
  text-align: center;
  background: #515151;
}

.main-title > .name .sub_title{
     width: 194;
     height: 18.67px; 
     font-Size: 16px; 
     text-Align: center; 
     color: #f5f5f5; 
     
}


.make-account-btn {
  text-align: center;
  width: 300px;
  height: 50px;
  border-radius: 30px;
  margin: 0 auto;
  border: 1px solid #363533;
  border-radius: 13px;
  line-height: 50px;
  margin-bottom: 10px;
  background-color: #A46CFF; 
  color: black;
}

.login-form {
  width: 300px;
  height: 42.01px;
  margin: 0 auto;
  margin-top: 40px;
  align-items: center;
  margin-bottom: 90px;
}

.login-form > .form-control {
  width: 300px;
  height: 42.01px;
  border: none;
  border-bottom: 1px solid #363533;
  background-color: #f5f5f5;
  border-radius: 13px;
  margin-bottom: 20px;
  padding: 25px;
  outline: none;
}
.button {
  display: block;
  background: #515151;
}
.remember{
  background: #515151;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
  margin-right: 15px;
  font-Size: 14px;
  font-Weight: 500;
  text-Align: center;
  color: #f5f5f5;
}
.remember > .remember1{
  font-size: 14px;
  display: flex;
  margin-bottom: 8px;
  margin-right: 5px;
  color: #f5f5f5;
}
.remember > .find{
  font-size: 14px;
  display: flex;
  margin-bottom: 8px;
  margin-right: 5px;
  color: #f5f5f5;
}


a {
  text-decoration: none;
}


</style>
