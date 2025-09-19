package org.example.service;

import org.example.dto.RegionDto;
import org.example.entity.Region;
import org.example.repository.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegionServiceTest {

    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionService regionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRegions_ReturnsMappedDtos() {
        Region region1 = new Region();
        region1.setId(1L);
        region1.setName("Caribbean");

        Region region2 = new Region();
        region2.setId(2L);
        region2.setName("Southern and Central Asia");

        when(regionRepository.findAll()).thenReturn(Arrays.asList(region1, region2));

        List<RegionDto> result = regionService.getAllRegions();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Caribbean", result.get(0).getName());
        assertEquals("Southern and Central Asia", result.get(1).getName());

        verify(regionRepository, times(1)).findAll();
    }


    @Test
    void testGetAllRegions_ReturnsEmptyList() {
        when(regionRepository.findAll()).thenReturn(Collections.emptyList());

        List<RegionDto> result = regionService.getAllRegions();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(regionRepository, times(1)).findAll();
    }
}
