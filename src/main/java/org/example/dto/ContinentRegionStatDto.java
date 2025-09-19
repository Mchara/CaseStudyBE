package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContinentRegionStatDto {
    private String continentName;
    private String regionName;
    private String countryName;
    private int year;
    private int population;
    private Long gdp;

}
