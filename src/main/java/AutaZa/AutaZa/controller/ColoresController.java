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

import AutaZa.AutaZa.model.Colores;
import AutaZa.AutaZa.service.ColoresService;

@RestController
@RequestMapping("/api/colores")
public class ColoresController {

    @Autowired
    private ColoresService coloresService;

    @GetMapping
    public ResponseEntity<List<Colores>> getAllColores() {
        List<Colores> colores = coloresService.findAll();
        
        if (colores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(colores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colores> getColoresById(@PathVariable Integer idColores) {
        Colores colores = coloresService.findById(idColores);

        if (colores == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(colores);
    }

    @PostMapping
    public ResponseEntity<Colores> createColores(@RequestBody Colores colores) {
        colores.setIdColores(null);
        Colores newColores = coloresService.save(colores);
        return ResponseEntity.status(HttpStatus.CREATED).body(newColores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colores> updateColores(@PathVariable Integer idColores, @RequestBody Colores colores) {
        colores.setIdColores(idColores);
        Colores updated = coloresService.save(colores);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColores(@PathVariable Integer idColores) {
        coloresService.deleteById(idColores);
        return ResponseEntity.noContent().build();
    }
    
    

}