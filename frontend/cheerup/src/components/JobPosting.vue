<template>
    <div id="post">
      <p>{{ company.post_name }}</p>
      <div >
        <img :src="company.logo_url" id="logo">
        <div>
          <p>{{ company.company_name }}</p>
          <p>시작일: {{ company.start_date }} | 마감일 : {{ company.end_date }}</p>
        </div>
        <a target="_blank" :href="company.site">채용 사이트 이동</a>
      </div>
      <img :src="company.posting_url" id="job">
    </div>
</template>
  
  <script>
  export default {
    data() {
      return {

      }
  },
    props: ['company'],
  }
  </script>
  
  <style>
  div {
    background-color: #363533;
  }
  #post div {
    display: flex;
    justify-content: center;
  }

  #post div div {
    display: block;
  }
  #logo {
    width: 173.62px;
    height: 37px;
  }
  p {
    margin: 0;
    color: white;
    font-family: 'Roboto', sans-serif; font-size:15px;
  }
  </style>