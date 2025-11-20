package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Categorias;
import AutaZa.AutaZa.repository.CategoriasRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriasService {
    
    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> findAll() {
        return categoriasRepository.findAll();
    }

    public Categorias findById(Integer idCategorias) {
        return categoriasRepository.findById(idCategorias).orElse(null);
    }

    public Categorias save(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    public void deleteById(Integer idCategorias){
        categoriasRepository.deleteById(idCategorias);
    }
}
