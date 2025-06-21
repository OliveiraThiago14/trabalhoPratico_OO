package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Aluno extends Usuario{
    private String curso;
    private String semestre;

    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, String semestre) {
        super(nome, email, telefone, senha, matricula);
        this.curso = curso;
        this.semestre = semestre;
    }
}
