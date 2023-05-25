<!-- MY PAGE_My info -->
<template>
    <tool-bar/>
     <section id="main">
          <side-bar-cv/>
          <div id = "cv_content">
            <header>
                <label for="" class="title">나의 이력</label>
            </header>
            <div class="imginput" id="imgNline">
                <div class="imginput" id="imgNline_img">
                    <input id="img" type="file" @change="readInputFile"/>
                </div>
            <div class="info-set" id="imgNline_line">
                <div class="info-set" id="line1">
                    <div class="formbox">
                        <label for="" class="form-label">이름</label>
                        <input
                        v-model="name"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="이름"
                        />
                    </div>

                    <div class="formbox">
                        <label for="" class="form-label">영문이름</label>
                        <input
                        v-model="Ename"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Name"
                        />
                    </div>

                    <div class="formbox">
                        <label for="" class="form-label">한문이름</label>
                        <input
                        v-model="Cname"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="漢字"
                        />
                    </div>
                </div>
                </div>
                <div class="info-set" id="line2">
                    <div class="formbox">
                        <label for="" class="form-label">생년월일</label>
                        <input
                        v-model="birth"
                        type="date"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Birth date"
                        />
                    </div>

                    <div class="form-check-label">
                        <label for="exampleFormControlInput2" class="form-label">성별</label
                        ><br/>
                        <div class="form-check form-check-inline">
                            <input
                            v-model="sex"
                            class="form-check-input"
                            type="radio"
                            name="inlineRadioOptions"
                            id="inlineRadio1"
                            value="0"
                            />
                            <label class="form-check-label" for="inlineRadio1">남성</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input
                            v-model="sex"
                            class="form-check-input"
                            type="radio"
                            name="inlineRadioOptions"
                            id="inlineRadio2"
                            value="1"
                            />
                            <label class="form-check-label" for="inlineRadio2">여성</label>
                        </div>
                    </div>
                </div>
                </div>
                <div class="info-set" id="line3">
                    <div class="formbox">
                        <label for="" class="form-label">국가</label>
                        <input
                        v-model="nation"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="nation"
                        />
                    </div>


                    <div class="formbox">
                        <label for="" class="form-label">전화번호</label>
                        <input
                        v-model="phone"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="010-0000-0000"
                        />
                    </div>

                    <div class="formbox">
                        <label for="" class="form-label">이메일</label>
                        <input
                        v-model="email"
                        type="text"
                        class="form-control"
                        id="exampleFormControlInput1"
                        placeholder="Email"
                        />
                    </div>
                </div>
                
                <div class="formbox2" id="line4">
                    <label for="" class="form-label">주소</label>
                    <input
                    v-model="address"
                    type="text"
                    class="form-control"
                    id="exampleFormControlInput1"
                    placeholder="Address"
                    />
                </div>
                
                <div class="btn" id="line5">
                <input type="button" class="save-button" onclick="alert('클릭!')">
                </div>
          </div>
     </section>  
     <footer-bar/>

</template>
<script>
     import ToolBar from '../components/ToolBar.vue';
     import FooterBar from '../components/FooterBar.vue';
     import SideBarCv from '../components/SideBarCv.vue';
     export default{
     components: { ToolBar, FooterBar, SideBarCv},
     data() {
          return {

        }
    }
}
</script>
<style scoped>

    /* 전체 폼 와꾸 정리 */

     #main {
        display: grid;
        grid-auto-flow: column;
        grid-template-columns: 0.8fr 3fr 0.5fr;
    }

    #cv_content{
        display: grid;
        row-gap: 10px;
        column-gap: 20px;
        background-color: #515151;
        padding: 4%;
        margin-bottom: 5%;
        margin-top: 5%;
        border-radius: 5px;
    }

    .title{
          color: #f5f5f5;
          font-size: 14px;
          font-weight: bolder;
          text-align: left;
          width: 1080px;
          top: 10px;
          border-bottom:1px solid #808080;
     }
     
    /* 이미지와 라인 정리 */
    #imgNline_img{
        grid-row: span 2;
    }


    #imgNline{
        display: grid;
        grid-template-columns: 200px 1fr;
        gap: 10px 20px;
    }


    /* 라인 정리 */
    #line1{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        gap: 10px 20px;
    }

    #line2{
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 10px 20px;
    }

    
    #line3{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        gap: 10px 20px;
    }


    /* 폼 정리 */
    .form-control{
        font-size: 14px;
       background-color: #808080; 
       border-color: #808080;
    }

    .form-label{
        font-size: 14px;
        color: #F5F5F5
        
    }

    /* 저장 버튼 */
    /* input.save-button{
        background-image: url(../assets/등록\ 버튼.png);
        width: 100px;
    } */
   
</style>