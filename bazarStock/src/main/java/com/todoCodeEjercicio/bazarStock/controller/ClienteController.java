package com.todoCodeEjercicio.bazarStock.controller;

import com.todoCodeEjercicio.bazarStock.model.Cliente;
import com.todoCodeEjercicio.bazarStock.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clienteService.findCliente(id_cliente);
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        clienteService.editCliente(id_cliente, cliente);
        return clienteService.findCliente(id_cliente);
    }
}
