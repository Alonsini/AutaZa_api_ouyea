package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Direcciones;

@Repository
public interface DireccionesRepository extends JpaRepository<Direcciones, Integer>{

    List<Direcciones> findByIdDirecciones(Integer idDirecciones);

    List<Direcciones> findByCalle(String calle);
}
