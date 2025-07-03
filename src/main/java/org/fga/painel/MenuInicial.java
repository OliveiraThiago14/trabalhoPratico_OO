package org.fga.painel;

import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.ServidorAdm;

import java.util.Scanner;


public abstract class MenuInicial {
    public static void menuInicial(){
        Scanner sc = new Scanner(System.in);

        //Identificar cargo do usuário
        System.out.println("Qual o seu cargo na Universidade?\n1 - Professor\n2 - Servidor administrativo\n3 - Aluno");

        int cargo = sc.nextInt();

        switch (cargo){
            case 1 -> MenuProfessor.goToMenu();
            case 2 -> MenuServidor.goToMenuServidor();
            case 3 -> MenuAluno.goToMenuAluno();
        }
    }
}