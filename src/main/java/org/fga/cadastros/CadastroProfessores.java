package org.fga.cadastros;

import org.fga.entidades.Professor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CadastroProfessores {
    private Integer numProfessores = 0;
    private static CadastroProfessores instancia;

    public static synchronized CadastroProfessores getInstancia(){
        if(instancia != null){
            return instancia;
        }
        else return instancia = new CadastroProfessores();
    }

    public Integer cadastrarProf(Professor p){
        try{
            FileWriter escritor = new FileWriter("db.txt", true);
            escritor.write(p.toString() + "\n");
            escritor.close();
            numProfessores++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numProfessores;
    }

    public Professor buscarProfessor(String matricula){
        try(Scanner scanner = new Scanner(new File("db.txt"))){
            while (scanner.hasNextLine()){
                String dado = scanner.nextLine();
                String[] separado = dado.split(",");
                if(separado.length > 0 && separado[5].trim().equals(matricula)){
                    Professor professor = new Professor(separado[0], separado[1], separado[2], separado[3], separado[4], separado[5], separado[6]);
                    return professor;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean atualizarProf(String matricula, Professor p){
        Path path = Paths.get("db.txt");
        List<String> text;
        try {
            text = Files.readAllLines(path);
            for (int i = 0; i < text.size(); i++) {
                String[] separado = text.get(i).split(",");
                if(separado[5].trim().equals(matricula)){
                    text.set(i, p.toString());
                    Files.write(path, text);
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
