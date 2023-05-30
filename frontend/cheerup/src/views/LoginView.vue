<template>
  <div class="main">
    <div id="innerBox">
      <div class="main-title">
        <div class="name">
          <router-link to="/main">
            <img src="../assets/login_logo.png" />
          </router-link>    
          <p class="sub-title">막막한 취업준비, 든든한 취얼업과 함께!</p>
        </div>
      </div>
      <div class="login-form">
        <input
          class="form-control"
          type="text"
          id="id"
          v-model="id"
          placeholder="ID"
        />
        <input
          class="form-control"
          type="password"
          id="password"
          v-model="password"
          placeholder="Password"
        />
      </div>
      <p v-if="check==='error'" class="missing">계정 정보가 확인되지 않습니다</p>
      <p v-else class="missing"></p>
      <div class="remember">
        <div>
          <input id="remember" type="checkbox" name="xxx" value="yyy" checked />
          <span class="remember1">&nbsp;Remember me</span>
        </div>

        <router-link to="/find"
          ><span class="find">아이디/비밀번호찾기</span></router-link
        >
      </div>
      <div class="button">
        <div @click="login()" class="make-account-btn">login</div>
        <router-link to="/register"
          ><div class="make-account-btn">회원가입</div></router-link
        >
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
      check: '',
      user:'',
    };
  },
  components: {},

  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push("/");
    },

    changeToggle() {
      this.save_toggle = !this.save_toggle;
    },
    login() {
      axios
        .post(this.$store.state.baseUrl+"api/info/login", {
          id: this.id,
          password: this.password,
        })
        .then((res) => {
          // sessionStorage.setItem("accessToken", res.data.access_token);
          sessionStorage.setItem("name", res.data.userName);
          sessionStorage.setItem("id", res.data.userId);
          localStorage.setItem('isLoggedIn', 'true');


          axios
            .get(this.$store.state.baseUrl+"api/info/"+res.data.userId, {
            })
            .then((res) => {
              this.user = res.data;
              console.log(this.user);
              if(this.user.userStatus === 0) {
                axios
                .get(this.$store.state.baseUrl+"api/seekers/"+res.data.userId, {
                })
                .then((res) => {
                  this.seekerId = res.data.seekerId;
                  sessionStorage.setItem("seekerId",res.data.seekerId);
                })
                .catch((err) => {
                  console.log(err);
                  this.check = 'error';
                });
              } else {
                  axios
                  .get(this.$store.state.baseUrl+"api/mentors/"+res.data.userId, {
                  })
                  .then((res) => {
                      this.mentorId = res.data.seekerId;
                      sessionStorage.setItem("mentorId",res.data.mentorId);
                  })
                  .catch((err) => {
                      console.log(err);
                      this.check = 'error';
                  });
              }
            })
            .catch((err) => {
              console.log(err);
              this.check = 'error';
            });



          this.$router.push("/");
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
    },
  },
};
</script>

<style scoped>
#remember{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 16px;
  height: 16px;
  border-radius: 5px;
  margin-right: 5px;
  /* border: 2px solid #ccc; */
  outline: none;
  transition: background-color 0.3s;
  background-color: #a46cff;
  border: 1px solid #808080;
}
#remember:checked{
  background-color: #a46cff;
}

.missing {
  height: 13px;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
  text-align: center;
  color: #E51616;
}
img {
  vertical-align: 0%;
  width: 280px;
  height: 70px;
  margin-bottom: 25px;
  margin-left: 60px;
}
.main {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #363533;
}
#innerBox {
  width: 450px;
  height: 515px;
  border-radius: 16px;
  background: #515151;
  border: 1px solid #808080;
}
.main-title {
  margin: 30px;
  align-items: center;
  color: #f5f5f5;
  background: #515151;
}
.main-title > h3 {
  width: 230;
  height: 81;
  left: 560;
  top: 243;
  font-size: 64;
  text-align: center;
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
  background: #515151;
}

.main-title > .name .sub_title {
  width: 194;
  height: 18.67px;
  font-size: 16px;
  text-align: center;
  color: #f5f5f5;
  font-family: "Montserrat", sans-serif;
  font-size: 16px;
}

.make-account-btn {
  text-align: center;
  width: 300px;
  height: 50px;
  border-radius: 30px;
  margin: 0 auto;
  box-shadow: 0 2px 3px #363533;
  border: 1px solid #515151;
  border-radius: 13px;
  line-height: 50px;
  margin-bottom: 10px;
  background-color: #a46cff;
  color: white;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
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
.remember {
  background: #515151;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 300px;
  margin: 0 auto;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 14px;
  font-weight: 500;
  text-align: center;
  color: #f5f5f5;
}
.remember > .remember1 {
  display: flex;
  /* margin-bottom: 8px; */
  /* margin-right: 5px; */
  color: #f5f5f5;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
}
.remember > .find {
  display: flex;
  /* margin-bottom: 8px; */
  /* margin-right: 5px; */
  color: #f5f5f5;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
}

.find:hover {
  display: flex;
  /* margin-bottom: 8px; */
  /* margin-right: 5px; */
  color: #a46cff;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
}

a {
  text-decoration: none;
  display: flex;
  color: #f5f5f5;
  font-family: "Montserrat", sans-serif;
  font-size: 14px;
}
#remember:checked::after {
  content: "";
  display: block;
  width: 6px;
  height: 12px;
  border: solid white;
  border-width: 0 2px 2px 0;
  transform: rotate(45deg);
  margin-left: 4px;
}
</style>
