package org.fga.cadastros;

import org.fga.entidades.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CadastroAluno {
    private Integer numAlunos = 0;
    private static CadastroAluno instancia;

    public static CadastroAluno getInstacia(){
        if(instancia != null){
            return instancia;
        }

        try {
            File file = new File("alundb.txt");
            if(!file.createNewFile()) {
                System.out.println("Banco de dados dos alunos já existe");
            } else{
                System.out.println("Banco de dados criado com suscesso");
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return instancia = new CadastroAluno();
    }

    public Integer cadastrarAluno(Aluno a){
        //precisa captar o nome do aluno, email, matricula, telefone, senha,
        //nome do curso, semestre lançar no arquivo alundb.txt para deixar salvo no banco
        if(buscarAluno(a.getMatricula()) != null) {
            return 0;
        }

        try (FileWriter escritor = new FileWriter("alundb.txt", true);){
            escritor.write(a.toString() + "\n");
            numAlunos++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numAlunos;
    }

    public Aluno buscarAluno(String matricula){
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    Aluno aluno = new Aluno(separado[0], separado[1], separado[2], separado[3], separado[4], separado[5], separado[6]);
                    return aluno;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean atualizarAluno(String matricula, Aluno a) {
        Path path = Paths.get("alundb.txt");
        List<String> text;
        try {
            text = Files.readAllLines(path);
            for(int i=0; i < text.size(); i++){
                String[] separado = text.get(i).split(",");
                if(separado[5].trim().equals(matricula)){
                    text.set(i, a.toString());
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
