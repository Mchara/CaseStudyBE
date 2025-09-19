package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    private Long area;

    @Column(name = "national_day")
    private java.sql.Date nationalDay;

    @Column(name = "country_code2", length = 2)
    private String countryCode2;

    @Column(name = "country_code3", length = 3)
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> countryLanguages;

    @OneToMany(mappedBy = "country")
    private List<CountryStat> stats;
}
