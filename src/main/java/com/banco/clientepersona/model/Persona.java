package com.banco.clientepersona.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Persona {
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;

}
