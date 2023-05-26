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
import AiResumeRegisterView from "../views/AiResumeRegisterView.vue";
import AiResumeListView from "../views/AiResumeListView.vue";
// import MypageView from "../views/MypageView.vue";
import MycvView from "../views/MycvView.vue";
import MycvView1 from "../views/MycvView1.vue";
import MycvView2 from "../views/MycvView2.vue";
import MycvView3 from "../views/MycvView3.vue";
import MycvView4 from "../views/MycvView4.vue";
import MycvView5 from "../views/MycvView5.vue";
import MycvView6 from "../views/MycvView6.vue";
import MycvView7 from "../views/MycvView7.vue";
import MycvView8 from "../views/MycvView8.vue";
import MycvView9 from "../views/MycvView9.vue";
// import JobPosting from "../components/JobPosting";
import ErrorView from "../views/ErrorView.vue";

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
  {
    path: "/airesume",
    name: "airesumeregister",
    component: AiResumeRegisterView,
  },
  {
    path: "/airesumelist",
    name: "airesumelist",
    component: AiResumeListView,
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
  },
  {
    path: "/error",
    name: "error",
    component: ErrorView,
    
  },
  {
    path: "/mycv1",
    name: "mycv1",
    component: MycvView1,
  },
  {
    path: "/mycv2",
    name: "mycv2",
    component: MycvView2,
  },
  {
    path: "/mycv3",
    name: "mycv3",
    component: MycvView3,
  },
  {
    path: "/mycv4",
    name: "mycv4",
    component: MycvView4,
  },
  {
    path: "/mycv5",
    name: "mycv5",
    component: MycvView5,
  },
  {
    path: "/mycv6",
    name: "mycv6",
    component: MycvView6,
  },
  {
    path: "/mycv7",
    name: "mycv7",
    component: MycvView7,
  },
  {
    path: "/mycv8",
    name: "mycv8",
    component: MycvView8,
  },
  {
    path: "/mycv9",
    name: "mycv9",
    component: MycvView9,
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
