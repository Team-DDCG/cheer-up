<template>
  <ul class="list">
    <p>금일 추천 공고 리스트</p>
    <li v-for="item of listData" :key="item.id" >
      <b>{{item.time_ago}}</b>
      <template v-if="$route.name === 'resume'">
        <!-- <span> by <router-link :to="`/user/${item.user}`">{{ item.user }}</router-link></span><br/> -->
        <!-- <a :href=item.url target="_blank">{{ item.title }}</a> -->
        <router-link :to="`/item/?id=${item.id}`">({{ item.comments_count }})</router-link>
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