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

import AutaZa.AutaZa.model.MetodoEntrega;
import AutaZa.AutaZa.service.MetodoEntregaService;

@RestController
@RequestMapping("/api/v1/metodoEntrega")
public class MetodoEntregaController {

    @Autowired
    private MetodoEntregaService metodoEntregaService;

    @GetMapping
    public ResponseEntity<List<MetodoEntrega>> getAllMetodoEntrega() {
        List<MetodoEntrega> metodoEntrega = metodoEntregaService.findAll();

        if (metodoEntrega.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(metodoEntrega);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEntrega> getMetodoEntregaById(@PathVariable Integer idMetodoEntrega) {
        MetodoEntrega metodoEntrega = metodoEntregaService.findById(idMetodoEntrega);

        if (metodoEntrega == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(metodoEntrega);
    }

    @PostMapping
    public ResponseEntity<MetodoEntrega> createMetodoEntrega(@RequestBody MetodoEntrega metodoEntrega) {
        metodoEntrega.setIdMetodoEntrega(null);
        MetodoEntrega newMetodoEntrega = metodoEntregaService.save(metodoEntrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMetodoEntrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEntrega> updateMetodoEntrega(@PathVariable Integer idMetodoEntrega,
            @RequestBody MetodoEntrega metodoEntrega) {
        metodoEntrega.setIdMetodoEntrega(idMetodoEntrega);
        MetodoEntrega updated = metodoEntregaService.save(metodoEntrega);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoEntrega> partialUpdateMetodoEntrega(@PathVariable Integer idMetodoEntrega,
            @RequestBody MetodoEntrega metodoEntrega) {
        metodoEntrega.setIdMetodoEntrega(idMetodoEntrega);
        MetodoEntrega updated = metodoEntregaService.partialUpdate(metodoEntrega);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoEntrega(@PathVariable Integer idMetodoEntrega) {
        metodoEntregaService.deleteById(idMetodoEntrega);
        return ResponseEntity.noContent().build();
    }
}
