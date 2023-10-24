package com.banco.clientepersona.model;


import lombok.*;
import javax.persistence.*;




@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String contrasena;
    private boolean estado;
}
