export default {
  name: "menuHeader",
  components: {},
  props: [],
  data() {
    return {
      userRole: localStorage.getItem("user-role")
    };
  },
  computed: {},
  mounted() {},
  methods: {
    logout() {
      this.$store.dispatch("AUTH_LOGOUT").then(() => {
        this.$router.push("/auth");
      });
    }
  }
};
