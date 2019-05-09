import axios from "axios";
import store from "@/store/AppStore";

export default class AppService {
  static postJson(url, data) {
    const headers = {
      "Content-Type": "application/json",
      Authorization: store.state.token
    };

    return axios.post(url, data, {
      headers
    });
  }

  static get(url) {
    const headers = {
      "Content-Type": "application/json",
      Authorization: store.state.token
    };
    return axios.get(url, {
      headers
    });
  }
}
