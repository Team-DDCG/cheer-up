<template>
  <ul class="list">
    <li v-for="item of listData" :key="item.id" >
      <b>{{item.time_ago}}</b>
      <template v-if="$route.name === 'resume'">
        <!-- <span> by <router-link :to="`/user/${item.user}`">{{ item.user }}</router-link></span><br/> -->
        <!-- <a :href=item.url target="_blank">{{ item.title }}</a> -->
        <router-link :to="`/item/?id=${item.id}`"><i>({{ item.comments_count }})</i></router-link>
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
div {
  width: 50px;
  background-color: #515151;
}
</style>