package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Employee;
import com.bezkoder.springjwt.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository eRepo;

	@GetMapping("/employees")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Employee> getAllEmployees() {
		return eRepo.findAll();
	}

	@GetMapping("/employees/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Employee getEmployeeById(@PathVariable Long id) {

		return eRepo.findById(id).get();
	}

	@PostMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee saveEmployeeDetails(@RequestBody Employee employee) {
		
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return eRepo.save(employee);
	}

	@PutMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}

	@DeleteMapping("/employees/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		eRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}