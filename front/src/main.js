import Vue from "vue";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
// import VueMoment from "vue-moment";
// import moment from "moment";
import App from "./App.vue";

import "@/styles/main.scss";

// import axios from "axios";
// import VueAxios from "vue-axios";
import router from "./router";
import store from "./store/AppStore.js";
//import { ServerTable, ClientTable, Event } from "vue-tables-2";
import { ClientTable } from "vue-tables-2";

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
// Vue.use(VueAxios, axios);
Vue.use(ClientTable, {}, false, "bootstrap4", "default");
// Vue.use(moment);
// Vue.use(VueMoment);
// Vue.use(
//   ServerTable,
//   [(options = {})],
//   [(useVuex = false)],
//   [(theme = "bootstrap3")],
//   [(template = "default")]
// );
// Vue.use(
//   Event,
//   [(options = {})],
//   [(useVuex = false)],
//   [(theme = "bootstrap3")],
//   [(template = "default")]
// );

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
