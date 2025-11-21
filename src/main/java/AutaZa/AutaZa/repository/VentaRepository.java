package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

    List<Venta> findByIdVenta(Integer idVenta);
}
