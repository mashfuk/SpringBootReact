import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/test/';

class TutorialDataService {
  getAll() {
    return axios.get(API_URL+"tutorials",{ headers: authHeader() });
  }

  get(id) {
    return axios.get(API_URL+`tutorials/${id}`,{ headers: authHeader() });
  }

  create(data) {
    return axios.post(API_URL+"tutorials", data,{ headers: authHeader() });
  }

  update(id, data) {
    return axios.put(API_URL+`tutorials/${id}`, data,{ headers: authHeader() });
  }

  delete(id) {
    return axios.delete(API_URL+`tutorials/${id}`,{ headers: authHeader() });
  }

  deleteAll() {
    return axios.delete(API_URL+`tutorials`,{ headers: authHeader() });
  }

  findByTitle(title) {
    return axios.get(API_URL+`tutorials?title=${title}`,{ headers: authHeader() });
  }
}

export default new TutorialDataService();