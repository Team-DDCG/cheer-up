<template>
  <ul class="list">
    <p><b>금일 추천 공고 리스트</b></p>
    <li v-for="item of listData" :key="item" >
      <template v-if="$route.name === 'resume'">
        <!-- <span> by <router-link :to="`/user/${item.user}`">{{ item.user }}</router-link></span><br/> -->
        <!-- <a :href=item.url target="_blank">{{ item.title }}</a> -->
        <router-link :to="`/item/?id=${item.companyName}`">{{item.companyName}}</router-link>
      </template>
    </li>
  </ul>
</template>

<script>
export default {
  props: ['listData',]
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
</style>