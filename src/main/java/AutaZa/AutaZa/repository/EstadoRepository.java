package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

    List<Estado> findByIdEstado(Integer idEstado);

    List<Estado> findByNombreEstado(String nombreEstado);
}
