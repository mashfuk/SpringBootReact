import React, {Component } from 'react'
import axios from 'axios';
//import ReactHTMLTableToExcel from 'react-html-table-to-excel';
import '../App.css';
import authHeader from '../services/auth-header';


export class DropDown extends Component {
constructor(props) {
super(props)
this.state = {
stateId: '',
countryId: '',
CountryData: [],
StateData: [],
CityData: []
}
}
componentDidMount() {
axios.get('http://localhost:8080/api/v1/country/all',{ headers: authHeader() }).then(response => {
console.log(response.data);
this.setState({
CountryData: response.data
});
});
}
ChangeState = (e) => {
this.setState({
countryId: e.target.value
});
axios.get('http://localhost:8080/api/v1/state/all?countryId=' + e.target.value,{ headers: authHeader() }).then(response => {
console.log(response.data);
this.setState({
StateData: response.data,
});
});
}
ChangeCity = (e) => {
this.setState({
stateId: e.target.value
});
axios.get('http://localhost:8080/api/v1/city/all?stateId=' + e.target.value,{ headers: authHeader() }).then(response => {
console.log(response.data);
this.setState({
CityData: response.data
});
});
}


render() {  
return (  
<div>  
<div class="row" className="hdr">  
<div class="col-sm-12 btn btn-info">  
Cascading Dropdown in ReactJS  
</div>  
</div>  
<div className="form-group dropdn">  
<select className="form-control" name="country" value={this.state.countryId} onChange={this.ChangeState}  >  
<option>Select Country</option>  
{this.state.CountryData.map((e, key) => {  
return <option key={key} value={e.id}>{e.name}</option>;  
})}  
</select>  
<select className="form-control slct" name="state" value={this.state.stateId} onChange={this.ChangeCity} >  
<label for="company">State Name</label>    
{this.state.StateData.map((e, key) => {  
return <option key={key} value={e.id}>{e.name}</option>;  
})}  
</select>  
<select className="form-control slct" name="city" value={this.state.CityData}  >  
{this.state.CityData.map((e, key) => {  
return <option key={key} value={e.id}>{e.name}</option>;  
})}  
</select>  
</div>  
</div>  
)  
}  
}  
export default DropDown  