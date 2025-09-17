package org.example.repository;

import org.example.entity.Continent;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long>{
}
