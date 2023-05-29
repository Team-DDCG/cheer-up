<template>
  <ul class="list">
    <li v-for="(item, index) of listData" :key="index" class="li" >
      <p>{{item}}</p>
      <!-- <router-link :to="`/item/?id=${item}`"><div><b>자기소개서 AI작성</b></div></router-link> -->
      <!-- <router-link :to="`/airesume`"><div><b>자기소개서 AI작성</b></div></router-link> -->
      <a @click="printMessage(index)"><div><b>자기소개서 AI작성</b></div></a>
    </li>
  </ul>
</template>

<script>
export default {

  props: ['listData','company'],
  methods: {
    printMessage(index) {
      // console.log(this.listData[index]);
      // console.log(this.company.companyId);

      const myValue = sessionStorage.getItem('seekerId'); // 세션 스토리지에서 가져올 특정 키 값
      
      if (myValue !== null) {
        // 특정 값이 존재하는 경우
        console.log('세션 값이 존재합니다:', myValue);
        this.$router.push({ 
        path: "/airesume", 
        query: { 
          field: this.listData[index],
          companyName: this.company.companyName,
          companyId: this.company.companyId,
        } 
      });
      } else {
        // 특정 값이 존재하지 않는 경우
        alert('세션 값이 존재하지 않습니다.');
        console.log('세션 값이 존재하지 않습니다.');
      }

      
    }
  }
}
</script>

<style scoped>
ul {
  padding: 0;
}
.list {
  width: 100%;
  margin-top: 10px;
}
.li {
  border: 1px solid white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 59.29px;
}
.li p{
  padding-left: 70px;
  margin-bottom: 0;
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
}
.list li + li {margin-top:5px}
div {
  text-align: center;
  width: 170px;
  height: 59px;
  margin: 0 auto;
  border: 1px solid #363533;
  border-radius: 5px;
  line-height: 59px;
  background-color: #A46CFF; 
  color: white;
  font-family: 'Montserrat', sans-serif; font-size:15px;
  text-decoration: none;
}
a{
  text-decoration: none;
}
</style>