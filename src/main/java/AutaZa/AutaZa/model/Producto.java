package AutaZa.AutaZa.model;

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

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca idMarca;

    @ManyToOne
    @JoinColumn(name = "idCombustible")
    private Combustible combustible;

    @ManyToOne
    @JoinColumn(name = "idImagen")
    private Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "idColores")
    private Colores colores;

    @ManyToOne
    @JoinColumn(name = "idCategorias")
    private Categorias categorias;
}
