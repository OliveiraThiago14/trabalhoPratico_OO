package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servidores extends Usuario{
    private String matricula;
    private String cargo;

    public Servidores(String nome, String email, String telefone, String senha, String matricula, String cargo) {
        super(nome, email, telefone, senha);
        this.matricula = matricula;
        this.cargo = cargo;
    }
}
