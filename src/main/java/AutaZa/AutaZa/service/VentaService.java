package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Venta;
import AutaZa.AutaZa.repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

   
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

 
    public Venta findById(Integer idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }

    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteById(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}
