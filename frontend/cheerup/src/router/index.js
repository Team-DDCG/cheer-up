import { createRouter, createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import ResumeView from "../views/ResumeView.vue";
import AskView from "../views/AskView.vue";
import PortfolioView from "../views/PortfolioView.vue";
import UserView from "../views/UserView.vue";
import ItemView from "../views/ItemView.vue";
import RegisterView from "../views/RegisterView.vue";
import RegisterView2 from "../views/RegisterView2.vue";
import RegisterView3 from "../views/RegisterView3.vue";
import RegisterView4 from "../views/RegisterView4.vue";
import LoginView from "../views/LoginView.vue";
import FindView from "../views/FindView.vue";
import FindIdView1 from "../views/FindIdView1.vue";
import FindIdView2 from "../views/FindIdView2.vue";
import FindPwView1 from "../views/FindPwView1.vue";
import FindPwView2 from "../views/FindPwView2.vue";
import MainView from "../views/MainView.vue";
// import MypageView from "../views/MypageView.vue";
import MycvView from "../views/MycvView.vue";
// import JobPosting from "../components/JobPosting";

const routes = [
  {
    path: "/item",
    name: "item",
    component: ItemView,
  },
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/resume",
    name: "resume",
    component: ResumeView,
  },
  {
    path: "/ask",
    name: "ask",
    component: AskView,
  },
  {
    path: "/portfolio",
    name: "portfolio",
    component: PortfolioView,
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
  },
  {
    path: "/register2",
    name: "register2",
    component: RegisterView2,
  },
  {
    path: "/register3",
    name: "register3",
    component: RegisterView3,
  },
  {
    path: "/register4",
    name: "register4",
    component: RegisterView4,
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },

  {
    path: "/user/:id",
    name: "user",
    component: UserView,
  },

  {
    path: "/find",
    name: "find",
    component: FindView,
  },

  {
    path: "/findid1",
    name: "findid1",
    component: FindIdView1,
  },

  {
    path: "/findid2",
    name: "findid2",
    component: FindIdView2,
  },
  {
    path: "/findpw1",
    name: "findpw1",
    component: FindPwView1,
  },
  {
    path: "/findpw2",
    name: "findpw2",
    component: FindPwView2,
  },
  {
    path: "/main",
    name: "main",
    component: MainView,
  },
  // {
  //   path: "/mypage",
  //   name: "mypage",
  //   component: MypageView,
  // },
  {
    path: "/mycv",
    name: "mycv",
    component: MycvView,
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
