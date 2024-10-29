package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.dto.MayorVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.ProductosVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.VentasDiaDTO;
import com.todoCodeEjercicio.bazarStock.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    void saveVenta(Venta venta);

    void deleteVenta(Long codigoVenta);

    Venta findVenta(Long codigoVenta);

    void editarVenta(Long codigoVenta, Venta venta);

    ProductosVentaDTO getProductosVentas(Long codigoVenta);

    VentasDiaDTO getTotalDia(LocalDate fechaVenta);

    MayorVentaDTO getMayorVenta();
}
