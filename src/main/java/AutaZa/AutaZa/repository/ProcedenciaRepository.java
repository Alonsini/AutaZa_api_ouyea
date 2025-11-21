package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Procedencia;

@Repository
public interface ProcedenciaRepository extends JpaRepository<Procedencia, Integer>{

    List<Procedencia> findByIdProcedencia(Integer idProcedencia);

    List<Procedencia> findByPais(String pais);
}
