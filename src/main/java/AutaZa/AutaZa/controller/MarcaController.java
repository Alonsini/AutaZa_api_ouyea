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

import AutaZa.AutaZa.model.Marca;
import AutaZa.AutaZa.service.MarcaService;

@RestController
@RequestMapping("/autaza_api/v1/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarca() {
        List<Marca> marca = marcaService.findAll();

        if (marca.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(marca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Integer idMarca) {
        Marca marca = marcaService.findById(idMarca);

        if (marca == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
        marca.setIdMarca(null);
        Marca newMarca = marcaService.save(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Integer idMarca,
            @RequestBody Marca marca) {
        marca.setIdMarca(idMarca);
        Marca updated = marcaService.save(marca);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer idMarca) {
        marcaService.deleteById(idMarca);
        return ResponseEntity.noContent().build();
    }
}
