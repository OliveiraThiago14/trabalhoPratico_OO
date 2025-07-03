package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.Aluno;
import org.fga.entidades.Professor;
import org.fga.entidades.Servidor;
import org.fga.entidades.ServidorAdm;
import org.fga.exceptions.EmailSenhaIncorretaException;

import java.util.Scanner;

public class MenuServidor {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroServidor cadastroServidor = CadastroServidor.getInstancia();
    private static final CadastroAluno cadastroAluno = CadastroAluno.getInstancia();
    private static final CadastroProfessor cadastroProfessor = CadastroProfessor.getInstancia();

    public static void goToMenuServidor(){
        System.out.println("Informe o seu email:");
        String email = sc.nextLine();
        System.out.println("Informe a sua senha:");
        String senha = sc.nextLine();
        try{
            cadastroServidor.autenticar(email,senha);
        } catch(EmailSenhaIncorretaException e){
            System.out.println(e.getMessage());
            return;
        }
        while(true) {
            System.out.println("Bem vindo ao menu dos servidores\nEscolha uma opcao");
            System.out.println("1 - Cadastrar Servidor");
            System.out.println("2 - Mostrar Servidores");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Mostrar Alunos");
            System.out.println("5 - Cadastrar Professor");
            System.out.println("4 - Mostrar Professores");
            System.out.println("7 - Ir ao Menu de Espaços");
            System.out.println("8 - Voltar ao Menu Inicial");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> cadastroDoServidor();
                case 2 -> cadastroServidor.listar("Servidor");
                case 3 -> cadastroDoAluno();
                case 4 -> cadastroAluno.listar("Aluno");
                case 5 -> cadastroDoProfessor();
                case 6 -> cadastroProfessor.listar("Professor");
                case 7 -> MenuEspacoFisico.menuEspaco();
                case 8 -> MenuInicial.menuInicial();
                default -> goToMenuServidor();
            }
        }
    }

    private static void cadastroDoAluno(){
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


    private static void cadastroDoServidor(){
        //nome
        System.out.println("Qual o seu nome? ");
        sc.nextLine();
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o seu email? ");
        String email = sc.nextLine();
        //telefone
        System.out.println("Qual o seu telfone? ");
        String telefone = sc.nextLine();
        //senha
        System.out.println("Qual a sua senha? ");
        String senha = sc.nextLine();
        //matricula
        System.out.println("Qual a sua matricula? ");
        String matricula = sc.nextLine();
        //cargo
        System.out.println("Qual o seu cargo? ");
        String cargo = sc.nextLine();
        //departamento
        System.out.println("Qual o seu departamento? ");
        String departamento = sc.nextLine();

        ServidorAdm servidor = new ServidorAdm(nome, email, telefone, senha, matricula, cargo, departamento);

        cadastroServidor.cadastrar(servidor);

        System.out.println("Servidor cadastrado com sucesso!");
    }

    private static void cadastroDoProfessor(){
        //nome
        System.out.println("Qual o seu nome? ");
        sc.nextLine();
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o seu email? ");
        String email = sc.nextLine();
        //telefone
        System.out.println("Qual o seu telfone? ");
        String telefone = sc.nextLine();
        //senha
        System.out.println("Qual a sua senha? ");
        String senha = sc.nextLine();
        //matricula
        System.out.println("Qual a sua matricula? ");
        String matricula = sc.nextLine();
        //cargo
        System.out.println("Qual o seu cargo? ");
        String cargo = sc.nextLine();
        //curso
        System.out.println("Qual o seu curso? ");
        String curso = sc.nextLine();

        Professor professor = new Professor(nome, email, telefone, senha, matricula, cargo, curso);

        cadastroProfessor.cadastrar(professor);

        System.out.println("Professor cadastrado com sucesso!");
    }
}
