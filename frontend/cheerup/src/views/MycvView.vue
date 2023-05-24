<!-- 나의 이력 페이지_개인정보-->
<template>
    <meta charset="UTF-8">
    <!-- navigation_ left -->
    <tool-bar/>
    <div id="main">
        <div id="nav" class="navigator_cv">
        <div id="sidenav_cv1" class="sidenav_cv">
            <a href="#">개인정보</a>
        </div>
        <div id="sidenav_cv2" class="sidenav_cv">
            <a href="#">학력정보</a>
        </div>
        <div id="sidenav_cv3" class="sidenav_cv">
            <a href="#">경력사항</a>
        </div>
        <div id="sidenav_cv4" class="sidenav_cv">
            <a href="#">프로젝트 경험</a>
        </div>
        <div id="sidenav_cv5" class="sidenav_cv">
            <a href="#">대외 활동</a>
        </div>
        <div id="sidenav_cv6" class="sidenav_cv">
            <a href="#">해외 경험</a>
        </div>
        <div id="sidenav_cv7" class="sidenav_cv">
            <a href="#">어학 점수</a>
        </div>
        <div id="sidenav_cv8" class="sidenav_cv">
            <a href="#">스킬</a>
        </div>
        <div id="sidenav_cv9" class="sidenav_cv">
            <a href="#">자격증</a>
        </div>
        <div id="sidenav_cv10" class="sidenav_cv">
            <a href="#">수상 경력</a>
        </div>
    </div>
    

    <section>
    <div class ="content-box">
        <article>
            <label for="" class="main">나의 이력</label>
            <div class="myimage">
                <input id="myimage" type="file" @change="readInputFile"/>
                    </div>
                        <br>
                    <div id="imagePreview">
                <img id="img" />
             </div>

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
                ><br />
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

            <div class="formbox2">
                <label for="" class="form-label">주소</label>
                <input
                v-model="address"
                type="text"
                class="form-control"
                id="exampleFormControlInput1"
                placeholder="Address"
                />
            </div>

    </article>
    </div>
    </section>
    </div>
    
</template>

<script>
import ToolBar from '../components/ToolBar.vue';

export default{
    components: {ToolBar, },
    data() {
        return {

        }
    }
}
</script>

<style scoped>
#main {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
}
    .sidenav_cv {
        height: 50px;
        width: 163px;
        position: relative;
        top: 200px;
        left: 10px;
        margin: 10px;
        background-color: #CCCCCC;
        padding: 13px 8px 8px 32px;
        font-size: 17px;
        color: #818181;
        display: block;
    }

    section{
        margin: 0 auto;
        width: 80%;
        padding: 20px;
        border: 1px solid #808080;
        border-radius: 5px;
        background-color: #515151;
        font-family: 'Montserrat','san-serif';
        font-size: 20px;
    }

    .content-box{
        border: gray; 
        padding: 50px 8px 70px 32px;
        color: #808080;
        background: #515151;
        margin-left: auto;
        margin-right: auto;
        margin-top: auto;
        margin-bottom: 0%;
        width : 80%;
        height : 40%;
    }

    .formbox{
        color: #808080;
        box-sizing: content-box;
        width : 200px;
        height: 68px;
    }
    .formbox2{
        color: #808080;
        box-sizing: content-box;
        width : 850px;
        height: 68px;
    }

    .formbox > .form-label {
        color: #f5f5f5;
    }

    .formbox > .form-check-label {
        color: #f5f5f5;
    }  
    
    .main{
        color: #f5f5f5;
        font-size : 20px;
        font-weight: bold;
    }
#nav{
    margin: 0 auto;
        width: 18%;
        border: 1px solid #808080;
        border-radius: 5px;
        background-color: #515151;
        font-family: 'Montserrat','san-serif';
        font-size: 20px;
}


</style>