package com.todoCodeEjercicio.bazarStock.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;

    private LocalDate fechaVenta;
    private Double total;
    @ManyToMany
    @JoinTable(
            name = "venta_producto", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "codigo_venta"), // Clave foránea a Estudiante
            inverseJoinColumns = @JoinColumn(name = "codigo_producto") // Clave foránea a Curso
    )

    private List<Producto> listaProductos;
    @ManyToOne
    @JoinColumn(name="idCliente")
    @JsonBackReference
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
}
