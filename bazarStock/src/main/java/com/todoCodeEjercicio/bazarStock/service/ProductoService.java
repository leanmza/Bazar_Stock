package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.model.Producto;
import com.todoCodeEjercicio.bazarStock.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long codigoProducto) {
        productoRepository.deleteById(codigoProducto);
    }

    @Override
    public void editProducto(Long codigoProducto, Producto producto) {
        producto.setCodigo_producto(codigoProducto);
        this.saveProducto(producto);

    }

    @Override
    public Producto findProducto(Long codigoProducto) {
        return productoRepository.findById(codigoProducto).orElse(null);
    }

    @Override
    public List<Producto> getFaltaStock() {
        List<Producto> listaProductos = this.getProductos();

        List<Producto> listaFaltaStock = new ArrayList<>();

        for (Producto producto : listaProductos) {
            if (producto.getCant_disponible() < 5) {
                listaFaltaStock.add(producto);
            }
        }
        return listaFaltaStock;
    }
}
