package com.todoCodeEjercicio.bazarStock.repository;

import com.todoCodeEjercicio.bazarStock.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {


}
