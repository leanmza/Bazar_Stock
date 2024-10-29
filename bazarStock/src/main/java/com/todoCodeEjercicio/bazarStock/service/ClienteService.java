package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.model.Cliente;
import com.todoCodeEjercicio.bazarStock.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
      clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);

    }

    @Override
    public Cliente findCliente(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public void editCliente(Long idCliente, Cliente cliente) {
        cliente.setId_cliente(idCliente);
        this.saveCliente(cliente);
    }
}
