package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Imagen;
import AutaZa.AutaZa.repository.ImagenRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Imagen findById(Integer idImagen) {
        return imagenRepository.findById(idImagen).orElse(null);
    }

    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen partialUpdate(Imagen imagen){
        Imagen existing = imagenRepository.findById(imagen.getIdImagen()).orElse(null);

        if(existing != null){

            if(imagen.getUrl() != null)
                existing.setUrl(imagen.getUrl());

            if(imagen.getDescripcion() != null)
                existing.setDescripcion(imagen.getDescripcion());

            return imagenRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idImagen){
        imagenRepository.deleteById(idImagen);
    }
}

