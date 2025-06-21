package org.fga.entidades;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@Getter
public class Professor extends Servidores {
    private String curso;

    public Professor(String nome, String email, String telefone, String senha, String matricula, String cargo, String curso) {
        super(nome, email, telefone, senha, matricula, cargo);
        this.curso = curso;
    }

    @Override
    public String toString() {
        return getNome() + "," +
                getEmail() + "," +
                getSenha() + "," +
                getCargo() + "," +
                getTelefone() + "," +
                getMatricula() + "," +
                getCurso() + "," +
                OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public boolean verificaUser(String Matricula) {
        try (Scanner scanner = new Scanner(new File("profdb.txt"))) {
            while (scanner.hasNextLine()) {
                String dado = scanner.nextLine();
                String[] separado = dado.split(",");
                if (separado[5].equals(Matricula)) {
                    System.out.println("Professor encontrado! Prossiga com a reserva");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Professor não encontrado! Não é possivel fazer a reserva");
        return false;
    }
}