package com.bacth.batch.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TiendaInfoDto {
    private DireccionTiendaDto direccionTienda;
    private DescripcionTiendaDto descripcionTienda;
    private List<PersonDto> personas;
}
