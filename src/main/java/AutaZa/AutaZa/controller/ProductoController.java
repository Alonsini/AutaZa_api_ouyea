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

import AutaZa.AutaZa.model.Producto;
import AutaZa.AutaZa.service.ProductoService;

@RestController
@RequestMapping("/api/color")
public class ProductoController {

    @Autowired
    private ProductoService colorService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto() {
        List<Producto> color = colorService.findAll();

        if (color.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(color);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer idProducto) {
        Producto color = colorService.findById(idProducto);

        if (color == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(color);
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto color) {
        color.setIdProducto(null);
        Producto newProducto = colorService.save(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer idProducto,
            @RequestBody Producto color) {
        color.setIdProducto(idProducto);
        Producto updated = colorService.save(color);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer idProducto) {
        colorService.deleteById(idProducto);
        return ResponseEntity.noContent().build();
    }
}
