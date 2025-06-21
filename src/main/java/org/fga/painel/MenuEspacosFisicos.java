package org.fga.painel;

import org.fga.Espacos.Auditorio;
import org.fga.Espacos.EspacosFisicos;
import org.fga.Espacos.Laboratorio;
import org.fga.Espacos.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuEspacosFisicos {
    Scanner sc = new Scanner(System.in);
    public EspacosFisicos cadastrarEspacoFisico() {
        List<String> equipamentos = new ArrayList<String>();
        List<String> disp = new ArrayList<>();
        System.out.println("Informe o tipo de espaço fisico que deseja cadastrar: ");
        System.out.println("1. Sala\n 2. Laboratorio\n 3. Auditorio");
        int tipoDeEspaco  = sc.nextInt();
        System.out.println("Informe a capacidade: ");
        int capacidade = sc.nextInt();
        System.out.println("Informe o localizacao: ");
        String loc = sc.nextLine();
        System.out.println("Informe a quantida de equipamentos: ");
        int qtd = sc.nextInt();

        while(qtd > 0) {
            String equip = sc.nextLine();
            equipamentos.add(equip);
            qtd--;
        }
        EspacosFisicos espaco = null;


        switch (tipoDeEspaco) {
            case 1:
                espaco = new Sala(capacidade, loc, disp ,equipamentos);
                break;
            case 2:
                espaco = new Laboratorio(capacidade, loc, disp, equipamentos);
                break;
            case 3:
                espaco = new Auditorio(capacidade, loc, disp, equipamentos);
                break;
            default:
                System.out.println("Erro ao cadastrar Espaco! Esse espaço fisico não existe");
                break;
        }

        return espaco;
    }
}
