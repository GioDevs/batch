package com.bacth.batch.dto2;

import lombok.Data;

import java.util.List;


@Data
public class Tienda {

    private String nombreTienda;
    private Direccion direccionTienda;
    private List<Cliente> clientes;
}
