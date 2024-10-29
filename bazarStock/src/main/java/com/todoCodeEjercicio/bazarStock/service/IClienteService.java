package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getClientes();

    void saveCliente(Cliente cliente);

    void deleteCliente(Long idCliente);

    Cliente findCliente(Long idCliente);

    void editCliente(Long idCliente, Cliente cliente);
}
