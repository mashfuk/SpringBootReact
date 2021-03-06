package com.springjwt.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="Name is required")
	private String name;
	
	@NotNull(message="Dob is required")
	private Calendar dob;
	

	private Double creditlimit;

	
	public Customer(@NotNull(message = "Name is required") String name,
			@NotNull(message = "Dob is required") Calendar dob,
			@NotNull(message = "Creditlimit is required") Double creditlimit) {
		super();
		this.name = name;
		this.dob = dob;
		this.creditlimit = creditlimit;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public Double getCreditlimit() {
		return creditlimit;
	}

	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}
	
	
	
	
}
