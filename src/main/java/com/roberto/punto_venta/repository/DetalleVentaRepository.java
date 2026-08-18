package com.roberto.punto_venta.repository;

import com.roberto.punto_venta.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
}
