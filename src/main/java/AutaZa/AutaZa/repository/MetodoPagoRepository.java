package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer>{

    List<MetodoPago> findByIdMetodoPago(Integer idMetodoPago);

    List<MetodoPago> findByNombreMetodoPago(String nombreMetodoPago);
}
