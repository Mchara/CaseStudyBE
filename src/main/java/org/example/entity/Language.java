package org.example.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String language;

    @OneToMany(mappedBy = "language")
    private List<CountryLanguage> countryLanguages;
}
