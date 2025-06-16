package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@Getter
@Setter
public class Aluno extends Usuario{
    private String curso;
    private String matricula;
    private String semestre;

    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, String semestre) {
        super(nome, email, telefone, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return getNome() + "," +
                getEmail() + "," +
                getSenha() + "," +
                getSemestre() + "," +
                getTelefone() + "," +
                getMatricula() + "," +
                getCurso() + "," +
                OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public boolean verificarAluno(String Matricula) {
        try(Scanner scanner = new Scanner(new File("alunodb.txt"))){
            while (scanner.hasNextLine()){
                String dado = scanner.nextLine();
                String[] separado = dado.split(",");
                if(separado[5].equals(Matricula)){
                    System.out.println("Aluno encontrado");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aluno não encontrado!");
        return false;
    }
}

