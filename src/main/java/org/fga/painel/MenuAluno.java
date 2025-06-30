package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroEspacosFisicos;
import org.fga.entidades.Aluno;
import org.fga.painel.MenuEspacosFisicos;
import java.util.Scanner;

public class MenuAluno {
    Scanner sc = new Scanner(System.in);
    public void goToMenuAluno() {
        System.out.println("\nBem vindo ao Menu de Aluno\n");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Mostrar Alunos");
        System.out.println("3 - Ir ao Menu de Espaços");

        int escolha = sc.nextInt();
        CadastroAluno cad = CadastroAluno.getInstancia();
        MenuEspacosFisicos menuEspaco = new MenuEspacosFisicos;

        switch (escolha) {
            // Cadastro de Aluno
            case 1:
               cadastro();
           // Listar alunos
            case 2:
                cad.listarAluno();
            // Ir para o Menu de Espaços Fisicos;
            case 3:
                menuEspaco.MenuEspaco();
        }
    }
    private void cadastro(){
        CadastroAluno cadAluno = CadastroAluno.getInstacia();
        //nome
        System.out.println("Qual o seu nome? ");
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o seu email? ");
        String email = sc.nextLine();
        //telefone
        System.out.println("Qual o seu telfone? ");
        String telefone = sc.nextLine();
        //senha
        System.out.println("Qual o seu senha? ");
        String senha = sc.nextLine();
        //curso
        System.out.println("Qual o seu curso? ");
        String curso = sc.nextLine();
        //matricula
        System.out.println("Qual o seu matricula? ");
        String matricula = sc.nextLine();
        //semestre
        System.out.println("Qual o seu semestre? ");
        String semestre = sc.nextLine();

        Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);

        cadAluno.cadastrar(aluno);
    }

}
