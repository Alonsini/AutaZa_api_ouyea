package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    List<Usuario> findByIdUsuario(Integer idUsuario);

    List<Usuario> findByNombreUsuario(String nombreUsuario);

    List<Usuario> findByCorreoUsuario(String emailUsuario);

    List<Usuario> findByRol(String idRol);

}
