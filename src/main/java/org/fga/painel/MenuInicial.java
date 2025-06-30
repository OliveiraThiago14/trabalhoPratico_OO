package org.fga.painel;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        System.out.println("Qual o seu cargo na Universidade?" +
                "1 - Professor/Servidor" +
                "2 - Aluno"
                    );

        int cargo = sc.nextInt();

        switch (cargo){
            case 1: // Servidor
                MenuServidores servidor = new MenuServidores();
                servidor.goToMenuServidores();


            case 2: //Aluno
                MenuAluno aluno = new MenuAluno();
                aluno.goToMenuAluno();
        }
    }
}