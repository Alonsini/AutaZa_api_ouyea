package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Colores;
import AutaZa.AutaZa.repository.ColoresRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColoresService {

    @Autowired
    private ColoresRepository coloresRepository;

    public List<Colores>findAll(){
        return coloresRepository.findAll();
    }

    public Colores findById(Integer IdColores){
        return coloresRepository.findById(IdColores).orElse(null);
    }

    public Colores save(Colores colores){
        return coloresRepository.save(colores);
    }

    public void deleteById(Integer IdColores){
        coloresRepository.deleteById(IdColores);
    }
}
