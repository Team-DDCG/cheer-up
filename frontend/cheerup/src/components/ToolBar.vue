<template>
  <header>
    <div>
      <router-link to="/main">
      <img src="../assets/main_logo.png"/>
      <!-- <span class ="name1">취얼</span>
      <span class ="name2">업</span> -->
      </router-link>

      <router-link to="/resume" class="nav-link">채용공고</router-link>
      <router-link to="/resumelist" class="nav-link">자기소개서</router-link>
      <router-link to="/portfolio" class="nav-link">포트폴리오</router-link>

      
    </div>
    <div v-if="!isLoggedIn">
      <router-link to="/login">로그인</router-link>
    </div>
    <div v-else >
      <router-link to="/mycv"><b>나의 이력</b></router-link>
      <div @click="logout"><img class="profile" src="../assets/my_profile.png"></div>
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
      sessionStorage.clear();
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;700&display=swap');
b{
  font-family: "Montserrat", sans-serif;
  font-size: 13px;
}
img{
  vertical-align:0% ;
  width: 100px;
  margin-left: -20px;
}
.profile{
  width: 40px;
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
  pointer-events: none; /* hover기능 안받으면서 클릭도 되지않음 */
}

header .nav-link:hover {
  color: rgb(187, 187, 187); /* hover 시 색상 변경 */
}
</style>