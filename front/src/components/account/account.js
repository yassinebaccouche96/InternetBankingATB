import AppService from "@/services/AppService.js";
import AccountEndPoints from "@/endPoints/AccountEndPoints.js";

import AccountDetails from "@/components/account/accountdetails";
import OperationHistory from "@/components/account/operationsHistory";

export default {
  name: "account",
  components: { AccountDetails, OperationHistory },
  props: [],
  data() {
    return {
      items: [
        {
          text: "Home",
          href: "#"
        },
        {
          text: "Mes Comptes",
          href: "#"
        }
      ],
      columns: ["accountNumber", "accountType", "currency", "balance"],
      accountsTableData: [],
      options: {
        headings: {
          accountNumber: "Numero de compte",
          accountType: "Type de compte",
          currency: "Devise",
          balance: "Solde"
        }
      }
    };
  },
  computed: {},
  mounted() {
    this.loadUserAccounts();
  },
  methods: {
    loadUserAccounts() {
      AppService.get(AccountEndPoints.userAccountsEndPoint)
        .then(resp => {
          this.accountsTableData = resp.data;
        })
        .catch(error => {
          console.log("cant't load user accounts", error);
        });
    },

    rowClicked(data) {
      debugger;
      console.log(data);
    }
  }
};
