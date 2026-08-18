package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente findById(Integer idCliente);

    public Cliente save(Cliente cliente);

    public void deleteById(Integer idCliente);
}
