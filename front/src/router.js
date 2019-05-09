import Vue from "vue";
import Router from "vue-router";
import AuthGuard from "./auth-guard";
import Home from "./views/Home.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/auth",
      name: "auth",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "auth" */ "./components/auth")
    },
    {
      path: "/home",
      name: "home",
      component: Home,
      beforeEnter: AuthGuard
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "./views/About.vue"),
      beforeEnter: AuthGuard
    },
    {
      path: "/accounts",
      name: "accounts",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "account" */ "./components/account"),
      beforeEnter: AuthGuard
    },
    {
      path: "/cards",
      name: "cards",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "card" */ "./components/card"),
      beforeEnter: AuthGuard
    },
    { path: "*", redirect: "/auth" }
  ]
});
