package com.example.visitedcountries.dto;

public record CountryResponse(Name name, String region, Integer population) {
    public record Name(String common) {}
}
