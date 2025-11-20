package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.MetodoEntrega;

@Repository
public interface MetodoEntregaRepository extends JpaRepository<MetodoEntrega, Integer>{

    List<MetodoEntrega> findByIdMetodoEntrega(String idMetodoEntrega);

    List<MetodoEntrega> findByNombreMetodoEntrega(String nombreMetodoEntrega);
}
