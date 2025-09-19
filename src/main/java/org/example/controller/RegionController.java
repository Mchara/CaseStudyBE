package org.example.controller;


import org.example.dto.RegionDto;
import org.example.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<RegionDto>> getAllRegions() {
        List<RegionDto> regions = regionService.getAllRegions();

        if (regions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(regions);
    }
}
