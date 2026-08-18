package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> listarVentas();

    public Venta findById(Integer idVenta);

    public Venta save(Venta venta);

    public void deleteById(Integer idVenta);
}
