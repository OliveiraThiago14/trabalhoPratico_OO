package org.fga.painel;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void menuInicial(){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        while (true) {
            System.out.println("Qual o seu cargo na Universidade?\n1 - Professor\n2 - Aluno\n3 - Servidor\n4 - Sair");

            int cargo = sc.nextInt();

<<<<<<< HEAD
        switch (cargo){
            case 1 -> MenuServidores.goToMenuServidores();
            case 2 -> MenuAluno.goToMenuAluno();

=======
            switch (cargo) {
                case 1 -> MenuProfessor.goToMenu();
                case 2 -> MenuAluno.goToMenuAluno();
                case 4 -> {
                    return;
                }
            }
>>>>>>> 1f1e54eafaec6c574a969cdf2ed3cca87a268540
        }
    }

}