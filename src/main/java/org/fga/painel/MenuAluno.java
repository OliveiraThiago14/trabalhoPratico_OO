package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.entidades.Aluno;
import org.fga.exceptions.EmailSenhaIncorretaException;

import java.util.Scanner;

public class MenuAluno {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroAluno cadastroAluno = CadastroAluno.getInstancia();


    public static void goToMenuAluno() {
        System.out.println("Informe o seu email: ");
        String email = sc.nextLine();
        System.out.println("Informe a sua senha: ");
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
                case 1 -> cadastroAluno.listar("Aluno");
                case 2 -> MenuEspacoFisico.menuEspaco();
                case 3 -> MenuInicial.menuInicial();
                default -> goToMenuAluno();
            }
            goToMenuAluno();
        }
    }

}
