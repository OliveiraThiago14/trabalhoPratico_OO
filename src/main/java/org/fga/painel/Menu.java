package org.fga.painel;

import org.fga.cadastros.CadastroProfessores;
import org.fga.entidades.Professor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) {
        try {
            File arquivo = new File("/home/morettipdr/Programming/orientacao-objetos/projeto-final/db.txt");
            if(arquivo.createNewFile()){
                System.out.println("Banco de dados criado com sucesso");
            } else {
                FileWriter escritor = new FileWriter("db.txt", false);
                escritor.close();
            }
            Professor prof = new Professor("Maike", "lanna@gmail.com","61995834947", "lanna123", "241011546", "prof", "eng");
            Professor prof2 = new Professor("Pedro", "lanna@gmail.com","111111", "log", "241011546", "prof", "eng");
            Professor prof3 = new Professor("Maike", "lanna@gmail.com","61995834947", "lanna123", "12313123", "prof", "eng");

            CadastroProfessores cadastroProfessores = CadastroProfessores.getInstancia();
            System.out.println("Professor cadastrado, quantidade de professores atual: " + cadastroProfessores.cadastrarProf(prof));
            System.out.println("Professor cadastrado, quantidade de professores atual: " + cadastroProfessores.cadastrarProf(prof3));
            try {
                System.out.println(cadastroProfessores.buscarProfessor("241011546").toString());
                cadastroProfessores.atualizarProf("241011546", prof2);
                System.out.println(cadastroProfessores.buscarProfessor("241011546").toString());
            } catch (NullPointerException e){
                System.out.println("Professor não encontrado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}