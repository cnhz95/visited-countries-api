package com.example.visitedcountries.repository;

import com.example.visitedcountries.entity.VisitedCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitedCountryRepository extends JpaRepository<VisitedCountry, Integer> {
    List<VisitedCountry> findByUserId(Integer userId);

    Optional<VisitedCountry> findByIdAndUserId(Integer id, Integer userId);
}
