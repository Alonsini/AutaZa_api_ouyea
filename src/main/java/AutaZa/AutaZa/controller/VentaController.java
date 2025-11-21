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

import AutaZa.AutaZa.model.Venta;
import AutaZa.AutaZa.service.VentaService;

@RestController
@RequestMapping("/autaza_api/v1/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVenta() {
        List<Venta> venta = ventaService.findAll();

        if (venta.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Integer idVenta) {
        Venta venta = ventaService.findById(idVenta);

        if (venta == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        venta.setIdVenta(null);
        Venta newVenta = ventaService.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer idVenta,
            @RequestBody Venta venta) {
        venta.setIdVenta(idVenta);
        Venta updated = ventaService.save(venta);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer idVenta) {
        ventaService.deleteById(idVenta);
        return ResponseEntity.noContent().build();
    }
}
