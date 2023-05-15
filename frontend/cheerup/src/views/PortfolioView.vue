<template>
  <tool-bar></tool-bar>
  <list-item
    :listData="list"
  ></list-item>
</template>

<script>
import ListItem from '../components/ListItem.vue';
import ToolBar from '../components/ToolBar.vue'

export default {
  components: {ListItem, ToolBar},
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
    this.$store.dispatch('FETCH_LIST','jobs');
  },
}
</script>

<style>

</style>