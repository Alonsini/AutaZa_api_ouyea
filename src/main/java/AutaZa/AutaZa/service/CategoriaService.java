package AutaZa.AutaZa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Categoria;
import AutaZa.AutaZa.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria partialUpdate(Categoria categoria){
        Categoria existing = categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
        if (existing != null) {

            if(categoria.getNombre() != null)
                existing.setNombre(categoria.getNombre());

            if (categoria.getDescripcion()!=null) 
                existing.setDescripcion(categoria.getDescripcion());
                
            return categoriaRepository.save(existing);
            
        }
         return null;
    }
    public void deleteById(Integer idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }
}
