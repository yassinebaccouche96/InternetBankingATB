//import axios from "axios";
// import AppService from "@/services/AppService.js";

export default {
  name: "auth",
  components: {},
  props: [],
  data() {
    return {
      user: {
        userName: "",
        password: ""
      }
    };
  },
  computed: {},
  mounted() {},
  methods: {
    onSubmit() {
      this.$store.dispatch("AUTH_REQUEST", this.user).then(() => {
        this.$router.push({ name: "home" });
      });
    },
    onReset() {
      console.log("on reset");
    }
  }
};
