package com.todoCodeEjercicio.bazarStock.repository;

import com.todoCodeEjercicio.bazarStock.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
