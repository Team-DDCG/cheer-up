<template>
    <div id="post" v-if="company !== null">
      <p><b>{{ company.post_name }}</b></p>
      <div >
        <div id="image-container">
          <img :src="company.logo_url" id="logo">
        </div>
        <div id="info">
          <p>회사명: {{ company.company_name }}</p>
          <p>시작일: {{ company.start_date }} | 마감일 : {{ company.end_date }}</p>
        </div>
        <a id="site" target="_blank" :href="company.site"><b>채용 사이트 이동</b></a>
      </div>
      <list-field :listData="company.field"></list-field>
      <div id="image-container2">
        <img :src="company.posting_url" id="job">
      </div>
      
    </div>
    <div id="post" v-else></div>
  </template >

  <script>
import ListField from './ListField.vue';

  export default {
    components: {ListField},
    data() {
      return {

      }
  },
    props: ['company'],
  }
  </script>
  
<style scoped>
div {
  background-color: #363533;
}
#post {
  width: 80%;
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