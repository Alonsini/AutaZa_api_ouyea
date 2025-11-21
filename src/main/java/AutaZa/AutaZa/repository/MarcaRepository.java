package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

    List<Marca> findByIdMarca(Integer idMarca);

    List<Marca> findByNombreMarca(String nombreMarca);
}
