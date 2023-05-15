<template>
     <!-- <div id="container">
    
      <h1>LEE JU HYEONG</h1>
      <p>Bachelor of Science in Computer Engineering</p>
      <br>
      <p>Hello, nice to meet you.<br>This pages reated using Vue.js</p>
      <br>
      <h3><a href="https://github.com/yjh0816" target="_blank">Github link</a></h3>
    </div> -->
    <div>{{ sessionData }}</div>
    <div>
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">생년월일</label>
        <input v-model="birth" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Birth date">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlInput2" class="form-label">전화번호</label>
        <input v-model="phone" type="text" class="form-control" id="exampleFormControlInput2" placeholder="phone">
      </div>
      
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary">-></button>
    </div>
  </template>
  
  <script>

  export default {
    data() {
      return {
        sessionData: '',
        birth: '',
        phone: '',
      };
    },
    methods: {
      async submitForm() {
        
        const userData = {
            type: this.sessionData.type,
            name: this.name,
            id: this.id,
            password: this.password,
        }
        alert(userData.type);
        alert(userData.name);
        sessionStorage.setItem('user', userData);

        this.$router.push({
            path:'/register3',
        });
    },
    },
    created() {
      this.sessionData = sessionStorage.getItem('type');
    }
  }
  </script>
  
  <style scoped>

  </style>