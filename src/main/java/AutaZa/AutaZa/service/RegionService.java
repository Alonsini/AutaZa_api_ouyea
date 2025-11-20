package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Region;
import AutaZa.AutaZa.repository.RegionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Integer idRegion) {
        return regionRepository.findById(idRegion).orElse(null);
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public void deleteById(Integer idRegion){
        regionRepository.deleteById(idRegion);
    }
}
