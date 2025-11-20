package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Estado;
import AutaZa.AutaZa.repository.EstadoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(Integer idEstado) {
        return estadoRepository.findById(idEstado).orElse(null);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado partialUpdate(Estado estado){
        Estado existing = estadoRepository.findById(estado.getIdEstado()).orElse(null);

        if(existing != null){

            if(estado.getNombre() != null)
                existing.setNombre(estado.getNombre());

            return estadoRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idEstado){
        estadoRepository.deleteById(idEstado);
    }
}
