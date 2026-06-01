package com.example.visitedcountries.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "visited_countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitedCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column
    private String note;
}
