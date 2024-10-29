package com.todoCodeEjercicio.bazarStock.controller;

import com.todoCodeEjercicio.bazarStock.model.Producto;
import com.todoCodeEjercicio.bazarStock.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "Producto creado correctamente";
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return productoService.findProducto(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto){
        productoService.editProducto(codigo_producto, producto);
        return productoService.findProducto(codigo_producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getFaltaStock(){
        return productoService.getFaltaStock();
    }
}
