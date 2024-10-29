package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getProductos();

    void saveProducto(Producto producto);

    void deleteProducto(Long codigoProducto);

    void editProducto(Long codigoProducto, Producto producto);

    Producto findProducto(Long codigoProducto);

    List<Producto> getFaltaStock();
}
