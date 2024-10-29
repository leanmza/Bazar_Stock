package com.todoCodeEjercicio.bazarStock.service;

import com.todoCodeEjercicio.bazarStock.dto.MayorVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.ProductosVentaDTO;
import com.todoCodeEjercicio.bazarStock.dto.VentasDiaDTO;
import com.todoCodeEjercicio.bazarStock.model.Producto;
import com.todoCodeEjercicio.bazarStock.model.Venta;
import com.todoCodeEjercicio.bazarStock.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    IVentaRepository ventaRepository;

    @Autowired
    IProductoService productoService;

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {

        List<Producto> listaDeProductos = new ArrayList<>();

        for (Producto producto : venta.getListaProductos()) {
            producto = productoService.findProducto(producto.getCodigo_producto());

            venta.setTotal(venta.getTotal() + producto.getCosto());
        }

        ventaRepository.save(venta);


    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        ventaRepository.deleteById(codigoVenta);
    }

    @Override
    public Venta findVenta(Long codigoVenta) {
        return ventaRepository.findById(codigoVenta).orElse(null);
    }

    @Override
    public void editarVenta(Long codigoVenta, Venta venta) {
        venta.setCodigo_venta(codigoVenta);
        this.saveVenta(venta);
    }

    @Override
    public ProductosVentaDTO getProductosVentas(Long codigoVenta) {
        ProductosVentaDTO productosVentaDTO = new ProductosVentaDTO();

        productosVentaDTO.setListaProductos(this.findVenta(codigoVenta).getListaProductos());

        return productosVentaDTO;
    }

    @Override
    public VentasDiaDTO getTotalDia(LocalDate fechaVenta) {
        VentasDiaDTO ventasDiaDTO = new VentasDiaDTO();

        List<Venta> listaVentas = this.getVentas();

        Double total = 0.0;
        Integer cantVentas = 0;

        for(Venta venta : listaVentas){
            if(venta.getFechaVenta().isEqual(fechaVenta)){
                total = total + venta.getTotal();
                cantVentas++;
            }
        }

        ventasDiaDTO.setMonto_total(total);
        ventasDiaDTO.setCantidad_ventas(cantVentas);
        return ventasDiaDTO;
    }

    @Override
    public MayorVentaDTO getMayorVenta() {

        List<Venta> listaVentas = this.getVentas();

        Venta ventaMayor = new Venta();
        int totalMayor = 0;

        for(Venta venta : listaVentas){
            if(venta.getTotal()>totalMayor){
                ventaMayor=venta;
            }
        }

        MayorVentaDTO mayorVentaDTO = new MayorVentaDTO();
        mayorVentaDTO.setCodigo_venta(ventaMayor.getCodigo_venta());
        mayorVentaDTO.setTotal(ventaMayor.getTotal());
        mayorVentaDTO.setCantidad_productos(ventaMayor.getListaProductos().size());
        mayorVentaDTO.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
        mayorVentaDTO.setApellido_cliente(ventaMayor.getUnCliente().getApellido());

        return mayorVentaDTO;
    }
}
