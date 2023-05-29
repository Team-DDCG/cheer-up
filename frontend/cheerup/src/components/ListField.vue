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
import axios from "axios";
export default {
  data() {
    return {
      seekerInfo: [],
      total: 0,
    }
  },
  props: ['listData','company'],
  methods: {
    updateTotal(res) {
      this.total = this.total + res.data;
    },
    async printMessage(index) {
      // console.log(this.listData[index]);
      // console.log(this.company.companyId);

      const myValue = sessionStorage.getItem('seekerId'); // 세션 스토리지에서 가져올 특정 키 값
      
      if (myValue !== null) {
        // 특정 값이 존재하는 경우
        console.log('세션 값이 존재합니다:', myValue);


        
        //activation
        await axios
        .get(this.$store.state.baseUrl+"api/activation/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['activation',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
        //careers
        await axios
        .get(this.$store.state.baseUrl+"api/careers/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['careers',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //languages
        await axios
        .get(this.$store.state.baseUrl+"api/languages/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['languages',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //licenses
        await axios
        .get(this.$store.state.baseUrl+"api/licenses/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['licenses',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //overseas
        await axios
        .get(this.$store.state.baseUrl+"api/overseas/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['overseas',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //projects
        await axios
        .get(this.$store.state.baseUrl+"api/projects/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['projects',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //reward
        await axios
        .get(this.$store.state.baseUrl+"api/rewards/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['reward',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
         //skills
        await axios
        .get(this.$store.state.baseUrl+"api/skills/number/"+myValue, {
        })
        .then((res) => {
          this.seekerInfo.push(['skills',res.data]);
          this.updateTotal(res);
        })
        .catch((err) => {
          console.log(err);
          this.check = 'error';
        });
        console.log(this.seekerInfo);
        console.log(this.total);

        if(this.total >= 3) {
          this.$router.push({ 
          path: "/airesume", 
          query: { 
            field: this.listData[index],
            companyName: this.company.companyName,
            companyId: this.company.companyId,
          } 
        });
        } else {
          alert("자기소개서를 작성하기 위한 정보가 부족해요!");
        }


        
      } else {
        // 특정 값이 존재하지 않는 경우
        alert('로그인을 해주시거나 취업준비생이 아니에요');
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