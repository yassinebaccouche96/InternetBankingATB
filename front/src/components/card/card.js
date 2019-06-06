import AppService from "@/services/AppService.js";
import CardEndPoints from "@/endPoints/CardEndPoints.js";
import AccountEndPoints from "@/endPoints/AccountEndPoints.js";
import moment from "moment";

import CardDetails from "@/components/card/cardDetails";
import CardOperationHistory from "@/components/card/cardOperationHistory";

// import { Bar } from "vue-chartjs";
// import { Line } from "vue-chartjs";

import CommitChart from "@/components/card/barChart";

export default {
  name: "card",
  components: { CardDetails, CardOperationHistory, CommitChart },
  props: [],
  data() {
    return {
      chartData: {
        datacollection: {
          labels: ["January", "February"],
          datasets: [
            {
              label: "Data One",
              backgroundColor: "#f87979",
              data: [40, 20]
            }
          ]
        }
      },
      charOptions: {
        responsive: true,
        maintainAspectRatio: false
      },
      items: [
        {
          text: "Home",
          href: "#"
        },
        {
          text: "Mes cartes",
          href: "#"
        }
      ],
      columns: [
        "cardNumber",
        "cardType",
        "accountNumber",
        "ceiling",
        "expirationDate",
        "status",
        "action"
      ],
      userAccounts: [],
      cardsTableData: [],
      options: {
        headings: {
          cardNumber: "Numéro",
          cardType: "Type",
          accountNumber: "Numéro de Compte",
          ceiling: "Plafond",
          expirationDate: "Date d'éxpiration",
          status: "Status",
          action: "Action"
        }
      },
      accountsToSelect: [],
      selectedAccount: {}
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
          this.accounts = resp.data;
          this.processAccountsData();
        })
        .catch(error => {
          console.log("cant't load user accounts", error);
        });
    },
    processAccountsData() {
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
    },
    loadCard() {
      AppService.get(
        CardEndPoints.accountCardEndPoint +
          "/" +
          this.selectedAccount.accountNumber
      )
        .then(resp => {
          this.cardsTableData = resp.data;
          this.processTableData();
        })
        .catch(error => {
          console.log("cant't load user cards", error);
        });
    },
    rowClicked(data) {
      console.log(data);
      this.$bvModal.show("card-details");
    },
    processTableData() {
      this.cardsTableData.forEach(card => {
        card.expirationDate = moment(card.expirationDate).format("DD/MM/YYYY");
        card.accountNumber = this.selectedAccount.accountNumber;
      });
    }
  }
};
