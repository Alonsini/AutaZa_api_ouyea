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
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado idEstado;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago idMetodoPago;

    @ManyToOne
    @JoinColumn(name = "idMetodoEntrega")
    private MetodoEntrega idMetodoEntrega;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;
}
