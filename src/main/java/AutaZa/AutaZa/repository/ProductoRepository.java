package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    List<Producto> findByIdProducto(Integer idProducto);

    List<Producto> findByNombreProducto(String nombreProducto);

    List<Producto> findByCategorias_IdCategorias(Integer idCategorias);
}
