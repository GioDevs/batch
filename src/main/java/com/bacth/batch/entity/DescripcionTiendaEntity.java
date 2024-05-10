package com.bacth.batch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "descripcion_tienda")
@Entity
@Data
public class DescripcionTiendaEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Basic(optional = false)
    @Size(max = 255)
    @Column(name = "id")
    private String id;

    private String nombre;
}
