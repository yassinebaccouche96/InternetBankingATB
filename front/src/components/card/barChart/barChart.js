import { Pie } from "vue-chartjs";

export default {
  extends: Pie,
  components: {},
  props: [],
  data() {
    return {};
  },
  computed: {},
  mounted() {
    // Overwriting base render method with actual data.
    this.renderChart({
      labels: ["Utilisé", "reste"],
      datasets: [
        {
          label: "Data One",
          backgroundColor: ["#41B883", "#E46651"],
          data: [200, 800]
        }
      ]
    });
  },
  methods: {}
};
