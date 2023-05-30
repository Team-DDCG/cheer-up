<template>
    <div id="nav" class="navigator_cv">
        <div id="sidenav_cv1" class="sidenav_cv">
            <router-link to="/mycv">개인정보</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv2" class="sidenav_cv">
            <router-link to="/mycvseeker">취준생</router-link>
        </div>
        <div v-if="mentorId!==null" id="sidenav_cv3" class="sidenav_cv">
            <router-link to="/mycvmentor">멘토</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv4" class="sidenav_cv">
            <router-link to="/mycv1">학력정보</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv5" class="sidenav_cv">
            <router-link to="/mycv2">경력사항</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv6" class="sidenav_cv">
            <router-link to="/mycv3">프로젝트 경험</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv7" class="sidenav_cv">
            <router-link to="/mycv4">대외 활동</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv8" class="sidenav_cv">
            <router-link to="/mycv5">해외 경험</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv9" class="sidenav_cv">
            <router-link to="/mycv6">어학 점수</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv10" class="sidenav_cv">
            <router-link to="/mycv7">스킬</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv11" class="sidenav_cv">
            <router-link to="/mycv8">자격증</router-link>
        </div>
        <div v-if="seekerId!==null" id="sidenav_cv12" class="sidenav_cv">
            <router-link to="/mycv9">수상 경력</router-link>
        </div>
    </div>
</template>
<script>
// import axios from "axios";
export default {
    data() {
    return {
      seekerId: sessionStorage.getItem("seekerId"),
      mentorId: sessionStorage.getItem("mentorId"),
    };
  },
  beforeCreate() {

    },
  created() {

  }

}
</script>
<style scoped>


/* .sidenav_cv {
        height: 50px;
        width: 163px;
        position: relative;
        top: 100px;
        left: 50%;
        margin: 10px;
        background-color: #CCCCCC;
        padding: 13px 8px 8px 32px;
        font-size: 17px;
        color: #818181;
        display: block;
        font-weight: lighter;
    } */
/* 
a{
 font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
  text-decoration: none;
  display: flex;
  align-items: center;
  font-weight: lighter;
  width: 100%;
  padding: 5px 10px 5px 10px;
  cursor: pointer;
  width: 30%;
  height: 50%;
  margin-left: 2%;
  margin-right: 2%;
} */

/* 
a:hover{
  font-family: 'Montserrat', sans-serif; font-size:15px;
  color: white;
  background-color: #A46CFF;
  font-weight: bold;
  text-decoration: none;
  display: flex;
  align-items: center;
  width: 100%;
  padding: 5px 10px 5px 10px;
} 
*/


a{
  font-family: 'Montserrat', sans-serif; font-size:13px;
  color: white;
  display: flex;
  align-items: center;
  width: 100%;
  padding: 10px;
  cursor: pointer;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  margin-left: 50px;
  text-decoration: none;
  background-color: #808080;
  margin-bottom: 10px;
}
a:hover{
  font-family: 'Montserrat', sans-serif; font-size:13px;
  color: white;
  background-color: #666666;
  font-weight: bold;
  display: flex;
  align-items: center;
  width: 100%;
  padding: 10px;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  margin-left: 50px;
}
a.router-link-active {
  font-family: 'Montserrat', sans-serif; font-size:13px;
  color: white;
  background-color: #A46CFF;
  font-weight: bold;
  display: flex;
  align-items: center;
  width: 100%;
  padding: 10px;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  margin-left: 50px;
  pointer-events: none; /* hover기능 안받으면서 클릭도 되지않음 */
}
#nav{
    margin-top: 100px;
    margin-bottom: 100px;
}
</style>