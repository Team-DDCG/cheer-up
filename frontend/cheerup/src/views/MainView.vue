<template>
<div>
  <header>
    <div>

    </div>
    <div v-if="!isLoggedIn">
      <router-link to="/login">로그인</router-link>
    </div>
    <div v-else >
      <router-link to="/mycv"><b>나의 이력</b></router-link>
      <div @click="logout"><img class="profile" src="../assets/my_profile.png"></div>
    </div>
  </header>
  <div class="container">
    <router-link to="/main">
      <img src="../assets/main_tem.png" style="width : 60%;" />
    </router-link>
    <!-- <p class="title2">당신의 취업을 한번에</p> -->
    <div class="boxes-container">
      <div class="box" id="10">
        <router-link to="/resume">
          <img src="../assets/company.png" class="image2" />
          <div class="content">
            <p class="title">채용 공고</p>
            <p class="description">
              <span>사용자가 설정한 필터링에 따라</span><br/>
              <span>당일 공고를 추천합니다.</span>
            </p>
          </div>
        </router-link>
      </div>
      <div class="box" id="20">
        <router-link to="/resumelist">
          <img src="../assets/resume.png" class="image2" />
          <div class="content">
            <p class="title">자기소개서 작성</p>
            <p class="description">
              <span>지원하려는 회사에 맞춰</span><br/>
              <span>자기소개서를 AI가 작성합니다.</span>
            </p>
          </div>
        </router-link>
      </div>
      <div class="box" id="30">
        <router-link to="/ask">
          <img src="../assets/correct.png" class="image2" />
          <div class="content">
            <p class="title">자기소개서 코칭</p>
            <p class="description">
              <span>작성된 자기소개서를 공유하고</span><br/>
              <span>현직자에게 피드백을 받습니다.</span>
            </p>
          </div>
        </router-link>
      </div>
      <div class="box" id="40">
        <router-link to="/job">
          <img src="../assets/program.png" class="image2" /> 
          <div class="content" >
             <p class="title">취업 프로그램</p>
            <p class="description">
              <span>정부에서 지원하는</span><br/>
              <span>취업 지원 프로그램을 추천합니다.</span>
            </p>
          </div>
        </router-link>
      </div>
    </div>
  </div>
  <div class="container2">
    <div class="content2">
      <p class="title2">가이드 영상 안내</p>
      <div class="video2"></div>
    </div>
  </div>
    <div class="box2">
        <button
          @click.prevent="submitForm"
          type="submit"
          class="btn btn-primary"
        >
          취얼업과 시작해보기
        </button>
  </div>
   
   <footer-bar/>
</div>

</template>

<script>
import FooterBar from '../components/FooterBar.vue';
 export default {
    components: {FooterBar},
    data() {
      return {

      }
    },
    computed: {
      isLoggedIn() {
        // 로컬 스토리지에서 세션 상태를 확인
        return localStorage.getItem('isLoggedIn') === 'true';
      }
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
b{
  font-family: "Montserrat", sans-serif;
  font-size: 13px;
}
img {
  vertical-align: 0%;
  width: 40px;
}
.profile{
  width: 40px;
}
.name1,
.name2 {
  font-weight: 700;
  font-family: "Montserrat", sans-serif;
  font-size: 30px;
  text-align: center;
  color: #f5f5f5;
}

.name2 {
  color: #a46cff;
}

header {
  position: relative;
  padding: 10px 5px;
  background: #363533;
  font-size: 15px;
  display: flex;
  justify-content: space-between;
  width: 100%;
  height: 58px;
}

header div {
  display: flex;
  align-items: center;
}

header a {
  color: white;
  text-decoration: none;
  display: flex;
  align-items: center;
  margin-right: 10px;
}

header div a {
  color: white;
  text-decoration: none;
  padding-bottom: 3px;
  margin: 40px;
}

header div a + a {
  margin-left: 20px;
}

header .router-link-active {
  color: #a46cff;
  font-weight: bold;
}

.container {
  width: 1160px;
  overflow-x: auto;
}

.container > .title2 {
  color: #f5f5f5;
}

.boxes-container {
  display: flex;
  flex-wrap: nowrap;
  gap: 10px;
  padding: 10px;
}

.box {
  width: 268.06px;
  height: 400px;
  border-radius: 16px;
  background: #f5f5f5;
  display: flex;
  margin: 0 auto;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.image2 {
  width: 268.06px;
  height: 282px;
  border-top-left-radius: 16px;
  border-top-right-radius: 16px;
  object-fit: cover;
}

.content {
  margin-top: 20px;
  text-align: center;
}
.box2 {
  width: 268.06px;
  height: 400px;
  border-radius: 16px;
  background: #f5f5f5;
  display: flex;
  margin: 0 auto;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: #363533;
}
.title {
  text-align: left;
  padding-left: 10px;
  font-size: 18px;
  font-weight: 700;
  color: rgba(0, 0, 0, 0.72);
}

.description {
  text-align: left;
  padding-left: 12px;
  margin-top: 10px;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.4);
}

.container2 {
  width: 100%;
  overflow-x: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
}

.content2 {
  text-align: center;
  color: #f5f5f5;
  max-width: 1164px;
  margin: 0 auto;
}

.title2 {
  width: 235.25px;
  height: 33.27px;
  font-size: 23px;
}

.video2 {
  width: 1116px;
  height: 691px;
  border-radius: 16px;
  background-image: url("https://picsum.photos/200");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}

a {
  text-decoration: none;
}

.box2 {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
}

.box2 > .btn.btn-primary {
  margin: 0 auto;

  width: 300px;
  height: 67px;
  background: #a46cff;
  border-width: 1;
  border-color: #363533;
  border-radius: 15px;
  text-align: center;
  color: #f5f5f5;
  font-size: 15px;
  font-weight: 700;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.3);
}


</style>