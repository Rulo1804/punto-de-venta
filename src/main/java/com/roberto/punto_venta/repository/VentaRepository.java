package com.roberto.punto_venta.repository;

import com.roberto.punto_venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
