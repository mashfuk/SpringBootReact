package com.springjwt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjwt.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findAllByOrderByIdDesc();

}
