package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

    List<Region> findByIdRegion(String idRegion);
}
