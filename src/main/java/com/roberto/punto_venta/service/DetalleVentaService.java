package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.DetalleVenta;
import com.roberto.punto_venta.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService implements IDetalleVenta{

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;


    @Override
    public List<DetalleVenta> listarDetalleVentas() {
        List <DetalleVenta> listarDetalleVentas = detalleVentaRepository.findAll();
        return listarDetalleVentas;
    }

    @Override
    public DetalleVenta findById(Integer detalleVentaId) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(detalleVentaId).orElse(null);
        return detalleVenta;
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deleteById(Integer detalleVentaId) {
        detalleVentaRepository.deleteById(detalleVentaId);
    }
}
