package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.entidades.Aluno;
import java.util.Scanner;

public class MenuAluno {
    static Scanner sc = new Scanner(System.in);

    public static void goToMenuAluno() {
        System.out.println("Bem vindo ao menu dos alunos");
        System.out.println("1 - Mostrar Alunos");
        System.out.println("2 - Ir ao Menu de Espaços");
        System.out.println("3 - Voltar ao Menu Inicial");

        int escolha = sc.nextInt();
        CadastroAluno cadastroAluno = CadastroAluno.getInstancia();
        MenuEspacoFisico menuEspaco = new MenuEspacoFisico();

        switch (escolha) {
            case 1 -> cadastroAluno.listarAluno();
            case 2 -> menuEspaco.menuEspaco();
            case 3 -> MenuInicial.menuInicial();
            default -> goToMenuAluno();
        }
        goToMenuAluno();
    }

}
