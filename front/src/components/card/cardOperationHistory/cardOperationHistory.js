import AppService from "@/services/AppService.js";
import OperationEndPoints from "@/endPoints/OperationEndPoints.js";

export default {
  name: "card-operation-history",
  components: {},
  props: {
    accounts: { type: Array, required: true }
  },
  data() {
    return {
      selectedAccount: {},
      transactionTableData: [],
      transactionTableColumns: [
        "transactionDate",
        "description",
        "debit",
        "credit",
        "balance"
      ],
      options: {
        headings: {
          transactionDate: "Numéro de carte",
          description: "Date",
          debit: "Type",
          credit: "Lieu",
          balance: "Pays",
          balance1: "Montant",
          balance2: "Status",
          balance3: "Date de réglement"
        }
      }
    };
  },
  computed: {},
  mounted() {},
  methods: {
    loadTransactions() {
      console.log("load transactions", this.selectedAccount.accountNumber);
      AppService.get(
        OperationEndPoints.transactionsDoneByAccountCard +
          "/" +
          this.selectedAccount.accountNumber
      )
        .then(resp => {
          this.operations = resp.data;
          console.log(resp.data);
        })
        .catch(error => {
          console.log("cant't load transactions", error);
        });
    }
  }
};
