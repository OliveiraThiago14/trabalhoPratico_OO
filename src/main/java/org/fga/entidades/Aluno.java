package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
