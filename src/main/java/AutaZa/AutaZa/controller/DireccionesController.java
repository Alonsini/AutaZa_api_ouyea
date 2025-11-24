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

import AutaZa.AutaZa.model.Direcciones;
import AutaZa.AutaZa.service.DireccionesService;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionesController {

    @Autowired
    private DireccionesService direccionesService;

    @GetMapping
    public ResponseEntity<List<Direcciones>> getAllDirecciones() {
        List<Direcciones> direcciones = direccionesService.findAll();

        if (direcciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direcciones> getDireccionesById(@PathVariable Integer idDirecciones) {
        Direcciones direcciones = direccionesService.findById(idDirecciones);

        if (direcciones == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(direcciones);
    }

    @PostMapping
    public ResponseEntity<Direcciones> createDirecciones(@RequestBody Direcciones direcciones) {
        direcciones.setIdDirecciones(null);
        Direcciones newDirecciones = direccionesService.save(direcciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDirecciones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direcciones> updateDirecciones(@PathVariable Integer idDirecciones,
            @RequestBody Direcciones direcciones) {
        direcciones.setIdDirecciones(idDirecciones);
        Direcciones updated = direccionesService.save(direcciones);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direcciones> partialUpdateDirecciones(@PathVariable Integer idDirecciones,
            @RequestBody Direcciones direcciones) {
        direcciones.setIdDirecciones(idDirecciones);
        Direcciones updated = direccionesService.partialUpdate(direcciones);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirecciones(@PathVariable Integer idDirecciones) {
        direccionesService.deleteById(idDirecciones);
        return ResponseEntity.noContent().build();
    }
}
