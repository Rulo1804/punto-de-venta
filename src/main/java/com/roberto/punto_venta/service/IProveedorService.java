package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Proveedor;

import java.util.List;

public interface IProveedorService {

    public List<Proveedor> listarProveedores();

    public Proveedor findProveedorById(Integer idProveedor);

    public Proveedor save(Proveedor proveedor);

    public void deleteById(Integer idProveedor);
}
