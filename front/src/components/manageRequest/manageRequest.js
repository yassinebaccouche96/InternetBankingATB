import AppService from "@/services/AppService.js";
import RequestesEndPoints from "@/endPoints/RequestsEndPoints.js";

export default {
  name: "manage-request",
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
          text: "Gerer les demandes",
          href: "#"
        }
      ],
      requestes: [],
      selectedRequeste: {},
      requesteToSelect: []
    };
  },
  computed: {},
  mounted() {
    this.loadRequestes();
  },
  methods: {
    loadSelectedRequestes() {},
    loadRequestes() {
      AppService.get(RequestesEndPoints.loadRequestes)
        .then(resp => {
          this.requestes = resp.data;
          console.log(this.data);
          // this.processChecksData();
          // console.log(this.checks);
          // this.processAccountsData();
        })
        .catch(error => {
          console.log("cant't load requestes", error);
        });
    }
  }
};
