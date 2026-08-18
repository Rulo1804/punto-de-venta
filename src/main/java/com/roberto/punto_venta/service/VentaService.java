package com.roberto.punto_venta.service;


import com.roberto.punto_venta.model.Venta;
import com.roberto.punto_venta.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> listarVentas() {
        List <Venta> listarVentas = ventaRepository.findAll();
        return listarVentas;
    }

    @Override
    public Venta findById(Integer idVenta) {
        Venta venta = ventaRepository.findById(idVenta).orElse(null);
        return venta;
    }

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteById(Integer idVenta) {
        ventaRepository.deleteById(idVenta);

    }
}
