import React, { Component } from 'react';
import { useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import { useEffect } from "react/cjs/react.development";
import employeeService from "../services/employee.service";
import DatePicker from 'react-datepicker';
 
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

const AddEmployee = () => {
    const [name, setName] = useState('');
    const [location, setLocation] = useState('');
    const [department, setDepartment] = useState('');
    const history = useHistory();
    const { id } = useParams();
    const [startDate, setStartDate] = useState(new Date());
    
    

    const saveEmployee = (e) => {
        e.preventDefault();

        const employee = { name, location, department, startDate,  id };
        if (id) {
            //update
            employeeService.update(employee)
                .then(response => {
                    console.log('Employee data updated successfully', response.data);
                    history.push('/employees');
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        } else {
            //create
            employeeService.create(employee)
                .then(response => {
                    console.log("employee added successfully", response.data);
                    history.push("/employees");
                })
                .catch(error => {
                    console.log('something went wroing', error);
                })
        }
    }

    useEffect(() => {
        if (id) {
            employeeService.get(id)
                .then(employee => {
                    setName(employee.data.name);
                    setLocation(employee.data.location);
                    setDepartment(employee.data.department);
                    setStartDate(new Date(new Date(employee.data.startDate).toISOString()));
                })
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        }
    }, [])
    return (
        <div className="container">
            <h3>Add Employee</h3>
            <hr />
            <form>
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        placeholder="Enter name"
                    />

                </div>
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="department"
                        value={department}
                        onChange={(e) => setDepartment(e.target.value)}
                        placeholder="Enter Department"
                    />

                </div>
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control col-4"
                        id="location"
                        value={location}
                        onChange={(e) => setLocation(e.target.value)}
                        placeholder="Enter Location"
                    />
                </div>

                <div className="form-group">
                <DatePicker className="form-control col-4" selected={startDate} onChange={(date) => setStartDate(date)} />
                </div>
                
                <div >
                    <button onClick={(e) => saveEmployee(e)} className="btn btn-primary">Save</button>
                </div>
            </form>
            <hr />
            <Link to="/">Back to List</Link>
        </div>
    )
}

export default AddEmployee;