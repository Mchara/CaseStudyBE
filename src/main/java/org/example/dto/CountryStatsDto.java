package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CountryStatsDto {
    private String name;
    private String countryCode3;
    private int year;
    private int population;
    private Long  gdp;
}
