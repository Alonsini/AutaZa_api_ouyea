package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Comuna;
import AutaZa.AutaZa.repository.ComunaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    public Comuna findById(Integer idComuna){
        return comunaRepository.findById(idComuna).orElse(null);
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public Comuna partialUpdate(Comuna comuna){
        Comuna existing = comunaRepository.findById(comuna.getIdComuna()).orElse(null);

        if(existing != null){

            if(comuna.getNombreComuna() != null)
                existing.setNombreComuna(comuna.getNombreComuna());

            if(comuna.getRegion() != null)
                existing.setRegion(comuna.getRegion());

            return comunaRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idComuna){
        comunaRepository.deleteById(idComuna);
    }
}


