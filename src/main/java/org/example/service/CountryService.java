package org.example.service;

import org.example.dto.CountryDto;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDto> getAllCountriesOrdered() {
        return countryRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .map(c -> new CountryDto(c.getName(), c.getArea(), c.getCountryCode2()))
                .collect(Collectors.toList());
    }
}
