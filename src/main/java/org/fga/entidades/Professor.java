package org.fga.entidades;

import lombok.Getter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
public class Professor extends Servidor {
    private String curso;

    public Professor(String nome, String email, String telefone, String senha, String matricula, String cargo, String curso) {
        super(nome, email, telefone, senha, matricula, cargo);
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Professor: " +
                "nome=" + getNome() +
                ", telefone=" + getTelefone() +
                ", matricula=" + getMatricula() +
                ", cargo=" + getCargo() +
                ", curso=" + curso + "\n";
    }
}
