package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> listarProductos();

    public Producto findById(Integer idProducto);

    public Producto save(Producto producto);

    public void deleteById(Integer idProducto);

    //Metodos especiales
    public boolean hayStock (Integer idProducto, Integer stock);

    public void reducirStock(Integer idProducto, Integer cantidad);
}
