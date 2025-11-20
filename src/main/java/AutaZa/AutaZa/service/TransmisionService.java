package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Transmision;
import AutaZa.AutaZa.repository.TransmisionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransmisionService {

    @Autowired
    private TransmisionRepository transmisionRepository;

    public List<Transmision> findAll() {
        return transmisionRepository.findAll();
    }

    public Transmision findById(Integer idTransmision) {
        return transmisionRepository.findById(idTransmision).orElse(null);
    }

    public Transmision save(Transmision transmision) {
        return transmisionRepository.save(transmision);
    }

    public void deleteById(Integer idTransmision){
        transmisionRepository.deleteById(idTransmision);
    }
}
