import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import AppService from "@/services/AppService.js";
import AuthEndPoint from "@/endPoints/AuthEndPoints.js";

Vue.use(Vuex);

const state = {
  // token: ''
  token: localStorage.getItem("user-token") || "",
  status: "",
  currentUser: {}
};
const getters = {
  // token: state => state.token,
  isAuthenticated: state => !!state.token,
  authStatus: state => state.status
};
const mutations = {
  updateToken: (state, token) => {
    state.token = token;
  },
  AUTH_REQUEST: state => {
    state.status = "loading";
  },
  AUTH_SUCCESS: (state, token) => {
    state.status = "success";
    state.token = token;
  },
  AUTH_ERROR: state => {
    state.status = "error";
  },
  AUTH_LOGOUT: () => {
    state.status = "";
    state.state = "";
  }
};
const actions = {
  updateToken: (context, token) => {
    context.commit("uppdateToken", token);
  },
  AUTH_REQUEST: ({ commit }, user) => {
    return new Promise((resolve, reject) => {
      commit("AUTH_REQUEST");
      AppService.postJson(AuthEndPoint.loginEndPoint, user)
        .then(resp => {
          const token = resp.headers.authorization;
          const role = resp.headers.role;
          localStorage.setItem("user-token", token);
          localStorage.setItem("user-role", role);
          commit("AUTH_SUCCESS", token);
          resolve(resp);
        })
        .catch(err => {
          commit("AUTH_ERROR", err);
          localStorage.removeItem("user-token");
          reject(err);
        });
    });
  },
  AUTH_LOGOUT: ({ commit }) => {
    return new Promise(resolve => {
      commit("AUTH_LOGOUT");
      localStorage.removeItem("user-token");
      localStorage.removeItem("user-role");
      // remove the axios default header
      delete axios.defaults.headers.common["Authorization"];
      resolve();
    });
  }
};
const store = new Vuex.Store({
  state,
  getters,
  mutations,
  actions
});
export default store;
