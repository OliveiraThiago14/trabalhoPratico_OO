package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String senha;
}
