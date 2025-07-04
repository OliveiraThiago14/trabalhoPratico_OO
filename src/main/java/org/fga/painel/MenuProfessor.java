package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.exceptions.EmailSenhaIncorretaException;
import org.fga.util.TipoUsuario;

import java.util.Scanner;

public class MenuProfessor {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroProfessor cadastroProfessor = CadastroProfessor.getInstancia();
    private static final CadastroAluno cadastroAluno = CadastroAluno.getInstancia();

    public static void goToMenu() {
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();
        try {
            cadastroProfessor.autenticar(email, senha);
        } catch (EmailSenhaIncorretaException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.println("Bem vindo ao Menu do Professor\nEscolha uma opção:");
            System.out.println("1 - Menu de Espaços Físicos");
            System.out.println("2 - Consultar Alunos");
            System.out.println("3 - Sair do Menu");

            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1 -> MenuEspacoFisico.goToMenu(TipoUsuario.PROFESSOR);
                case 2 -> cadastroAluno.listar(TipoUsuario.ALUNO);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Escolha uma opção válida!");
            }
        }
    }
}
