package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Colores;

@Repository
public interface ColoresRepository extends JpaRepository<Colores, Integer>{

    List<Colores> findByIdColores(Integer idColores);
}
