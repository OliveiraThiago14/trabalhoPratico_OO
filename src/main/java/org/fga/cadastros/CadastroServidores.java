package org.fga.cadastros;

import org.fga.entidades.Professor;
import org.fga.entidades.ServidoresAdm;
import org.fga.entidades.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CadastroServidores extends CadastroUsuario{
    private Integer numServidores;
    private static CadastroServidores instancia;

    public static synchronized CadastroServidores getInstancia(){
        if(instancia != null){
            return instancia;
        }
        File file = new File("servdb.txt");
        try {
            if(!file.createNewFile()) {
                System.out.println("banco de dados dos servidores já existe");
            } else {
                System.out.println("banco de dados dos servidores criado com sucesso");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return instancia = new CadastroServidores();
    }

    @Override
    public Integer cadastrar(Usuario usuario){
        ServidoresAdm s = (ServidoresAdm) usuario;
        if(buscar(s.getMatricula()) == null){
            return 0;
        }
        try(FileWriter escritor = new FileWriter("servdb.txt", true)){
            escritor.write(s.toString() + "\n");
            numServidores++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numServidores;
    }

    @Override
    public Professor buscar(String matricula){
        try(Scanner scanner = new Scanner(new File("servdb.txt"))){
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

    @Override
    public boolean atualizar(String matricula, Usuario usuario){
        ServidoresAdm s = (ServidoresAdm) usuario;
        Path path = Paths.get("servdb.txt");
        List<String> text;
        try {
            text = Files.readAllLines(path);
            for (int i = 0; i < text.size(); i++) {
                String[] separado = text.get(i).split(",");
                if(separado[5].trim().equals(matricula)){
                    text.set(i, s.toString());
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
