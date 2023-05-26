<template>
  <header>
    <div>
      <router-link to="/main">
      <img src="../assets/Logo_kor.png"/>
      <!-- <span class ="name1">취얼</span>
      <span class ="name2">업</span> -->
      </router-link>
      <router-link to="/resume">채용공고</router-link>
      <router-link to="/">자기소개서</router-link>
      <router-link to="/ask">첨삭게시판</router-link>
      <router-link to="/portfolio">포트폴리오</router-link>
    </div>
    <div v-if="!isLoggedIn">
      <router-link to="/login">로그인</router-link>
    </div>
    <div v-else >
      <router-link to="/mycv">나의 이력</router-link>
      <div style="background-color: #a46cff;color: white;border: 1px solid #a46cff; border-radius: 100%;" @click="logout">Logout</div>
    </div>
  
  </header>
</template>

<script>
export default {
  data() {
      return {
        user: ''
      }
  },
  computed: {
    isLoggedIn() {
      // 로컬 스토리지에서 세션 상태를 확인
      return localStorage.getItem('isLoggedIn') === 'true';
    }
  },
  created() {
    // this.user = sessionStorage.getItem("vo");
  },
  watch:{

  },
  methods: {
    logout() {
      // 세션 상태를 초기화하고 로그인 페이지로 이동
      localStorage.removeItem('isLoggedIn');
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;700&display=swap');

img{
  vertical-align:0% ;
  width: 100px;
  margin-left: -20px;
}
/* .name1 {
  font-weight: 700;
  font-family: 'Montserrat', sans-serif; font-size:30px;
  text-align: center;
  color: #f5f5f5;
}

.name2 {
  font-weight: 700;
  font-family: 'Montserrat', sans-serif; font-size:30px;
  font-Weight: 700px;
  text-Align: center;
  color: #a46cff;
} */
header {
  position: relative;
  padding:10px 5px;
  background:#363533;
  font-size:15px;
  display: flex;
  justify-content: space-between;
  width: 100%;
  border-bottom:1px solid #808080;
  height: 58px;
}
header div {
  display: flex;
  align-items: center;
}
header a {
  color:white; 
  text-decoration: none;
  display: flex;
  align-items: center;
  margin-right: 10px;
}
header div a {color:white; text-decoration: none; padding-bottom:3px; margin: 40px; }
header div a + a {margin-left:20px}
header .router-link-active {
  color: #A46CFF;
  font-weight: bold;
}
</style>