package com.roberto.punto_venta.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(length = 200)
    private String direccion;
}
