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

import AutaZa.AutaZa.model.Transmision;
import AutaZa.AutaZa.service.TransmisionService;

@RestController
@RequestMapping("/api/v1/transmision")
public class TransmisionController {

    @Autowired
    private TransmisionService transmisionService;

    @GetMapping
    public ResponseEntity<List<Transmision>> getAllTransmision() {
        List<Transmision> transmision = transmisionService.findAll();

        if (transmision.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(transmision);
    }

    @GetMapping("/{idTransmision}")
    public ResponseEntity<Transmision> getTransmisionById(@PathVariable Integer idTransmision) {
        Transmision transmision = transmisionService.findById(idTransmision);

        if (transmision == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transmision);
    }

    @PostMapping
    public ResponseEntity<Transmision> createTransmision(@RequestBody Transmision transmision) {
        transmision.setIdTransmision(null);
        Transmision newTransmision = transmisionService.save(transmision);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransmision);
    }

    @PutMapping("/{idTransmision}")
    public ResponseEntity<Transmision> updateTransmision(@PathVariable Integer idTransmision,
            @RequestBody Transmision transmision) {
        transmision.setIdTransmision(idTransmision);
        Transmision updated = transmisionService.save(transmision);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idTransmision}")
    public ResponseEntity<Void> deleteTransmision(@PathVariable Integer idTransmision) {
        transmisionService.deleteById(idTransmision);
        return ResponseEntity.noContent().build();
    }
}
