package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.DetalleVenta;
import com.roberto.punto_venta.model.Venta;

import java.util.List;

public interface IDetalleVenta {

    public List<DetalleVenta> listarDetalleVentas();

    public DetalleVenta findById(Integer detalleVentaId);

    public DetalleVenta save (DetalleVenta detalleVenta);

    public void deleteById(Integer detalleVentaId);
}
