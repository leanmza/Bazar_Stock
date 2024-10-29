package com.todoCodeEjercicio.bazarStock.repository;

import com.todoCodeEjercicio.bazarStock.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
