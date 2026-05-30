package com.example.visitedcountries;

import org.springframework.boot.SpringApplication;

public class TestVisitedCountriesApplication {

    public static void main(String[] args) {
        SpringApplication.from(VisitedCountriesApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
