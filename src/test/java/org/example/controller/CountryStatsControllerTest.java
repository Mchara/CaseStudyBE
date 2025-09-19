package org.example.controller;

import org.example.dto.ContinentRegionStatDto;
import org.example.dto.CountryStatsDto;
import org.example.service.CountryStatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CountryStatsControllerTest {

    @Mock
    private CountryStatsService countryStatsService;

    @InjectMocks
    private CountryStatsController countryStatsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetMaxGdpPerPopulation_ReturnsStats() {
        List<CountryStatsDto> mockStats = Arrays.asList(
                new CountryStatsDto("Aruba", "ABW", 2008, 101358, 2745251397L),
                new CountryStatsDto("Afghanistan", "AFG", 2012, 31161376, 20001615789L)
        );
        when(countryStatsService.getMaxGdpPerPopulation()).thenReturn(mockStats);

        ResponseEntity<List<CountryStatsDto>> response = countryStatsController.getMaxGdpPerPopulation();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(countryStatsService, times(1)).getMaxGdpPerPopulation();
    }

    @Test
    void testGetMaxGdpPerPopulation_ReturnsNoContent() {
        when(countryStatsService.getMaxGdpPerPopulation()).thenReturn(Collections.emptyList());

        ResponseEntity<List<CountryStatsDto>> response = countryStatsController.getMaxGdpPerPopulation();

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(countryStatsService, times(1)).getMaxGdpPerPopulation();
    }

    @Test
    void testGetMaxGdpPerPopulation_ExceptionHandling() {
        when(countryStatsService.getMaxGdpPerPopulation()).thenThrow(new RuntimeException("DB error"));

        ResponseEntity<List<CountryStatsDto>> response = countryStatsController.getMaxGdpPerPopulation();

        assertEquals(500, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
        verify(countryStatsService, times(1)).getMaxGdpPerPopulation();
    }


    @Test
    void testGetFilteredStats_ReturnsStats() {
        List<ContinentRegionStatDto> mockStats = Arrays.asList(
                new ContinentRegionStatDto("Europe", "Western Europe", "Germany", 1970, 78169289, 215022000000L),
                new ContinentRegionStatDto("Asia", "Middle East", "Armenia", 1990, 3538171, 2256838858L)
        );
        when(countryStatsService.getFilteredStats(Arrays.asList(1L, 2L), 1970, 1991)).thenReturn(mockStats);

        ResponseEntity<List<ContinentRegionStatDto>> response = countryStatsController.getFilteredStats(
                Arrays.asList(1L, 2L), 1970, 1991
        );

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(countryStatsService, times(1)).getFilteredStats(Arrays.asList(1L, 2L), 1970, 1991);
    }

    @Test
    void testGetFilteredStats_ReturnsNoContent() {
        when(countryStatsService.getFilteredStats(null, null, null)).thenReturn(Collections.emptyList());

        ResponseEntity<List<ContinentRegionStatDto>> response = countryStatsController.getFilteredStats(null, null, null);

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(countryStatsService, times(1)).getFilteredStats(null, null, null);
    }
}
