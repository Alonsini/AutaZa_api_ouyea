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

import AutaZa.AutaZa.model.Color;
import AutaZa.AutaZa.service.ColorService;

@RestController
@RequestMapping("/autaza_api/v1/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public ResponseEntity<List<Color>> getAllColor() {
        List<Color> color = colorService.findAll();

        if (color.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(color);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable Integer idColor) {
        Color color = colorService.findById(idColor);

        if (color == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(color);
    }

    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody Color color) {
        color.setIdColor(null);
        Color newColor = colorService.save(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(newColor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Integer idColor,
            @RequestBody Color color) {
        color.setIdColor(idColor);
        Color updated = colorService.save(color);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Color> partialUpdateColor(@PathVariable Integer idColor,
            @RequestBody Color color) {
        color.setIdColor(idColor);
        Color updated = colorService.partialUpdate(color);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Integer idColor) {
        colorService.deleteById(idColor);
        return ResponseEntity.noContent().build();
    }
}
