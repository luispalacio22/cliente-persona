package com.banco.clientepersona.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String direccion;
    private String telefono;
    private String contrasena;
    private boolean estado;
}
