package org.fga.painel;

import org.fga.cadastros.CadastroEspacosFisicos;
import org.fga.espacos.Auditorio;
import org.fga.espacos.EspacosFisicos;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.fga.cadastros.CadastroEspacosFisicos.cadastrarEspacoFisico;

public class MenuEspacosFisicos {
    Scanner sc = new Scanner(System.in);


    public void MenuEspaco() {

        System.out.println("\nBem vindo ao Menu de Espacos Fisicos\n Escolha um opção: ");
        System.out.println("1 - Cadastrar Espaco Fisico");
        System.out.println("2 - Mostrar Espacos Fisicos");
        System.out.println("3 - Fazer Reserva de Espaco Fisicos");
        System.out.println("4 - Exibir Historico de Reservas Feitas Em Um Determinado Espaco Fisicos");
        System.out.println("5 - Sair do Menu");
        CadastroEspacosFisicos cad = new CadastroEspacosFisicos();

        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                cadastrarEspacoFisico();
                break;
            case 2:
                cad.ListaDeEspacos();
                break;
            case 3:



        }


    }

    private void Desicoes(){
        System.out.println("Escolha o Espaco Fisico que Deseja Reservar: ");
        System.out.println("1- Sala\n 2- Laboratorio\n 3- Auditorio ");
        int op = sc.nextInt();

        switch (op) {
            case 1:


        }
    }



}
