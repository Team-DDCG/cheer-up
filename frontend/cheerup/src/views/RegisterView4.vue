<template>
 
    <div>
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">주소</label>
        <input v-model="address" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Address">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlInput2" class="form-label">이메일</label>
        <input v-model="email" type="email" class="form-control" id="exampleFormControlInput2" placeholder="Email">
      </div>
      <div class="form-check">
        <input v-model="mail_check" class="form-check-input" type="checkbox" value=1 id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          (선택) 채용 공고 및 자동 자기소개서 생성 후 전송을 위한 이메일 수신에 동의하시겠습니까?
        </label>
      </div>
      <button @click.prevent="makeAccout" type="submit" class="btn btn-primary">-></button>
    </div>
  </template>
  
  <script>
  import axios from "axios";

  export default {
    data() {
      return {
        address: '',
        email: '',
        mail_check: 0,
      };
    },
    methods: {
      async makeAccout() {
        // const userData = {
        //     address: this.address,
        //     email: this.email,
        //     mail_check: this.mail_check,
        // }

        axios
        .post("http://127.0.0.1:8888/user/register", {
          type: this.sessionDataType,
          userName: this.sessionDataName,
          id: this.sessionDataId,
          password: this.sessionDataPassword,
          birthdate: this.sessionDataBirth,
          sex: this.sessionDataSex,
          phone: this.sessionDataPhone,
          userStatus: 1,
          mailCheck: this.mail_check,
          address: this.address,
          email: this.email,
        })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
    

        this.$router.push({
            path:'/',
        });
    },
    },
    created() {
      this.sessionDataType = sessionStorage.getItem('type');
      this.sessionDataName = sessionStorage.getItem('name');
      this.sessionDataId = sessionStorage.getItem('id');
      this.sessionDataPassword = sessionStorage.getItem('password');
      this.sessionDataBirth = sessionStorage.getItem('birth');
      this.sessionDataSex = sessionStorage.getItem('sex');
      this.sessionDataPhone = sessionStorage.getItem('phone');
    }
  }
  </script>
  
  <style scoped>

  </style>