package org.fga.Espacos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Scanner;
@Getter
@Setter

public abstract class EspacosFisicos {
    private int capacidade;
    private String loc;
    private List<String> disp;
    private List<String> equipamentos;
    Scanner sc = new Scanner(System.in);
    public EspacosFisicos(int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        this.capacidade = capacidade;
        this.loc = loc;
        this.disp = disp;
        this.equipamentos = equipamentos;
    }



    public void InformacaoEspaco() {
        System.out.println("Capacidade: " + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Disponibilidade: " + getDisp());
        System.out.println("Equipamentos: " + getEquipamentos());
    }

    }

