package com.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjwt.models.State;
import com.springjwt.service.StateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/state")
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping(value = "/all")
    public Iterable<State> getAllStates(@RequestParam Long countryId) {
        log.info("Country id requested {}", countryId);
        return stateService.getStatesByCountry(countryId);
    }
}
