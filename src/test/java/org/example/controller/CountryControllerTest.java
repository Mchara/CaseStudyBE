package org.example.controller;

import org.example.dto.CountryDto;
import org.example.dto.CountryLanguageDto;
import org.example.service.CountryLanguageService;
import org.example.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CountryControllerTest {

    @Mock
    private CountryService countryService;

    @Mock
    private CountryLanguageService countryLanguageService;

    @InjectMocks
    private CountryController countryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCountries() {
        List<CountryDto> mockCountries = Arrays.asList(
                new CountryDto("Aruba",  193L,"AW"),
                new CountryDto("Austria", 83859L, "AT")
        );

        when(countryService.getAllCountriesOrdered()).thenReturn(mockCountries);

        ResponseEntity<List<CountryDto>> response = countryController.getAllCountries();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(countryService, times(1)).getAllCountriesOrdered();
    }

    @Test
    void testGetLanguagesByCountry_withLanguages() {
        String countryCode = "AW";
        List<CountryLanguageDto> mockLanguages = Arrays.asList(
                new CountryLanguageDto("Dutch", true),
                new CountryLanguageDto("English", false),
                new CountryLanguageDto("Papiamento",false)
        );

        when(countryLanguageService.getLanguagesByCountryCode(countryCode)).thenReturn(mockLanguages);

        ResponseEntity<List<CountryLanguageDto>> response = countryController.getLanguagesByCountry(countryCode);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(3, response.getBody().size());
        verify(countryLanguageService, times(1)).getLanguagesByCountryCode(countryCode);
    }

    @Test
    void testGetLanguagesByCountry_noLanguages() {
        String countryCode = "XX";

        when(countryLanguageService.getLanguagesByCountryCode(countryCode)).thenReturn(Collections.emptyList());

        ResponseEntity<List<CountryLanguageDto>> response = countryController.getLanguagesByCountry(countryCode);

        assertEquals(204, response.getStatusCodeValue());
        verify(countryLanguageService, times(1)).getLanguagesByCountryCode(countryCode);
    }
}