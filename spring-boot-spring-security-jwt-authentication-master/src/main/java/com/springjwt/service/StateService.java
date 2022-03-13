package com.springjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springjwt.models.State;
import com.springjwt.repository.StateRepository;

import java.util.Optional;

@Service
public class StateService {

    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Cacheable(value = "getStatesByCountry", key = "#countryId")
    public Iterable<State> getStatesByCountry(Long countryId) {
        return stateRepository.findStatesByCountry_Id(countryId);
    }

    @Cacheable(value = "findStateById", key = "#stateId")
    public Optional<State> findStateById(Long stateId) {
        return stateRepository.findById(stateId);
    }
}
