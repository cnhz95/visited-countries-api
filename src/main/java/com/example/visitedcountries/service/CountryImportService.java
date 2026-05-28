package com.example.visitedcountries.service;

import com.example.visitedcountries.dto.CountryResponse;
import com.example.visitedcountries.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CountryImportService {
    private final RestClient restClient;

    public List<Country> fetchCountries() {
        CountryResponse[] response = restClient.get()
                .uri("/all?fields=name,region,population")
                .retrieve()
                .body(CountryResponse[].class);

        if (response == null || response.length == 0) {
            return List.of();
        }

        return Stream.of(response)
                .map(countryResponse -> Country.builder()
                        .name(countryResponse.name().common())
                        .region(countryResponse.region())
                        .population(countryResponse.population())
                        .build()
                )
                .toList();
    }
}
