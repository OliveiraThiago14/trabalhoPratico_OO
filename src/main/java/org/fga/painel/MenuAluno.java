package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.exceptions.EmailSenhaIncorretaException;
import org.fga.util.TipoUsuario;

import java.util.Scanner;

public class MenuAluno {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroAluno cadastroAluno = CadastroAluno.getInstancia();


    public static void goToMenu() {
        System.out.println("Informe seu email: ");
        String email = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();
        try {
            cadastroAluno.autenticar(email, senha);
        } catch (EmailSenhaIncorretaException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.println("Bem vindo ao menu dos alunos");
            System.out.println("1 - Mostrar Alunos");
            System.out.println("2 - Ir ao Menu de Espaços");
            System.out.println("3 - Voltar ao Menu Inicial");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> cadastroAluno.listar(TipoUsuario.ALUNO);
                case 2 -> MenuEspacoFisico.goToMenu(TipoUsuario.ALUNO);
                case 3 -> {
                    return;
                }
                default -> goToMenu();
            }
        }
    }
}
//atualizar - precisa de ID, método de receber dados recebe tipo de usuario

