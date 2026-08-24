package com.roberto.punto_venta.model;

import java.math.BigDecimal;

public class ItemVenta {

    private Producto producto;
    private Integer cantidad;

    public ItemVenta(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return producto.getPrecioVenta()
                .multiply(BigDecimal.valueOf(cantidad));
    }
}