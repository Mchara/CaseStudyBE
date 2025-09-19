package org.example.service;

import org.example.dto.RegionDto;
import org.example.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<RegionDto> getAllRegions() {
        return regionRepository.findAll()
                .stream()
                .map(region -> new RegionDto(region.getId(), region.getName()))
                .collect(Collectors.toList());
    }
}
