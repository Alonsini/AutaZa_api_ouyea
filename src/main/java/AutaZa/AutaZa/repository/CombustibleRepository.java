package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Combustible;

@Repository
public interface CombustibleRepository extends JpaRepository<Combustible, Integer>{

    List<Combustible> findByIdCombustible(Integer idCombustible);

    List<Combustible> findByTipoCombustible(String tipoCombustible);
}
