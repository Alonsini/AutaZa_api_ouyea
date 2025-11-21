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

import AutaZa.AutaZa.model.Estado;
import AutaZa.AutaZa.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstado() {
        List<Estado> estado = estadoService.findAll();

        if (estado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(estado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Integer idEstado) {
        Estado estado = estadoService.findById(idEstado);

        if (estado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        estado.setIdEstado(null);
        Estado newEstado = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEstado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Integer idEstado,
            @RequestBody Estado estado) {
        estado.setIdEstado(idEstado);
        Estado updated = estadoService.save(estado);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estado> partialUpdateEstado(@PathVariable Integer idEstado,
            @RequestBody Estado estado) {
        estado.setIdEstado(idEstado);
        Estado updated = estadoService.partialUpdate(estado);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer idEstado) {
        estadoService.deleteById(idEstado);
        return ResponseEntity.noContent().build();
    }
}
