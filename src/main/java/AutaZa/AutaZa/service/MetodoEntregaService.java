package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.MetodoEntrega;
import AutaZa.AutaZa.repository.MetodoEntregaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoEntregaService {

    @Autowired
    private MetodoEntregaRepository metodoEntregaRepository;

    public List<MetodoEntrega> findAll() {
        return metodoEntregaRepository.findAll();
    }

    public MetodoEntrega findById(Integer idMetodoEntrega) {
        return metodoEntregaRepository.findById(idMetodoEntrega).orElse(null);
    }

    public MetodoEntrega save(MetodoEntrega metodoEntrega) {
        return metodoEntregaRepository.save(metodoEntrega);
    }

    public MetodoEntrega partialUpdate(MetodoEntrega metodoEntrega){
        MetodoEntrega existing = metodoEntregaRepository.findById(metodoEntrega.getIdMetodoEntrega()).orElse(null);

        if(existing != null){

            if(metodoEntrega.getNombreMetodoEntrega() != null)
                existing.setNombreMetodoEntrega(metodoEntrega.getNombreMetodoEntrega());

            if(metodoEntrega.getDescripcion() != null)
                existing.setDescripcion(metodoEntrega.getDescripcion());

            if(metodoEntrega.getCosto() != null)
                existing.setCosto(metodoEntrega.getCosto());

            if(metodoEntrega.getTiempoEstimado() != null)
                existing.setTiempoEstimado(metodoEntrega.getTiempoEstimado());

            return metodoEntregaRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idMetodoEntrega){
        metodoEntregaRepository.deleteById(idMetodoEntrega);
    }
}
