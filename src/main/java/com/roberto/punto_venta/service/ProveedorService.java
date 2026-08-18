package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Proveedor;
import com.roberto.punto_venta.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarProveedores() {
        List <Proveedor> listaProveedores = proveedorRepository.findAll();
        return listaProveedores;
    }

    @Override
    public Proveedor findProveedorById(Integer idProveedor) {
        Proveedor proveedor = proveedorRepository.findById(idProveedor).orElse(null);
        return proveedor;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteById(Integer idProveedor) {
        proveedorRepository.deleteById(idProveedor);

    }
}
