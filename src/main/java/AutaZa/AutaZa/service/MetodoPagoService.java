package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.MetodoPago;
import AutaZa.AutaZa.repository.MetodoPagoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago findById(Integer idMetodoPago) {
        return metodoPagoRepository.findById(idMetodoPago).orElse(null);
    }

    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public void deleteById(Integer idMetodoPago){
        metodoPagoRepository.deleteById(idMetodoPago);
    }
}
