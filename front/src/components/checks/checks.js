import AppService from "@/services/AppService.js";
import CheckEndPoints from "@/endPoints/CheckEndPoints.js";
import AccountEndPoints from "@/endPoints/AccountEndPoints.js";
import ClientRequestEndPoint from "@/endPoints/ClientRequestEndPoint.js";
import moment from "moment";

export default {
  name: "checks",
  components: {},
  props: [],
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
  data() {
    return {
      items: [
        {
          text: "Home",
          href: "#"
        },
        {
          text: "Mes chequiers",
          href: "#"
        }
      ],
      checkTypes: [{ value: null, text: "Selectionnez un type de chequier" }],
      selectedCheckType: {},
      checks: [],
      accounts: [],
      accountsToSelect: [],
      checksToSelect: [],
      selectedCheck: {
        account: {}
      },
      selectedAccount: {}
    };
  },
  computed: {},
  mounted() {
    this.loadUserCkecks();
  },
  methods: {
    loadUserCkecks() {
      AppService.get(CheckEndPoints.userChecks)
        .then(resp => {
          this.checks = resp.data;
          this.processChecksData();
          // console.log(this.checks);
          // this.processAccountsData();
        })
        .catch(error => {
          console.log("cant't load user checks", error);
        });
    },
    processChecksData() {
      this.checksToSelect = [];
      let check = { value: null, text: "Selectionnez un chequier" };
      this.checksToSelect.push(check);
      this.checks.forEach(chk => {
        chk.deliveryDate = moment(chk.deliveryDate).format("DD/MM/YYYY");
        check = {
          value: chk,
          text: chk.startNum + " " + chk.endNum + " " + chk.checkType
        };
        this.checksToSelect.push(check);
      });
    },
    loadSelectedCheck() {
      console.log("load selected check", this.selectedCheck);
    },
    openNewCheckModalRequest() {
      AppService.get(AccountEndPoints.userAccountsEndPoint)
        .then(resp => {
          this.accounts = resp.data;
          this.getAllCheckTypes();
        })
        .catch(error => {
          console.log("cant't load check accounts", error);
        });
    },
    getAllCheckTypes() {
      this.checkTypes = [];
      AppService.get(CheckEndPoints.getCheckTypes)
        .then(resp => {
          let checkType = { value: null, text: "" };
          resp.data.forEach(ct => {
            checkType = { value: ct, text: ct };
            this.checkTypes.push(checkType);
          });
          this.$bvModal.show("check-request");
        })
        .catch(error => {
          console.log("cant't find check types", error);
        });
    },
    loadSelectedAccount() {
      console.log(
        "selected account changed, the selceted account is",
        this.selectedAccount
      );
    },
    checkRequest() {
      console.log("click on check request");
      let clientRequest = {
        requestType: "CHECK_REQUEST",
        check: {
          checkType: this.selectedCheckType,
          account: { id: this.selectedAccount.id },
          activated: false
        }
      };

      AppService.postJson(ClientRequestEndPoint.newClientRequest, clientRequest)
        .then(resp => {
          console.log("resp.data", resp.data);
        })
        .catch(error => {
          console.log("cant't add new check request", error);
        });
    }
  }
};
