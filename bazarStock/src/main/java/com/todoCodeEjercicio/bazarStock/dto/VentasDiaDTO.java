package com.todoCodeEjercicio.bazarStock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class VentasDiaDTO {

    private Double monto_total;
    private Integer cantidad_ventas;

    public VentasDiaDTO() {
    }

    public VentasDiaDTO(Double monto_total, Integer cantidad_ventas) {
        this.monto_total = monto_total;
        this.cantidad_ventas = cantidad_ventas;
    }
}
