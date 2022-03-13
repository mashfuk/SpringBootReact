package com.springjwt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springjwt.models.State;

import java.util.List;

@Repository
public interface StateRepository extends PagingAndSortingRepository<State, Long> {

    List<State> findStatesByCountry_Id(Long countryId);
}
