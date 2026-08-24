package com.roberto.punto_venta.controller;

import com.roberto.punto_venta.model.Categoria;
import com.roberto.punto_venta.model.Producto;
import com.roberto.punto_venta.model.Proveedor;
import com.roberto.punto_venta.service.ICategoriaService;
import com.roberto.punto_venta.service.IProductoService;
import com.roberto.punto_venta.service.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductoController {

    private final IProductoService productoService;
    private final ICategoriaService categoriaService;
    private final IProveedorService proveedorService;

    public ProductoController(
            IProductoService productoService,
            ICategoriaService categoriaService,
            IProveedorService proveedorService) {

        this.productoService = productoService;
        this.categoriaService = categoriaService;
        this.proveedorService = proveedorService;
    }



    //Listar Productos
    @GetMapping("/productos")
    public String listaProductos(Model model) {

        List<Producto> productos = productoService.listarProductos();

        model.addAttribute("productos", productos);

        return "productos/list";
    }



    //Nuevo Producto
    @GetMapping("/productos/nueva")
    public String nuevoProducto(Model model) {

        model.addAttribute("producto", new Producto());

        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        model.addAttribute(
                "proveedores",
                proveedorService.listarProveedores()
        );

        return "productos/form";
    }


    //Guardar Prodcuto
    @PostMapping("/productos/guardar")
    public String guardarProducto(
            @ModelAttribute Producto producto,
            @RequestParam Integer categoriaId,
            @RequestParam Integer proveedorId) {

        // Buscar la categoría seleccionada
        Categoria categoria = categoriaService.findById(categoriaId);

        // Buscar el proveedor seleccionado
        Proveedor proveedor = proveedorService.findProveedorById(proveedorId);

        // Asignarlos al producto
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        // Guardar
        productoService.save(producto);

        return "redirect:/productos";
    }


    //Editar Prodcuto
    @GetMapping("/productos/editar/{id}")
    public String editarProducto(
            @PathVariable Integer id,
            Model model) {

        Producto producto = productoService.findById(id);

        model.addAttribute("producto", producto);

        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        model.addAttribute(
                "proveedores",
                proveedorService.listarProveedores()
        );

        return "productos/form";
    }


    //Eliminar Producto
    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {

        productoService.deleteById(id);

        return "redirect:/productos";
    }
}