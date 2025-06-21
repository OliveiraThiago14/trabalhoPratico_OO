package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class ServidorAdm extends Servidor{
    private String departamento;

    public ServidorAdm(String nome, String email, String telefone, String senha, String matricula, String cargo, String departamento) {
        super(nome, email, telefone, senha, matricula, cargo);
        this.departamento = departamento;
    }
}
