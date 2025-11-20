package AutaZa.AutaZa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AutaZa.AutaZa.model.Transmision;

@Repository
public interface TransmisionRepository extends JpaRepository<Transmision, Integer>{

    List<Transmision> findByIdTransmision(String idTransmision);

    List<Transmision> findByTipoTransmision(String tipoTransmision);
}
