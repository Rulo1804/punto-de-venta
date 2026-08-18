package com.roberto.punto_venta.repository;

import com.roberto.punto_venta.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
