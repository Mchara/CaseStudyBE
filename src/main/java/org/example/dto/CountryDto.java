package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDto {
    private String name;
    private Long area;
    private String countryCode2;
}