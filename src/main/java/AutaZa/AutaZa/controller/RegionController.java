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

import AutaZa.AutaZa.model.Region;
import AutaZa.AutaZa.service.RegionService;

@RestController
@RequestMapping("/autaza_api/v1/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegion() {
        List<Region> region = regionService.findAll();

        if (region.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(region);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Integer idRegion) {
        Region region = regionService.findById(idRegion);

        if (region == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        region.setIdRegion(null);
        Region newRegion = regionService.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRegion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Integer idRegion,
            @RequestBody Region region) {
        region.setIdRegion(idRegion);
        Region updated = regionService.save(region);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer idRegion) {
        regionService.deleteById(idRegion);
        return ResponseEntity.noContent().build();
    }
}
