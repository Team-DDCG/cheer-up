<template>
  <tool-bar></tool-bar>
  <div id="container">
    
    <!-- <h1>LEE JU HYEONG</h1>
    <p>Bachelor of Science in Computer Engineering</p>
    <br>
    <p>Hello, nice to meet you.<br>This pages reated using Vue.js</p>
    <br>
    <h3><a href="https://github.com/yjh0816" target="_blank">Github link</a></h3> -->
    <article class="container-fluid">
      <div class="row">
        <div>
          <router-link to="/resume">채용공고</router-link>
        </div>
        <div>
          <router-link to="/resume">이력서 및 자기소개서 작성</router-link>
        </div>
        <div>
          <router-link to="/ask">자기소개서 코칭</router-link>
        </div>
        <div>
          <router-link to="/">취업 프로그램</router-link>
        </div>
      </div>
    </article>
  </div>
 
</template>

<script>
import ToolBar from '../components/ToolBar.vue'

export default {
  components: {ToolBar},
  name: 'HomeView',
}
</script>
<style scoped>
div {background-color: #363533;}
</style>
