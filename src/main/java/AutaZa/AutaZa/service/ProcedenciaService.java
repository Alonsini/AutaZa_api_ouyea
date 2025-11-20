package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Procedencia;
import AutaZa.AutaZa.repository.ProcedenciaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProcedenciaService {

    @Autowired
    private ProcedenciaRepository procedenciaRepository;

    public List<Procedencia> findAll() {
        return procedenciaRepository.findAll();
    }

    public Procedencia findById(Integer idProcedencia) {
        return procedenciaRepository.findById(idProcedencia).orElse(null);
    }

    public Procedencia save(Procedencia procedencia) {
        return procedenciaRepository.save(procedencia);
    }

    public void deleteById(Integer idProcedencia){
        procedenciaRepository.deleteById(idProcedencia);
    }
}
