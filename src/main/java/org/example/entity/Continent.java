package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "continents")
@Getter
@Setter
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Region> regions;
}
