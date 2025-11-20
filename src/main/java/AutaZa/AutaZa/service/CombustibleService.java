package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Combustible;
import AutaZa.AutaZa.repository.CombustibleRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CombustibleService {

    @Autowired
    private CombustibleRepository combustibleRepository;

    public List<Combustible> findAll() {
        return combustibleRepository.findAll();
    }

    public Combustible findById(Integer idCombustible){
        return combustibleRepository.findById(idCombustible).orElse(null);
    }

    public Combustible save(Combustible combustible) {
        return combustibleRepository.save(combustible);
    }

    public Combustible partialUpdate(Combustible combustible){
        Combustible existing = combustibleRepository.findById(combustible.getIdCombustible()).orElse(null);

        if(existing != null){

            if(combustible.getTipoCombustible() != null)
                existing.setTipoCombustible(combustible.getTipoCombustible());

            return combustibleRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idCombustible){
        combustibleRepository.deleteById(idCombustible);
    }
}

