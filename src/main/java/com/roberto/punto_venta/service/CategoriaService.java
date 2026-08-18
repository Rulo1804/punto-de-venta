package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Categoria;
import com.roberto.punto_venta.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        return listaCategorias;
    }

    @Override
    public Categoria findById(Integer idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        return categoria;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);

    }
}
