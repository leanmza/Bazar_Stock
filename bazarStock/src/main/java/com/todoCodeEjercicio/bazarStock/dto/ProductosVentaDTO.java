package com.todoCodeEjercicio.bazarStock.dto;

import com.todoCodeEjercicio.bazarStock.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductosVentaDTO {

    private List<Producto> listaProductos;

    public ProductosVentaDTO() {
    }

    public ProductosVentaDTO(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
