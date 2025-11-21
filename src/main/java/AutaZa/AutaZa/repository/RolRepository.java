package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

    List<Rol> findByIdRol(Integer idRol);

    List<Rol> findByNombreRol(String nombreRol);
}
