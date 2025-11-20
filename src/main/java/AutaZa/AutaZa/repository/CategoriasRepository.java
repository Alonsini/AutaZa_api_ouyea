package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer>{

    List<Categorias> findByIdCategorias(String idCategorias);

}
