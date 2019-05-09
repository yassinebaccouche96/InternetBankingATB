<template>
  <div id="app">
    <menu-header v-if="showMenu"></menu-header>
    <b-row class="text-center">
      <b-col id="col-left" cols="2" v-if="showMenu">
        <b-card no-body class="mb-1">
          <b-card-header header-tag="header" class="p-1" role="tab">
            <b-button
              block
              href="#"
              v-b-toggle.accordion-alert
              variant="info"
              class="header-nav text-left"
            >
              <b-badge variant="primary" pill>0</b-badge>Nouvelle(s) Alerte
            </b-button>
          </b-card-header>
          <b-collapse
            id="accordion-alert"
            visible
            accordion="accordion-alert"
            role="tabpanel"
          >
            <b-card-body>0 alerte</b-card-body>
          </b-collapse>
        </b-card>
      </b-col>
      <b-col id="col-right" cols="10">
        <router-view></router-view>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import MenuHeader from "./components/menu";

export default {
  name: "app",
  components: {
    MenuHeader
  },
  computed: {
    showMenu() {
      return this.$route.name !== "auth";
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#col-left {
  margin-top: 20px;
}

#col-right {
  margin-top: 20px;
}
</style>
