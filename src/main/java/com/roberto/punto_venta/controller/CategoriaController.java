package com.roberto.punto_venta.controller;

import com.roberto.punto_venta.model.Categoria;
import com.roberto.punto_venta.service.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {

    private final ICategoriaService categoriaService;

    public CategoriaController(ICategoriaService categoriaRepository) {
        this.categoriaService = categoriaRepository;
    }

    //Listar las Categorias
    @GetMapping("/categorias")
    public String listaCategorias(Model model){

        List<Categoria> categorias = categoriaService.listarCategorias();

        model.addAttribute("categorias", categorias);

        return "categorias/list";
    }

    //Agregar Categoría

    @GetMapping("/categorias/nueva")
    public String nuevaCategoria(Model model){
        model.addAttribute("categoria", new Categoria()); //Se crea vacia
        return "categorias/form";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria){ //Crea al objeto de tipo Categoria
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

    //Editar Categoria
    @GetMapping("/categorias/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model){

        Categoria categoria = categoriaService.findById(id);
        model.addAttribute("categoria", categoria);
        return "categorias/form";
    }

    //Eliminar Categoria
    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id){
        categoriaService.deleteById(id);
        return "redirect:/categorias";
    }
}
