package org.example.repository;

import org.example.dto.CountryLanguageDto;
import org.example.entity.CountryLanguage;
import org.example.entity.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    @Query("SELECT new org.example.dto.CountryLanguageDto(l.language, cl.official) " +
            "FROM CountryLanguage cl " +
            "JOIN cl.language l " +
            "JOIN cl.country c " +
            "WHERE c.countryCode2 = :countryCode2")
    List<CountryLanguageDto> findLanguagesByCountryCode(@Param("countryCode2") String countryCode2);
}





