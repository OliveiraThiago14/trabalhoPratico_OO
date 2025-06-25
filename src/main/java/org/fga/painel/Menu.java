package org.fga.painel;

import java.util.Scanner;


public abstract class Menu {
    public static void menu (){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        System.out.println("Qual o seu cargo na Universidade?" +
                "1 - Servidor" +
                "2 - Aluno");

        int cargo = sc.nextInt();

        switch (cargo){
            case 1: // Servidor
                MenuServidores;

            case 2: //Aluno
                MenuAluno;
        }



    }
}