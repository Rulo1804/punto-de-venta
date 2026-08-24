package com.roberto.punto_venta.controller;

import com.roberto.punto_venta.model.Cliente;
import com.roberto.punto_venta.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteController {
    private IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Listar Proveedores
    @GetMapping("/clientes")
    public String listaClientes(Model model) {

        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);

        return "/clientes/list";
    }

    //Mostrar formulario para nuevo Cliente
    @GetMapping("/clientes/nueva")
    public String nuevoCliente(Model model) {

        model.addAttribute("cliente", new Cliente());

        return "clientes/form";
    }

    @PostMapping("/clientes/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";

    }

    //Editar Cliente
    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(@PathVariable Integer id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    //Eliminar Cliente
    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }
}
