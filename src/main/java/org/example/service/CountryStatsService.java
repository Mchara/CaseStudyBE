package org.example.service;

import org.example.dto.ContinentRegionStatDto;
import org.example.dto.CountryStatsDto;
import org.example.repository.CountryStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryStatsService {

    private final CountryStatsRepository countryStatsRepository;

    public CountryStatsService(CountryStatsRepository countryStatsRepository) {
        this.countryStatsRepository = countryStatsRepository;
    }

    public List<CountryStatsDto> getMaxGdpPerPopulation() {
        return countryStatsRepository.findMaxGdpPerPopulation();
    }
    public List<ContinentRegionStatDto> getFilteredStats(Long regionId,
                                                         Integer yearFrom,
                                                         Integer yearTo) {
        return countryStatsRepository.findFilteredStats(regionId, yearFrom, yearTo);
    }
}