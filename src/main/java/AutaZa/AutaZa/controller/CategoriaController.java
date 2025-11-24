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

import AutaZa.AutaZa.model.Categoria;
import AutaZa.AutaZa.service.CategoriaService;


@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        List<Categoria> categoria = categoriaService.findAll();
        
        if (categoria.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer idCategoria) {
        Categoria categoria = categoriaService.findById(idCategoria);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }


    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        categoria.setIdCategoria(null);
        Categoria newCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategoria);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer idCategoria, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(idCategoria);
        Categoria updated = categoriaService.save(categoria);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> partialUpdateCategoria(@PathVariable Integer idCategoria, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(idCategoria);
        Categoria updated = categoriaService.partialUpdate(categoria);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer idCategoria) {
        categoriaService.deleteById(idCategoria);
        return ResponseEntity.noContent().build();
    }
}
