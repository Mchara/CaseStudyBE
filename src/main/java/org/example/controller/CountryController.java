package org.example.controller;

import org.example.dto.CountryDto;
import org.example.dto.CountryLanguageDto;
import org.example.service.CountryLanguageService;
import org.example.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    private final CountryService countryService;

    private final CountryLanguageService countryLanguageService;

    public CountryController(CountryService countryService,
                             CountryLanguageService countryLanguageService) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countries = countryService.getAllCountriesOrdered();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{countryCode2}/languages")
    public ResponseEntity<List<CountryLanguageDto>> getLanguagesByCountry(@PathVariable String countryCode2) {
        List<CountryLanguageDto> languages = countryLanguageService.getLanguagesByCountryCode(countryCode2);
        if (languages.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(languages);
    }

}