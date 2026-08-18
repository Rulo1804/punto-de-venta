package com.roberto.punto_venta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

}
