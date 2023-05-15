<template>
  <tool-bar></tool-bar>
  <side-bar></side-bar>

</template>

<script>

import SideBar from '../components/SideBar.vue';
import ToolBar from '../components/ToolBar.vue'

export default {
  components: {SideBar, ToolBar},
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