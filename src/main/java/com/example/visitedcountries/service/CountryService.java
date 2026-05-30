package com.example.visitedcountries.service;

import com.example.visitedcountries.entity.Country;
import com.example.visitedcountries.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public Page<Country> getCountries(String region, Pageable pageable) {
        if (region == null || region.isBlank()) {
            return countryRepository.findAll(pageable);
        }
        return countryRepository.findCountriesByRegion(region, pageable);
    }

    public List<String> getAllRegions() {
        return countryRepository.findAllRegions();
    }
}
