package org.fga.painel;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void menu (){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        System.out.println("Qual o seu cargo na Universidade?" +
                "1 - Servidor" +
                "2 - Aluno");

        int cargo = sc.nextInt();

        MenuServidores menuServidores = new MenuServidores();
        MenuAluno menuAluno = new MenuAluno();

        switch (cargo){
            case 1: // Vai para o menu do servidor
                menuServidores.user();

            case 2: // Vai para o menu do aluno
                menuAluno.user();
        }
    }
}