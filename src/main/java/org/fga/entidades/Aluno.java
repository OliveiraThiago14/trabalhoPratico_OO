package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Usuario{
    private String curso;
    private String matricula;
    private Integer semestre;

    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, Integer semestre) {
        super(nome, email, telefone, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
    }
}
