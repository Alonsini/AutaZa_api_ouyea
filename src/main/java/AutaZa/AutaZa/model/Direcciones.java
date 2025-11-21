package AutaZa.AutaZa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Direcciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDirecciones;
    
    @Column(name = "calle", length = 100, nullable = false)
    private String calle;

    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idComuna")
    private Comuna idComuna;

    
}
