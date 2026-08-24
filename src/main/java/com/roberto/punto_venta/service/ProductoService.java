package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Producto;
import com.roberto.punto_venta.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    public Producto findById(Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public boolean hayStock(Integer idProducto, Integer stock) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if(producto == null){
            return false;
        }
        return producto.getStock() >= stock; //gestStock es el stock que hay en la DB y Stock es el que solicita alguien
    }

    @Override
    public void reducirStock(Integer idProducto, Integer cantidad) {

        Producto producto = productoRepository.findById(idProducto).orElse(null);

        if (producto != null && producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            productoRepository.save(producto);
        }
    }
}
