<template>
  <header>
    <div>
      <router-link to="/">
      <img src="../assets/logo.png"/>
      <span class ="name1">취얼</span>
      <span class ="name2">업</span>
      </router-link>
      <router-link to="/resume">채용공고</router-link>
      <router-link to="/">자기소개서</router-link>
      <router-link to="/ask">첨삭게시판</router-link>
      <router-link to="/portfolio">포트폴리오</router-link>
    </div>
    <router-link to="/login">로그인</router-link>
  </header>
</template>

<script>
export default {

}
</script>

<style scoped>
img{
  vertical-align:0% ;
  width: 30px;
}
.name1 {
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
}
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