package com.springjwt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springjwt.models.City;

import java.util.List;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    List<City> findCitiesByState_Id(Long stateId);
}
