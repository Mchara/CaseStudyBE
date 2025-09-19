package org.example.repository;

import org.example.dto.CountryStatsDto;
import org.example.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryStatsRepository extends JpaRepository<CountryStat, Integer> {

    @Query("SELECT new org.example.dto.CountryStatsDto(" +
            "c.name, c.countryCode3, cs.year, cs.population, cs.gdp) " +
            "FROM CountryStat cs " +
            "JOIN cs.country c " +
            "WHERE (1.0 * cs.gdp / cs.population) = (" +
            "   SELECT MAX(1.0 * cs2.gdp / cs2.population) " +
            "   FROM CountryStat cs2 " +
            "   WHERE cs2.country = cs.country" +
            ")")
    List<CountryStatsDto> findMaxGdpPerPopulation();
}
