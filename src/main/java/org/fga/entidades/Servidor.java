package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servidor extends Usuario{
    private String cargo;

    public Servidor(String nome, String email, String telefone, String senha, String matricula, String cargo) {
        super(nome, email, telefone, senha, matricula);
        this.cargo = cargo;
    }
}
