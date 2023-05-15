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
import LoginView from "../views/LoginView.vue";

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
    path: "/login",
    name: "login",
    component: LoginView,
  },
  
  {
    path: "/user/:id",
    name: "user",
    component: UserView,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;