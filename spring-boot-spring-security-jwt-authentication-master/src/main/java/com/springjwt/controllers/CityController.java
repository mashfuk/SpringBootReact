package com.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjwt.models.City;
import com.springjwt.service.CityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/all")
    public Iterable<City> getAllStates(@RequestParam Long stateId) {
        log.info("StateId id requested {}", stateId);
        return cityService.getCitiesByState(stateId);
    }
}
