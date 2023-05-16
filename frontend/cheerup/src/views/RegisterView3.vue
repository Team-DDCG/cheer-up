<template>
    <div>
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">생년월일</label>
        <input v-model="birth" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Birth date">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlInput2" class="form-label">전화번호</label>
        <input v-model="phone" type="text" class="form-control" id="exampleFormControlInput2" placeholder="phone">
      </div>
      성별
      <div class="form-check form-check-inline">
        <input v-model="sex" class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value=0>
        <label class="form-check-label" for="inlineRadio1">남성</label>
      </div>
      <div class="form-check form-check-inline">
        <input v-model="sex" class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value=1>
        <label class="form-check-label" for="inlineRadio2">여성</label>
      </div>
      <button @click.prevent="submitForm" type="submit" class="btn btn-primary">-></button>
    </div>
  </template>
  
  <script>

  export default {
    data() {
      return {
        birth: '',
        phone: '',
        sex: '',
      };
    },
    methods: {
      async submitForm() {
        
        const userData = {
            // type: this.sessionDataType,
            birth: this.birth,
            phone: this.phone,
            sex: this.sex
        }

        // sessionStorage.setItem('type', userData.type);
        sessionStorage.setItem('birth', userData.birth);
        sessionStorage.setItem('phone', userData.phone);
        sessionStorage.setItem('sex', userData.sex);

        this.$router.push({
            path:'/register4',
        });
    },
    },
    created() {
      // this.sessionDataType = sessionStorage.getItem('type');
      // this.sessionDataName = sessionStorage.getItem('name');
      // this.sessionDataId = sessionStorage.getItem('id');
      // this.sessionDataPassword = sessionStorage.getItem('password');
    }
  }
  </script>
  
  <style scoped>

  </style>