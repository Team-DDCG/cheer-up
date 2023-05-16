<template>
     <!-- <div id="container">
    
      <h1>LEE JU HYEONG</h1>
      <p>Bachelor of Science in Computer Engineering</p>
      <br>
      <p>Hello, nice to meet you.<br>This pages reated using Vue.js</p>
      <br>
      <h3><a href="https://github.com/yjh0816" target="_blank">Github link</a></h3>
    </div> -->
    <div>{{ sessionDataType }}</div>
    <div>{{ sessionDataName }}</div>
    <div>{{ sessionDataId }}</div>
    <div>{{ sessionDataPassword }}</div>
    <div>
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">생년월일</label>
        <input v-model="birth" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Birth date">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlInput2" class="form-label">전화번호</label>
        <input v-model="phone" type="text" class="form-control" id="exampleFormControlInput2" placeholder="phone">
      </div>
      
      <button @click.prevent="makeAccout" type="submit" class="btn btn-primary">-></button>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  export default {
    data() {
      return {
        sessionDataType: '',
        sessionDataName: '',
        sessionDataId: '',
        sessionDataPassword: '',
        birth: '',
        phone: '',
      };
    },
    methods: {
      async makeAccout() {
        
        const userData = {
            type: this.sessionDataType,
            birth: this.birth,
            phone: this.phone,
        }
        alert(userData.birth);
        alert(userData.phone);

        axios
        .post("http://127.0.0.1:8888/user/register", {
          type: 1,
          userName: this.sessionDataName,
          id: this.sessionDataId,
          password: this.sessionDataPassword,
          birthdate: this.birth,
          sex: 1,
          phone: this.phone,
          userStatus: 1,
          mailCheck: 1,
          address: 'test',
          email: 'email@email.com'
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
    

        // this.$router.push({
        //     path:'/home',
        // });
    },
    },
    created() {
      this.sessionDataType = sessionStorage.getItem('type');
      this.sessionDataName = sessionStorage.getItem('name');
      this.sessionDataId = sessionStorage.getItem('id');
      this.sessionDataPassword = sessionStorage.getItem('password');
    }
  }
  </script>
  
  <style scoped>

  </style>