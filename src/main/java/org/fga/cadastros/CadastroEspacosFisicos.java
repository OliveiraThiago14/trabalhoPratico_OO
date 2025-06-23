package org.fga.cadastros;

import org.fga.espacos.Auditorio;
import org.fga.espacos.EspacosFisicos;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroEspacosFisicos {
    private static List<EspacosFisicos> listaDeEspacos = new ArrayList<>();
    public static CadastroEspacosFisicos instancia;
    Scanner sc = new Scanner(System.in);


    public static synchronized CadastroEspacosFisicos getInstancia() {
        if (instancia == null) {
            instancia = new CadastroEspacosFisicos();
        }
        return instancia;
    }

    public void cadastrar(EspacosFisicos espacos) {
        if(buscarEspacos(espacos.getNomeEspaco()) != null){
            System.out.println("Espaco ja existe!");
        }
        else{
            cadastrarEspacoFisico();
            System.out.println("Espaco cadastrado com sucesso!");
        }

    }

    public EspacosFisicos buscarEspacos(String nomeEspaco) {
        for(EspacosFisicos espaco : listaDeEspacos) {
            if(espaco.getNomeEspaco().equals(nomeEspaco)){
                return espaco;
            }
        }
        return null;
    }

    public static void listarEspacos() {
        System.out.println("\nEspacos cadastrados:");
        for(EspacosFisicos espaco : listaDeEspacos) {
            System.out.println(espaco.toString());
        }
    }


    public static EspacosFisicos cadastrarEspacoFisico() {
        Scanner sc = new Scanner(System.in);
        List<String> equipamentos = new ArrayList<>();
        List<String> disp = new ArrayList<>();
        System.out.println("Informe o tipo de espaço fisico que deseja cadastrar: ");
        System.out.println("1. Sala\n 2. Laboratorio\n 3. Auditorio");
        int tipoDeEspaco  = sc.nextInt();
        System.out.println("Informe o nome do espaco: ");
        String nomeEspaco = sc.next();
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
                listaDeEspacos.add(new Sala(nomeEspaco, capacidade, loc, disp , equipamentos));
                break;
            case 2:
                listaDeEspacos.add(new Laboratorio(nomeEspaco, capacidade, loc, disp , equipamentos));
                break;
            case 3:
                listaDeEspacos.add(new Auditorio(nomeEspaco, capacidade, loc, disp , equipamentos));
                break;
            default:
                System.out.println("Erro ao cadastrar Espaco! Esse espaço fisico não existe");
                break;
        }
        return espaco;


}

}




