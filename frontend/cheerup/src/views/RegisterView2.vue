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
        <label for="exampleFormControlInput1" class="form-label">이름</label>
        <input v-model="name" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Name">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlInput2" class="form-label">아이디</label>
        <input v-model="id" type="text" class="form-control" id="exampleFormControlInput2" placeholder="ID">
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">비밀번호</label>
        <input v-model="password" type="password" id="inputPassword" class="form-control" placeholder="Password" aria-labelledby="passwordHelpBlock">
        <div id="passwordHelpBlock" class="form-text">
          Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
        </div>
      </div>
      <div class="mb-3">
        <label for="inputPassword2" class="form-label">비밀번호 확인</label>
        <input type="password" id="inputPassword2" class="form-control" placeholder="Password">
      </div>
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary">-></button>
    </div>
  </template>
  
  <script>

  export default {
    data() {
      return {
        sessionData: '',
        name: '',
        id: '',
        password: ''
      };
    },
    methods: {
      async submitForm() {
        
        const userData = {
            type: this.sessionData,
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
      // this.sessionData = sessionStorage.getItem('user');
    }
  }
  </script>
  
  <style scoped>

  </style>