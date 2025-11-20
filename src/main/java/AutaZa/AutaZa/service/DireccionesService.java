package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Direcciones;
import AutaZa.AutaZa.repository.DireccionesRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionesService {

    @Autowired
    private DireccionesRepository direccionesRepository;

    public List<Direcciones> findAll(){
        return direccionesRepository.findAll();
    }

    public Direcciones findById(Integer idDirecciones) {
        return direccionesRepository.findById(idDirecciones).orElse(null);
    }

    public Direcciones save(Direcciones direcciones) {
        return direccionesRepository.save(direcciones);
    }

    public Direcciones partialUpdate(Direcciones direcciones){
        Direcciones existing = direccionesRepository.findById(direcciones.getIdDirecciones()).orElse(null);

        if(existing != null){

            if(direcciones.getCalle() != null)
                existing.setCalle(direcciones.getCalle());

            if(direcciones.getNumero() != null)
                existing.setNumero(direcciones.getNumero());

            if(direcciones.getComuna() != null) 
                existing.setComuna(direcciones.getComuna());

            return direccionesRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idDirecciones){
        direccionesRepository.deleteById(idDirecciones);
    }
}
