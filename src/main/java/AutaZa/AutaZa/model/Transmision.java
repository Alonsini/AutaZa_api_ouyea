package AutaZa.AutaZa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransmision;

    @Column(name = "tipoTransmision", length = 50, nullable = false)
    private String tipoTransmision;

    @Column(name = "descripcion", length = 200, nullable = true)
    private String descripcion;

    @Column(name = "cantidadMarchas", length = 2, nullable = false)
    private int cantidadMarchas;
}
