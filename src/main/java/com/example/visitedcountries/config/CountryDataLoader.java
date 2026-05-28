package com.example.visitedcountries.config;

import com.example.visitedcountries.entity.Country;
import com.example.visitedcountries.repository.CountryRepository;
import com.example.visitedcountries.service.CountryImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryDataLoader implements CommandLineRunner {
    private final CountryRepository countryRepository;
    private final CountryImportService countryImportService;

    @Override
    @Transactional
    public void run(String... args) {
        if (countryRepository.count() > 0) {
            return;
        }

        List<Country> countries = countryImportService.fetchCountries();

        countryRepository.saveAll(countries);
    }
}
