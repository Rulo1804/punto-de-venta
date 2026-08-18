package com.roberto.punto_venta.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(name = "precio_venta", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Integer stock;

    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}
