package com.yeison.portafolio.modells;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCTO")
@Data
public class Producto {
    @Id
    private Long idPropucto;

    @Column(name = "NOMBRE", length = 30, nullable = false)
    private String nombreProducto;

    @Column(name = "PRECIO", nullable = false)
    private int precio;

    @Column(name = "STOCK", nullable = false)
    private int stock;
}
