package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    List<Categoria> findByIdCategoria(Integer idCategoria);

    List<Categoria> findByNombreCategoria(String nombreCategoria);

}
