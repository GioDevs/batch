package com.bacth.batch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "direccion_tienda")
@Entity
@Data
public class DireccionTiendaEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Basic(optional = false)
    @Size(max = 255)
    @Column(name = "id")
    private String id;

    private String calle;

    private String  ciudad;
}
