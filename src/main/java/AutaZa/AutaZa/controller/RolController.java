package AutaZa.AutaZa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AutaZa.AutaZa.model.Rol;
import AutaZa.AutaZa.service.RolService;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRol() {
        List<Rol> rol = rolService.findAll();

        if (rol.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rol);
    }

    @GetMapping("/{idRol}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer idRol) {
        Rol rol = rolService.findById(idRol);

        if (rol == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        rol.setIdRol(null);
        Rol newRol = rolService.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRol);
    }

    @PutMapping("/{idRol}")
    public ResponseEntity<Rol> updateRol(@PathVariable Integer idRol,
            @RequestBody Rol rol) {
        rol.setIdRol(idRol);
        Rol updated = rolService.save(rol);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idRol}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer idRol) {
        rolService.deleteById(idRol);
        return ResponseEntity.noContent().build();
    }
}
