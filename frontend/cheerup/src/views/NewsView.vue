<template>
  <list-item
    :listData="list"
  ></list-item>
</template>

<script>
import ListItem from '../components/ListItem.vue';

export default {
  components: {ListItem},
  data() {
    return {
    }
  },
  computed: {
    list() {
      return this.$store.state.list;
    }
  },
  created() {
    this.$store.dispatch('FETCH_LIST','news');
  },
}
</script>

<style>

</style>