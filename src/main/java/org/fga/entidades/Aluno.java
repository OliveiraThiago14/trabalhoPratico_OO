package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public Aluno() {

    }

    @Override
   public String toString() {
       return "Aluno: " +
               "nome='" + getNome() + '\'' +
               ", email='" + getEmail() + '\'' +
               ", telefone='" + getTelefone() + '\'' +
               ", matricula='" + getMatricula() + '\'' +
               ", curso='" + curso + '\'' +
               ", semestre='" + semestre + '\'';
   }
}
