package org.example.service;

import org.example.dto.CountryDto;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDto> getAllCountriesOrdered() {
        return countryRepository.findAllAsDtoOrdered();
    }
}
