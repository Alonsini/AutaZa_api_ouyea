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

import AutaZa.AutaZa.model.Combustible;
import AutaZa.AutaZa.service.CombustibleService;

@RestController
@RequestMapping("/api/v1/combustible")
public class CombustibleController {

    @Autowired
    private CombustibleService combustibleService;

    @GetMapping
    public ResponseEntity<List<Combustible>> getAllCombustible() {
        List<Combustible> combustible = combustibleService.findAll();

        if (combustible.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(combustible);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combustible> getCombustibleById(@PathVariable Integer idCombustible) {
        Combustible combustible = combustibleService.findById(idCombustible);

        if (combustible == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(combustible);
    }

    @PostMapping
    public ResponseEntity<Combustible> createCombustible(@RequestBody Combustible combustible) {
        combustible.setIdCombustible(null);
        Combustible newCombustible = combustibleService.save(combustible);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCombustible);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combustible> updateCombustible(@PathVariable Integer idCombustible,
            @RequestBody Combustible combustible) {
        combustible.setIdCombustible(idCombustible);
        Combustible updated = combustibleService.save(combustible);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Combustible> partialUpdateCombustible(@PathVariable Integer idCombustible,
            @RequestBody Combustible combustible) {
        combustible.setIdCombustible(idCombustible);
        Combustible updated = combustibleService.partialUpdate(combustible);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombustible(@PathVariable Integer idCombustible) {
        combustibleService.deleteById(idCombustible);
        return ResponseEntity.noContent().build();
    }
}
