package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "country_stats")
@Getter
@Setter
public class CountryStat {

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(nullable = false)
    private int year;

    private int population;
    private Long gdp;
}
