package com.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjwt.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
