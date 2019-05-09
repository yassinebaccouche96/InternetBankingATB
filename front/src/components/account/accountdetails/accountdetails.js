import moment from "moment";
import AppService from "@/services/AppService.js";
import OperationEndPoints from "@/endPoints/OperationEndPoints.js";

export default {
  name: "accountdetails",
  components: {},
  props: {
    accounts: { type: Array, default: [] }
  },
  data() {
    return {
      accountsToSelect: [],
      selectedAccount: {},
      operations: [],
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
          transactionDate: "Date",
          description: "Intitulé et détails",
          debit: "Debit",
          credit: "Credit",
          balance: "Solde"
        }
      }
    };
  },
  computed: {},
  watch: {
    accounts() {
      this.accountsToSelect = [];
      let account = { value: null, text: "Selectionnez un compte" };
      this.accountsToSelect.push(account);
      this.accounts.forEach(acc => {
        acc.creationDate = moment(acc.creationDate).format("DD/MM/YYYY");
        account = {
          value: acc,
          text: acc.accountNumber + " " + acc.accountName
        };
        this.accountsToSelect.push(account);
      });
    }
  },
  mounted() {
    console.log("mounted account details");
  },
  methods: {
    loadSelectedAccount() {
      AppService.get(
        OperationEndPoints.getTransactions +
          "/" +
          this.selectedAccount.accountNumber
      )
        .then(resp => {
          this.operations = resp.data;
          this.processTransactionData();
        })
        .catch(error => {
          console.log("cant't load user accounts", error);
        });
    },
    processTransactionData() {
      let transactionData = {
        transactionDate: "",
        description: "",
        debit: "",
        credit: "",
        balance: ""
      };
      this.transactionTableData = [];
      this.operations.forEach(operation => {
        transactionData = {
          transactionDate: "",
          description: "",
          debit: "",
          credit: "",
          balance: ""
        };
        if (operation.transactionType === "CREDIT") {
          transactionData.credit = operation.amount;
          transactionData.debit = "----";
        } else if (operation.transactionType === "DEBIT") {
          transactionData.debit = operation.amount;
          transactionData.credit = "----";
        }
        transactionData.transactionDate = moment(
          operation.transactionDate
        ).format("DD/MM/YYYY");
        transactionData.description = operation.description;
        transactionData.balance = operation.accountBalance;

        this.transactionTableData.push(transactionData);
      });
    }
  }
};
