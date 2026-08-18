package com.roberto.punto_venta.repository;

import com.roberto.punto_venta.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
