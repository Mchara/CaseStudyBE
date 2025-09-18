package org.example.repository;

import org.example.dto.CountryDto;
import org.example.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    @Query("SELECT new org.example.dto.CountryDto(c.name, c.area, c.countryCode2) FROM Country c ORDER BY c.name")
    List<CountryDto> findAllAsDtoOrdered();

}
