package org.fga.painel;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void menuInicial(){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        System.out.println("Qual o seu cargo na Universidade?\n1 - Professor/Servidor\n2 - Aluno");

        int cargo = sc.nextInt();

        switch (cargo){
            case 1 -> MenuServidores.goToMenuServidores();
            case 2 -> MenuAluno.goToMenuAluno();
        }
    }
}