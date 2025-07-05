package org.fga.painel;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void menuInicial(){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        while (true) {
            System.out.println("Qual o seu cargo na Universidade?\n1 - Aluno\n2 - Servidor\n3 - Professor\n4 - Sair");

            int cargo = sc.nextInt();
            sc.nextLine();

            switch (cargo) {
                case 1 -> MenuAluno.goToMenu();
                case 2 -> MenuServidor.goToMenu();
                case 3 -> MenuProfessor.goToMenu();
                case 4 -> {
                    return;
                }
            }
        }
    }
}