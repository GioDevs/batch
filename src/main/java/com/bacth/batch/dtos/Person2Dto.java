package com.bacth.batch.dtos;

import lombok.Data;

@Data
public class Person2Dto {

    public Person2Dto(String id, String nombreCompleto, int edad){

        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    private String id;
    private String nombreCompleto;
    private int edad;


}
