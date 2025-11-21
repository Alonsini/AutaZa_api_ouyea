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
public class MetodoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoEntrega;

    @Column(name = "nombreMetodoEntrega", length = 50, nullable = false)
    private String nombreMetodoEntrega;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Double costo;

    @Column(name = "tiempoEstimado", length = 100)
    private String tiempoEstimado;
}
