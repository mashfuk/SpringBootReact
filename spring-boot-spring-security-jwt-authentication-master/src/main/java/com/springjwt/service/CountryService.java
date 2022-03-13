package com.springjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springjwt.models.Country;
import com.springjwt.repository.CountryRepository;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Cacheable(value = "findCountryById", key = "#countryId")
    public Optional<Country> findCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Cacheable(value = "getCountries")
    public Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }

}
