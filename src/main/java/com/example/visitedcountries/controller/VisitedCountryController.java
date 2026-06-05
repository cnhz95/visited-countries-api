package com.example.visitedcountries.controller;

import com.example.visitedcountries.entity.VisitedCountry;
import com.example.visitedcountries.service.VisitedCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/visits")
@RequiredArgsConstructor
public class VisitedCountryController {
    private final VisitedCountryService visitedCountryService;

    @PostMapping
    ResponseEntity<VisitedCountry> createVisitedCountry(
            @PathVariable Integer userId,
            @RequestBody VisitedCountry visitedCountry
    ) {
        VisitedCountry created = visitedCountryService.createVisitedCountry(userId, visitedCountry);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<VisitedCountry>> listVisitedCountries(@PathVariable Integer userId) {
        return ResponseEntity.ok(visitedCountryService.getUserVisitedCountries(userId));
    }

    @PutMapping("/{visitId}/note")
    public ResponseEntity<VisitedCountry> updateVisitedCountryNote(
            @PathVariable Integer userId,
            @PathVariable Integer visitId,
            @RequestBody String note
    ) {
        return ResponseEntity.ok(visitedCountryService.updateVisitedCountryNote(userId, visitId, note));
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<Void> deleteVisitedCountry(
            @PathVariable Integer userId,
            @PathVariable Integer visitId
    ) {
        visitedCountryService.deleteVisitedCountry(userId, visitId);
        return ResponseEntity.noContent().build();
    }
}
