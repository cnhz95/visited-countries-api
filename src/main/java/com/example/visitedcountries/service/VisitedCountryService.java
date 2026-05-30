package com.example.visitedcountries.service;

import com.example.visitedcountries.entity.Country;
import com.example.visitedcountries.entity.User;
import com.example.visitedcountries.entity.VisitedCountry;
import com.example.visitedcountries.repository.CountryRepository;
import com.example.visitedcountries.repository.UserRepository;
import com.example.visitedcountries.repository.VisitedCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitedCountryService {
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final VisitedCountryRepository visitedCountryRepository;

    @Transactional
    public VisitedCountry createVisitedCountry(Integer userId, VisitedCountry visitedCountry) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        Integer countryId = visitedCountry.getCountry().getId();
        Country country = countryRepository.findById(countryId)
                .orElseThrow();

        visitedCountry.setUser(user);
        visitedCountry.setCountry(country);
        return visitedCountryRepository.save(visitedCountry);
    }

    @Transactional(readOnly = true)
    public List<VisitedCountry> getUserVisitedCountries(Integer userId) {
        return visitedCountryRepository.findByUserId(userId);
    }

    @Transactional
    public VisitedCountry updateVisitedCountryNote(Integer userId, Integer visitedCountryId, String note) {
        VisitedCountry visitedCountry = visitedCountryRepository.findByIdAndUserId(visitedCountryId, userId)
                .orElseThrow();

        String cleanedNote = note.replace("\"", "");
        visitedCountry.setNote(cleanedNote);

        return visitedCountry;
    }

    @Transactional
    public void deleteVisitedCountry(Integer userId, Integer visitedCountryId) {
        VisitedCountry visitedCountry = visitedCountryRepository.findByIdAndUserId(visitedCountryId, userId)
                .orElseThrow();

        visitedCountryRepository.delete(visitedCountry);
    }
}
