<template>
  <header>
    <router-link to="/">취얼업</router-link>
    <router-link to="/">홈</router-link>
    <router-link to="/resume">자기소개서</router-link>
    <router-link to="/portfolio">포트폴리오</router-link>
    <router-link to="/ask">자기소개서 코칭</router-link>
    <router-link to="/login">로그인</router-link>
  </header>
</template>

<script>
export default {

}
</script>

<style scoped>
header {
  position: relative;
  padding:20px 30px;
  background:#515151;
  font-size:13px;
  border-bottom:1px solid #808080;
}
header h1 {position: absolute; color:white; top:21px; right:30px; font-size:18px;}
header a {color:white; text-decoration: none; padding-bottom:3px; margin: 40px;}
header a + a {margin-left:20px}
header .router-link-active {
  border-bottom:3px solid white;
}
</style>