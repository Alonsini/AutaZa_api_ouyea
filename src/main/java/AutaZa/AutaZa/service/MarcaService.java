package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Marca;
import AutaZa.AutaZa.repository.MarcaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca findById(Integer idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Integer idMarca){
        marcaRepository.deleteById(idMarca);
    }
}
