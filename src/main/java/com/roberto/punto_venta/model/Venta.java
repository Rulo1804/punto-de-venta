package com.roberto.punto_venta.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    //Foreign Key
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}
