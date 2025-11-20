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

import AutaZa.AutaZa.model.Categorias;
import AutaZa.AutaZa.service.CategoriasService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<Categorias>> getAllCategorias() {
        List<Categorias> categorias = categoriasService.findAll();
        
        if (categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriasById(@PathVariable Integer idCategorias) {
        Categorias categoria = categoriasService.findById(idCategorias);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categorias> createCategorias(@RequestBody Categorias categorias) {
        categorias.setIdCategorias(null);
        Categorias newCategoria = categoriasService.save(categorias);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> updateCategorias(@PathVariable Integer idCategorias, @RequestBody Categorias categorias) {
        categorias.setIdCategorias(idCategorias);
        Categorias updated = categoriasService.save(categorias);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorias(@PathVariable Integer idCategorias) {
        categoriasService.deleteById(idCategorias);
        return ResponseEntity.noContent().build();
    }
    
    

}
