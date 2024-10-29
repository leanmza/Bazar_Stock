package com.todoCodeEjercicio.bazarStock.controller;

import com.todoCodeEjercicio.bazarStock.dto.MayorVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.ProductosVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.VentasDiaDTO;
import com.todoCodeEjercicio.bazarStock.model.Producto;
import com.todoCodeEjercicio.bazarStock.model.Venta;
import com.todoCodeEjercicio.bazarStock.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    IVentaService ventaService;

    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return "Venta creada correctamente";
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada exitosamente";
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta);
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        ventaService.editarVenta(codigo_venta, venta);
        return findVenta(codigo_venta);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public ProductosVentaDTO getProductosVenta(@PathVariable Long codigo_venta){
        return ventaService.getProductosVentas(codigo_venta);
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public VentasDiaDTO getTotalDia(@PathVariable LocalDate fecha_venta){

        return ventaService.getTotalDia(fecha_venta);
    }

     @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO getMayorVenta(){
        return ventaService.getMayorVenta();
     }


}
