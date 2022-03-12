package com.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjwt.models.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}