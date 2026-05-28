package com.example.visitedcountries.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "visited_countries")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = {"user", "country"})
//@EqualsAndHashCode(exclude = {"user", "country"})
public class VisitedCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country country;

    @Column
    private String note;
}
