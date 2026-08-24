package com.roberto.punto_venta.controller;

import com.roberto.punto_venta.model.Proveedor;
import com.roberto.punto_venta.service.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProveedorController {

    private final IProveedorService proveedorService;

    public ProveedorController(IProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Listar proveedores
    @GetMapping("/proveedores")
    public String listaProveedores(Model model) {

        List<Proveedor> proveedores = proveedorService.listarProveedores();

        model.addAttribute("proveedores", proveedores);

        return "proveedores/list";
    }

    // Mostrar formulario para nuevo proveedor
    @GetMapping("/proveedores/nueva")
    public String nuevoProveedor(Model model) {

        model.addAttribute("proveedor", new Proveedor());

        return "proveedores/form";
    }

    // Guardar proveedor
    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {

        proveedorService.save(proveedor);

        return "redirect:/proveedores";
    }

    // Editar proveedor
    @GetMapping("/proveedores/editar/{id}")
    public String editarProveedor(@PathVariable Integer id, Model model) {

        Proveedor proveedor = proveedorService.findProveedorById(id);

        model.addAttribute("proveedor", proveedor);

        return "proveedores/form";
    }

    // Eliminar proveedor
    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Integer id) {

        proveedorService.deleteById(id);

        return "redirect:/proveedores";
    }
}