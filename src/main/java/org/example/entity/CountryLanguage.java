package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "country_languages")
@Getter
@Setter
public class CountryLanguage {

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(nullable = false)
    private boolean official;
}
