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

import AutaZa.AutaZa.model.Imagen;
import AutaZa.AutaZa.service.ImagenService;

@RestController
@RequestMapping("/autaza_api/v1/imagen")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<Imagen>> getAllImagen() {
        List<Imagen> imagen = imagenService.findAll();

        if (imagen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(imagen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> getImagenById(@PathVariable Integer idImagen) {
        Imagen imagen = imagenService.findById(idImagen);

        if (imagen == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(imagen);
    }

    @PostMapping
    public ResponseEntity<Imagen> createImagen(@RequestBody Imagen imagen) {
        imagen.setIdImagen(null);
        Imagen newImagen = imagenService.save(imagen);
        return ResponseEntity.status(HttpStatus.CREATED).body(newImagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> updateImagen(@PathVariable Integer idImagen,
            @RequestBody Imagen imagen) {
        imagen.setIdImagen(idImagen);
        Imagen updated = imagenService.save(imagen);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imagen> partialUpdateImagen(@PathVariable Integer idImagen,
            @RequestBody Imagen imagen) {
        imagen.setIdImagen(idImagen);
        Imagen updated = imagenService.partialUpdate(imagen);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Integer idImagen) {
        imagenService.deleteById(idImagen);
        return ResponseEntity.noContent().build();
    }
}
