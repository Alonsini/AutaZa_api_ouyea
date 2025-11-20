package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{

    List<Imagen> findByIdImagen(String idImagen);
}
