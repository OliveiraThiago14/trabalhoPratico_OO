package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.entidades.Aluno;
import java.util.Scanner;

public class MenuAluno {
    static Scanner sc = new Scanner(System.in);

    public static void goToMenuAluno() {
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Mostrar Alunos");
        System.out.println("3 - Ir ao Menu de Espaços");
        System.out.println("4 - Voltar ao Menu Inicial");

        int escolha = sc.nextInt();
        CadastroAluno cadastroAluno = CadastroAluno.getInstancia();
        MenuEspacoFisico menuEspaco = new MenuEspacoFisico();

        switch (escolha) {
            case 1 -> cadastro();
            case 2 -> cadastroAluno.listarAluno();
            case 3 -> menuEspaco.menuEspaco();
            case 4 -> MenuInicial.menuInicial();
            default -> goToMenuAluno();
        }
        goToMenuAluno();
    }

    private static void cadastro(){
        CadastroAluno cadastroAluno = CadastroAluno.getInstancia();
        //nome
        System.out.println("Qual o seu nome? ");
        sc.nextLine();
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o seu email? ");
        String email = sc.nextLine();
        //sc.nextLine();
        //telefone
        System.out.println("Qual o seu telfone? ");
        String telefone = sc.nextLine();
        //sc.nextLine();
        //senha
        System.out.println("Qual a sua senha? ");
        String senha = sc.nextLine();
        //sc.nextLine();
        //curso
        System.out.println("Qual o seu curso? ");
        String curso = sc.nextLine();
        //sc.nextLine();
        //matricula
        System.out.println("Qual a sua matricula? ");
        String matricula = sc.nextLine();
        //sc.nextLine();
        //semestre
        System.out.println("Qual o seu semestre? ");
        String semestre = sc.nextLine();
        //sc.nextLine();

        Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);

        cadastroAluno.cadastrar(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }
}
