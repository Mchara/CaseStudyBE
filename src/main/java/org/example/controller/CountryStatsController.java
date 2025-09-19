package org.example.controller;

import org.example.dto.ContinentRegionStatDto;
import org.example.dto.CountryStatsDto;
import org.example.service.CountryStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/country-stats")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryStatsController {

    private final CountryStatsService countryStatsService;

    public CountryStatsController(CountryStatsService countryStatsService) {
        this.countryStatsService = countryStatsService;
    }

    @GetMapping("/gdp")
    public ResponseEntity<List<CountryStatsDto>> getMaxGdpPerPopulation() {
        try {
            List<CountryStatsDto> stats = countryStatsService.getMaxGdpPerPopulation();
            if (stats.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<ContinentRegionStatDto>> getFilteredStats(
            @RequestParam(required = false) List<Long> regionIds,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearTo
    ) {
        List<ContinentRegionStatDto> stats = countryStatsService.getFilteredStats(regionIds, yearFrom, yearTo);
        return ResponseEntity.ok(stats);
    }


}