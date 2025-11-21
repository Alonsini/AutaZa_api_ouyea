package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Usuario;
import AutaZa.AutaZa.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer idUsuario) {
        List<Usuario> list = usuarioRepository.findByIdUsuario(idUsuario);
        if (!list.isEmpty()) {
            Usuario u = list.get(0);
            u.setContrasena(null); 
            return u;
        }
        return null;
    }

    public Usuario login(Usuario usuario) {

        List<Usuario> list = usuarioRepository.findByCorreoUsuario(usuario.getCorreoUsuario());

        if (list.isEmpty()) {
            return null;
        }

        Usuario foundUsuario = list.get(0);

        if (passwordEncoder.matches(usuario.getContrasena(), foundUsuario.getContrasena())) {
            foundUsuario.setContrasena(null); 
            return foundUsuario;
        }

        return null;
    }

    public Usuario save(Usuario usuario) {
        String hashed = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(hashed);
        return usuarioRepository.save(usuario);
    }

    public Usuario partialUpdate(Usuario usuario) {

        List<Usuario> list = usuarioRepository.findByIdUsuario(usuario.getIdUsuario());
        if (list.isEmpty()) {
            return null;
        }

        Usuario existing = list.get(0);

        if (usuario.getNombreUsuario() != null) {
            existing.setNombreUsuario(usuario.getNombreUsuario());
        }

        if (usuario.getCorreoUsuario() != null) {
            existing.setCorreoUsuario(usuario.getCorreoUsuario());
        }

        if (usuario.getContrasena() != null) {
            existing.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        }

        if (usuario.getIdRol() != null) {
            existing.setIdRol(usuario.getIdRol());
        }

        if (usuario.getIdDirecciones() != null) {
            existing.setIdDirecciones(usuario.getIdDirecciones());
        }

        return usuarioRepository.save(existing);
    }


    public void deleteById(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}

