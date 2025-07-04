package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.Aluno;
import org.fga.entidades.Professor;
import org.fga.entidades.ServidorAdm;
import org.fga.entidades.Usuario;
import org.fga.exceptions.EmailSenhaIncorretaException;
import org.fga.util.TipoUsuario;

import java.util.Scanner;

public class MenuServidor {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroServidor cadastroServidor = CadastroServidor.getInstancia();
    private static final CadastroAluno cadastroAluno = CadastroAluno.getInstancia();
    private static final CadastroProfessor cadastroProfessor = CadastroProfessor.getInstancia();

    public static void goToMenu(){
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
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuário");
            System.out.println("3 - Atualizar Usuário");
            System.out.println("4 - Ir ao Menu de Espaços");
            System.out.println("5 - Voltar ao Menu Inicial");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> cadastroAll(escolha());
                case 2 -> cadastroServidor.listar(escolha());
                case 3 -> dadosAtualizados(escolha());
                case 4 -> MenuEspacoFisico.goToMenu(TipoUsuario.SERVIDOR);
                case 5 -> {
                    return;
                }
                default -> goToMenu();
            }
        }
    }

    public static TipoUsuario escolha(){
        System.out.println("Escolha uma opcao:\n1 - Aluno\n2 - Servidor\n3 - Professor\n4 - Voltar ao menu inicial");
        int escolha = sc.nextInt();
        if(escolha < 1 || escolha > 4){
            System.out.println("Escolha uma opcao valida!");
            return escolha();
        }
        TipoUsuario tipo = null;
        switch (escolha){
            case 1 -> tipo = TipoUsuario.ALUNO;
            case 2 -> tipo = TipoUsuario.SERVIDOR;
            case 3 -> tipo = TipoUsuario.PROFESSOR;
        }
        return tipo;
    }

    private static void dadosAtualizados(TipoUsuario tipoUsuario) {
        if(tipoUsuario == null){
            goToMenu();
            return;
        }
        System.out.println("Informe a Matrícula do Usuário que Terão os Dados Atualizados:");
        String matricula = sc.nextLine();

        //nome
        System.out.println("Qual o nome? ");
        sc.nextLine();
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o email? ");
        String email = sc.nextLine();
        //telefone
        System.out.println("Qual o telefone? ");
        String telefone = sc.nextLine();
        //senha
        System.out.println("Qual a senha? ");
        String senha = sc.nextLine();

        switch (tipoUsuario){
            case ALUNO -> {
                System.out.println("Qual o curso? ");
                String curso = sc.nextLine();
                System.out.println("Qual o seu semestre? ");
                String semestre = sc.nextLine();

                Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);
                cadastroAluno.atualizar(cadastroAluno.getIdByMatricula(matricula), aluno);
                System.out.println("Dados do Aluno "+ aluno.getNome() + " Atualizados com sucesso!");
            }
            case SERVIDOR -> {
                System.out.println("Qual o departamento? ");
                String departamento = sc.nextLine();
                System.out.println("Qual o cargo? ");
                String cargo = sc.nextLine();

                ServidorAdm servidor = new ServidorAdm(nome, email, telefone, senha, matricula, cargo, departamento);
                cadastroServidor.atualizar(cadastroServidor.getIdByMatricula(matricula), servidor);
                System.out.println("Dados do Servidor " + servidor.getNome() + " Atualizados com sucesso!");
            }
            case PROFESSOR -> {
                System.out.println("Qual o curso? ");
                String curso = sc.nextLine();
                System.out.println("Qual o cargo? ");
                String cargo = sc.nextLine();

                Professor professor = new Professor(nome, email, telefone, senha, matricula, cargo, curso);
                cadastroProfessor.atualizar(cadastroProfessor.getIdByMatricula(matricula), professor);
                System.out.println("Dados do Professor " + professor.getNome() + " Atualizados com sucesso!");
            }
        }
    }

    private static void cadastroAll(TipoUsuario tipoUsuario){
        if(tipoUsuario == null){
            goToMenu();
            return;
        }
        //nome
        System.out.println("Qual o nome? ");
        sc.nextLine();
        String nome = sc.nextLine();
        //email
        System.out.println("Qual o email? ");
        String email = sc.nextLine();
        //telefone
        System.out.println("Qual o telefone? ");
        String telefone = sc.nextLine();
        //senha
        System.out.println("Qual a senha? ");
        String senha = sc.nextLine();
        //matricula
        System.out.println("Qual a matricula? ");
        String matricula = sc.nextLine();

        switch (tipoUsuario){
            case ALUNO -> {
                //curso
                System.out.println("Qual o curso? ");
                String curso = sc.nextLine();
                System.out.println("Qual o seu semestre? ");
                String semestre = sc.nextLine();

                Aluno aluno = new Aluno(nome, email, telefone, senha, curso, matricula, semestre);
                cadastroAluno.cadastrar(aluno);
                System.out.println("Aluno cadastrado com sucesso!");
            }
            case SERVIDOR -> {
                System.out.println("Qual o cargo? ");
                String cargo = sc.nextLine();
                System.out.println("Qual o departamento? ");
                String departamento = sc.nextLine();

                ServidorAdm servidor = new ServidorAdm(nome, email, telefone, senha, matricula, cargo, departamento);
                cadastroServidor.cadastrar(servidor);
                System.out.println("Servidor cadastrado com sucesso!");
            }
            case PROFESSOR -> {
                System.out.println("Qual o curso? ");
                String curso = sc.nextLine();
                System.out.println("Qual o cargo? ");
                String cargo = sc.nextLine();

                Professor professor = new Professor(nome, email, telefone, senha, matricula, cargo, curso);
                cadastroProfessor.cadastrar(professor);
                System.out.println("Professor cadastrado com sucesso!");
            }
        }
    }
}
