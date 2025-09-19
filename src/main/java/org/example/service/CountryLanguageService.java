package org.example.service;


import org.example.dto.CountryLanguageDto;
import org.example.entity.CountryLanguage;
import org.example.repository.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguageDto> getLanguagesByCountryCode(String countryCode2) {
        List<CountryLanguageDto> languages = countryLanguageRepository.findLanguagesByCountryCode(countryCode2);
        languages.forEach(System.out::println);
        return languages;
    }
}

