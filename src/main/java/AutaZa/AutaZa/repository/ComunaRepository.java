package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer>{

    List<Comuna> findByIdComuna(String idComuna);

    List<Comuna> findByIdRegion(String idRegion);

    List<Comuna> findByNombreComuna(String nombreComuna);
}
