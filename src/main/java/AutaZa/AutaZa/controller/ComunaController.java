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

import AutaZa.AutaZa.model.Comuna;
import AutaZa.AutaZa.service.ComunaService;

@RestController
@RequestMapping("/api/v1/comuna")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> getAllComuna() {
        List<Comuna> comuna = comunaService.findAll();

        if (comuna.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(comuna);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> getComunaById(@PathVariable Integer idComuna) {
        Comuna comuna = comunaService.findById(idComuna);

        if (comuna == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(comuna);
    }

    @PostMapping
    public ResponseEntity<Comuna> createComuna(@RequestBody Comuna comuna) {
        comuna.setIdComuna(null);
        Comuna newComuna = comunaService.save(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> updateComuna(@PathVariable Integer idComuna,
            @RequestBody Comuna comuna) {
        comuna.setIdComuna(idComuna);
        Comuna updated = comunaService.save(comuna);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comuna> partialUpdateComuna(@PathVariable Integer idComuna,
            @RequestBody Comuna comuna) {
        comuna.setIdComuna(idComuna);
        Comuna updated = comunaService.partialUpdate(comuna);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComuna(@PathVariable Integer idComuna) {
        comunaService.deleteById(idComuna);
        return ResponseEntity.noContent().build();
    }
}
