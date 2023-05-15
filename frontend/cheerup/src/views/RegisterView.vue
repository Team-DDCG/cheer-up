<template>
     <div id="innerBox">
  
      <input type="radio" v-model="radioValues" class="btn-check" name="options" id="option" autocomplete="off" value="seeker">
      <label class="btn btn-secondary" for="option">취준생</label>
      <input type="radio" v-model="radioValues" class="btn-check" name="options" id="option2" autocomplete="off" value="mentor">
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
              // password: this.password,
          }
          alert(userData.type);
          sessionStorage.setItem('type', userData.type);
          // sessionStorage.setItem('user', userData);
          // const { data } = await loginUser(userData);
          // this.$store.commit('setUsertype', data.user.type);
          this.$router.push({
              path:'/register2',
              // query: {
              //   data: this.radioValues
              // }
          });
          // this.$router.push('/register2',this.radioValues);

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