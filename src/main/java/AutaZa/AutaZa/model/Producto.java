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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(name = "nombreProducto", length = 50, nullable = false)
    private String nombreProducto;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca idMarca;

    @ManyToOne
    @JoinColumn(name = "idCombustible")
    private Combustible idCombustible;

    @ManyToOne
    @JoinColumn(name = "idImagen")
    private Imagen idImagen;

    @ManyToOne
    @JoinColumn(name = "idColores")
    private Colores idColores;

    @ManyToOne
    @JoinColumn(name = "idCategorias")
    private Categorias idCategorias;
}
