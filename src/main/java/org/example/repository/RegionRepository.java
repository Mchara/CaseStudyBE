package org.example.repository;

import org.example.entity.Region;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
}
