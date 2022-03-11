import httpClient from "../http-common";
import authHeader from './auth-header';

const getAll = () => {
    return httpClient.get('/employees',{ headers: authHeader() });
}

const create = data => {
    return httpClient.post("/employees", data, { headers: authHeader() });
}

const get = id => {
    return httpClient.get(`/employees/${id}`, { headers: authHeader() });
}

const update = data => {
    return httpClient.put('/employees', data, { headers: authHeader() });
}

const remove = id => {
    return httpClient.delete(`/employees/${id}`, { headers: authHeader() });
}
export default { getAll, create, get, update, remove };