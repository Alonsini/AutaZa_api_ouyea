package AutaZa.AutaZa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AutaZa.AutaZa.model.Usuario;
import AutaZa.AutaZa.service.UsuarioService;

@RestController
@RequestMapping("/autaza_api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        List<Usuario> usuario = usuarioService.findAll();

        if (usuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        usuario.setIdUsuario(null);
        Usuario newUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer idUsuario,
            @RequestBody Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        Usuario updated = usuarioService.save(usuario);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> partialUpdateUsuario(@PathVariable Integer idUsuario,
            @RequestBody Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        Usuario updated = usuarioService.partialUpdate(usuario);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer idUsuario) {
        usuarioService.deleteById(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
