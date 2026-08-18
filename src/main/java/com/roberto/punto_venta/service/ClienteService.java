package com.roberto.punto_venta.service;

import com.roberto.punto_venta.model.Cliente;
import com.roberto.punto_venta.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listarClientes() {
        List <Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes;
    }

    @Override
    public Cliente findById(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
         return cliente;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
