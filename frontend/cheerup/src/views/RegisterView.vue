<template>
     <div id="innerBox">
      <input type="radio" v-model="radioValues" class="btn-check" name="options" id="option" autocomplete="off" value=0>
      <label class="btn btn-secondary" for="option">취준생</label>
      <input type="radio" v-model="radioValues" class="btn-check" name="options" id="option2" autocomplete="off" value=1>
      <label class="btn btn-secondary" for="option2">멘토</label>
    <button @click.prevent="submitForm" type="submit" class="btn btn-primary">선택</button>
   
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        radioValues: '',
      };
    },
    methods: {
      async submitForm() {
        
          const userData = {
              type: this.radioValues,
          }
          sessionStorage.setItem('type', userData.type);

          this.$router.push({
              path:'/register2',
          });
      },
    },
  }
  </script>
  
  <style scoped>
#innerBox {
  background-color: #515151;
  padding: 50px;
  border-radius: 10px;
  margin: 100px;
  border: 1px solid #808080;
}
  </style>