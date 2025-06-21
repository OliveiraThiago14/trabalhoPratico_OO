package org.fga.entidades;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

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

    @Override
    public boolean verificaUser(String Matricula) {
        try (Scanner scanner = new Scanner(new File("servdb.txt"))) {
            while (scanner.hasNextLine()) {
                String dado = scanner.nextLine();
                String[] separado = dado.split(",");
                if (separado[5].equals(Matricula)) {
                    System.out.println("Servidor administrativo encontrado! Prossiga com a reserva");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Servidor administrativo não encontrado! Não é possivel fazer a reserva");
        return false;
    }
}
