package org.example.controller;

import org.example.dto.RegionDto;
import org.example.service.RegionService;
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

class RegionControllerTest {

    @Mock
    private RegionService regionService;

    @InjectMocks
    private RegionController regionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRegions_ReturnsRegions() {
        List<RegionDto> mockRegions = Arrays.asList(
                new RegionDto(1L, "Caribbean"),
                new RegionDto(2L, "Southern and Central Asia")
        );
        when(regionService.getAllRegions()).thenReturn(mockRegions);

        ResponseEntity<List<RegionDto>> response = regionController.getAllRegions();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(regionService, times(1)).getAllRegions();
    }

    @Test
    void testGetAllRegions_ReturnsNoContent() {
        when(regionService.getAllRegions()).thenReturn(Collections.emptyList());
        ResponseEntity<List<RegionDto>> response = regionController.getAllRegions();

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(regionService, times(1)).getAllRegions();
    }
}
