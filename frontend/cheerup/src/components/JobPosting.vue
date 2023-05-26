<template>
    <div id="post">
      <p><b>{{ company.title }}</b></p>
      <div >
        <div id="image-container">
          <img :src="company.companyLogo" id="logo">
        </div>
        <div id="info">
          <p>회사명: {{ company.companyName }}</p>
          <p>시작일: {{ company.startDate }} | 마감일 : {{ company.endDate }}</p>
        </div>
        <a id="site" target="_blank" :href="company.companyUrl"><b>채용 사이트 이동</b></a>
      </div>
      <list-field :listData="company.position" :company="company"></list-field>
      <div id="image-container2">
        <img :src="company.content" id="job">
      </div>
      
    </div>
  </template >

  <script>
import ListField from './ListField.vue';

  export default {
    components: {ListField},
    data() {
      return {
        // company: ''
        field: ''
      }
  },
    props: ['company'],
    // emits: ['update:modelValue'],
  }
  </script>
  
<style scoped>
div {
  background-color: #363533;
}
#post {
  width: 80%;
  min-height: 100%;
  padding:20px;
  border: 1px solid #808080;
  border-radius: 5px;
  background-color: #515151;
}
#post div {
  display: flex;
  justify-content: space-between;
  width: 100%;
  background-color: #515151;
}

#post div div {
  display: block;
  width:fit-content;
}

#image-container {
  max-width: 25%;
  display: flex;
  justify-content: center;
  align-items: center;
}

#image-container img {
  width: 100%;
}

#image-container2 {
  max-width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

#image-container2 img {
  width: 100%;
}

p {
  display: flex;
  justify-content: left;
  margin: 0;
  color: white;
  font-family: 'Roboto', sans-serif; font-size:15px;
}
#site{
  text-align: center;
  width: 170px;
  height: 59px;
  border-radius: 5px;
  line-height: 59px;
  background-color: #808080; 
  color: white;
  font-family: 'Montserrat', sans-serif; font-size:15px;
  text-decoration: none;
}

  </style>