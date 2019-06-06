export default {
  name: "transfer",
  components: {},
  props: [],
  data() {
    return {
      items: [
        {
          text: "Home",
          href: "#"
        },
        {
          text: "Virements",
          href: "#"
        }
      ],
      fromSelectedAccount: {},
      toSelectedAccount: {},
      accounts: {},
      transferAmout: "",
      transferDate: "",
      transferNote: ""
    };
  },
  computed: {},
  mounted() {},
  methods: {
    fromSelectedAccountChange() {
      console.log("from account action");
    },
    toSelectedAccountChange() {
      console.log("to account action");
    }
  }
};
