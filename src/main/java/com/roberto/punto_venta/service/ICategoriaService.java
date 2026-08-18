package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public Categoria findById(Integer idCategoria);

    public Categoria save(Categoria categoria);

    public void deleteById(Integer idCategoria);
}
