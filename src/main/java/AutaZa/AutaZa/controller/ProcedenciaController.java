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

import AutaZa.AutaZa.model.Procedencia;
import AutaZa.AutaZa.service.ProcedenciaService;

@RestController
@RequestMapping("/api/v1/procedencia")
public class ProcedenciaController {

    @Autowired
    private ProcedenciaService procedenciaService;

    @GetMapping
    public ResponseEntity<List<Procedencia>> getAllProcedencia() {
        List<Procedencia> procedencia = procedenciaService.findAll();

        if (procedencia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(procedencia);
    }

    @GetMapping("/{idProcedencia}")
    public ResponseEntity<Procedencia> getProcedenciaById(@PathVariable Integer idProcedencia) {
        Procedencia procedencia = procedenciaService.findById(idProcedencia);

        if (procedencia == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(procedencia);
    }

    @PostMapping
    public ResponseEntity<Procedencia> createProcedencia(@RequestBody Procedencia procedencia) {
        procedencia.setIdProcedencia(null);
        Procedencia newProcedencia = procedenciaService.save(procedencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProcedencia);
    }

    @PutMapping("/{idProcedencia}")
    public ResponseEntity<Procedencia> updateProcedencia(@PathVariable Integer idProcedencia,
            @RequestBody Procedencia procedencia) {
        procedencia.setIdProcedencia(idProcedencia);
        Procedencia updated = procedenciaService.save(procedencia);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idProcedencia}")
    public ResponseEntity<Void> deleteProcedencia(@PathVariable Integer idProcedencia) {
        procedenciaService.deleteById(idProcedencia);
        return ResponseEntity.noContent().build();
    }
}
