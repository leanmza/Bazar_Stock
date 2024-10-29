package com.todoCodeEjercicio.bazarStock.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cant_disponible;



    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cant_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_disponible = cant_disponible;

    }
}
