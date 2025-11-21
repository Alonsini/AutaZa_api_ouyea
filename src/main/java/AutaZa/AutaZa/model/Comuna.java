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
public class Comuna {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer idComuna;

    @Column(name = "nombreComuna", length = 30, nullable = false)
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "idRegion")
    private Region region;
}
