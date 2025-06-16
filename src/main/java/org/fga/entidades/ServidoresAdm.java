package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class ServidoresAdm extends Servidores{
    private String departamento;

    public ServidoresAdm(String nome, String email, String telefone, String senha, String matricula, String cargo, String departamento) {
        super(nome, email, telefone, senha, matricula, cargo);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return getNome() + "," +
                getEmail() + "," +
                getSenha() + "," +
                getCargo() + "," +
                getTelefone() + "," +
                getMatricula() + "," +
                getDepartamento() + "," +
                OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
