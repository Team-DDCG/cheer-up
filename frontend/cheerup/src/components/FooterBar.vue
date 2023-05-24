<template>
  <footer class="footer">
      <div class="footer__content">
        <nav class="footer__nav">
          <a href="#" class="footer__link">고객문의</a>
          <a href="#" class="footer__link">사용자가이드</a>
          <a href="#" class="footer__link">개인정보처리방침</a>
          <a href="#" class="footer__link">CONTACT</a>
        </nav>
        <div class="footer__text">
          <p class="footer__text__content">
            ⓒ 2023. CheerUp_KB 3th, Inc.
          </p>
        </div>
      </div>
    </footer>
</template>

<script>
export default {
data() {
    return {

    }
},

}
</script>
<style scoped>
.footer {
  background: #515151;
  padding: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #f5f5f5;
}

.footer__content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  width: 100%;
}

.footer__nav {
  display: flex;
  justify-content: center;
  align-items: center;
}

.footer__link {
  margin: 0 10px;
  font-size: 14px;
  font-weight: 700;
  text-decoration: none;
  color: #f5f5f5;
}

.footer__text {
  text-align: right;
  flex-grow: 1;
}

.footer__text__content {
  font-weight: 700;
  margin: 0;
}
</style>