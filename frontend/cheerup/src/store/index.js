import { createStore } from "vuex";
import { fetchListItem, fetchUserInfo, fetchAskItem } from "../api/index.js";

export default createStore({
  state: {
    list: [],
    user: "",
    item: "",
  },
  getters: {},
  mutations: {
    SET_LIST(state, list) {
      state.list = list;
    },
    SET_USER(state, user) {
      state.user = user;
    },
    SET_ITEM(state, id) {
      state.item = id;
    },
  },
  actions: {
    FETCH_LIST(context, pageName) {
      return fetchListItem(pageName)
        .then((res) => {
          context.commit("SET_LIST", res.data);
          return res;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    FETCH_USER(context, userName) {
      return fetchUserInfo(userName)
        .then((res) => {
          context.commit("SET_USER", res.data);
          return res;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    FETCH_ITEM(context, id) {
      return fetchAskItem(id)
        .then((res) => {
          context.commit("SET_ITEM", res.data);
          return res;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
