package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{

    List<Color> findByIdColor(String idColor);

    List<Color> findByNombreColor(String nombreColor);
}
