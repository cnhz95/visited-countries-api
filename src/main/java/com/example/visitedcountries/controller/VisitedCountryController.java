package com.example.visitedcountries.controller;

import com.example.visitedcountries.entity.VisitedCountry;
import com.example.visitedcountries.service.VisitedCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PatchMapping("/{visitId}")
    public ResponseEntity<Void> updateVisitedCountryNote(
            @PathVariable Integer userId,
            @PathVariable Integer visitId,
            @RequestBody Map<String, String> body
    ) {
        String note = body.get("note");
        visitedCountryService.updateVisitedCountryNote(userId, visitId, note);
        return ResponseEntity.noContent().build();
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
