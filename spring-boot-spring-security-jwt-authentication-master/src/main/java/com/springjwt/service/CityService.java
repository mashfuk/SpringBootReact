package com.springjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springjwt.models.City;
import com.springjwt.repository.CityRepository;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Cacheable(value = "getCitiesByState", key = "#stateId")
    public Iterable<City> getCitiesByState(Long stateId) {
        return cityRepository.findCitiesByState_Id(stateId);
    }

}
