<template>
  <ul class="list">
    <p><b>금일 추천 공고 리스트</b></p>
    <li v-for="item of listData" :key="item" >
      <template v-if="$route.name === 'resume'">
        <!-- <span> by <router-link :to="`/user/${item.user}`">{{ item.user }}</router-link></span><br/> -->
        <!-- <a :href=item.url target="_blank">{{ item.title }}</a> -->
        <router-link :to="`/resume/?id=${item.companyId}`">{{item.companyName}}</router-link>
        <!-- <a @click="show">{{item.companyName}}</a> -->
      </template>
    </li>
  </ul>
</template>

<script>
export default {
  props: ['listData',],
  methods: {
    show() {
      this.$router.push({
              path:'?id=0',
      });
    }
  }
}
</script>

<style scoped>
li {
  list-style: none;
}
p {
  color: white;
}
b {
  border-bottom:2px solid white;
}
.list {
  width: 19%;
  padding:20px;
  border: 1px solid #808080;
  border-radius: 5px;
  background-color: #515151;
}
div {
  width: 50px;
  background-color: #515151;
}
a{
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
  text-decoration: none;
  display: flex;
  align-items: center;
  /* width: 100%; */
  padding: 5px 10px 5px 10px;
}
a:hover{
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
  background-color: #A46CFF;
  font-weight: bold;
  text-decoration: none;
  display: flex;
  align-items: center;
  /* width: 100%; */
  padding: 5px 10px 5px 10px;
}
.router-link-active{
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
  background-color: #A46CFF;
  font-weight: bold;
  text-decoration: none;
  display: flex;
  align-items: center;
  /* width: 100%; */
  padding: 5px 10px 5px 10px;
}
</style>