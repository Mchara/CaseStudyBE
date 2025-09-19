package org.example.repository;

import org.example.dto.ContinentRegionStatDto;
import org.example.dto.CountryStatsDto;
import org.example.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT new org.example.dto.ContinentRegionStatDto(" +
            "co.name, r.name, c.name, cs.year, cs.population, cs.gdp) " +
            "FROM CountryStat cs " +
            "JOIN cs.country c " +
            "JOIN c.region r " +
            "JOIN r.continent co " +
            "WHERE (:regionIds IS NULL OR r.id IN :regionIds) " +
            "AND (:yearFrom IS NULL OR cs.year >= :yearFrom) " +
            "AND (:yearTo IS NULL OR cs.year <= :yearTo) " +
            "ORDER BY co.name, r.name, c.name, cs.year")
    List<ContinentRegionStatDto> findFilteredStats(
            @Param("regionIds") List<Long> regionIds,
            @Param("yearFrom") Integer yearFrom,
            @Param("yearTo") Integer yearTo
    );
}
