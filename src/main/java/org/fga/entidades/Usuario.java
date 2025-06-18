package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public abstract class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String senha;



    public boolean verificaUser(String Matricula) {
        try (Scanner scanner = new Scanner(new File("alunodb.txt"))) {
            while (scanner.hasNextLine()) {
                String dado = scanner.nextLine();
                String[] separado = dado.split(",");
                if (separado[5].equals(Matricula)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
