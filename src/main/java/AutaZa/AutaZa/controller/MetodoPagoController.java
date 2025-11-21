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

import AutaZa.AutaZa.model.MetodoPago;
import AutaZa.AutaZa.service.MetodoPagoService;

@RestController
@RequestMapping("/autaza_api/v1/metodoPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAllMetodoPago() {
        List<MetodoPago> metodoPago = metodoPagoService.findAll();

        if (metodoPago.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(metodoPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable Integer idMetodoPago) {
        MetodoPago metodoPago = metodoPagoService.findById(idMetodoPago);

        if (metodoPago == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(metodoPago);
    }

    @PostMapping
    public ResponseEntity<MetodoPago> createMetodoPago(@RequestBody MetodoPago metodoPago) {
        metodoPago.setIdMetodoPago(null);
        MetodoPago newMetodoPago = metodoPagoService.save(metodoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMetodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateMetodoPago(@PathVariable Integer idMetodoPago,
            @RequestBody MetodoPago metodoPago) {
        metodoPago.setIdMetodoPago(idMetodoPago);
        MetodoPago updated = metodoPagoService.save(metodoPago);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer idMetodoPago) {
        metodoPagoService.deleteById(idMetodoPago);
        return ResponseEntity.noContent().build();
    }
}
