package org.fga.Espacos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class Laboratorio extends EspacosFisicos {
    public Laboratorio(int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        super(capacidade, loc, disp, equipamentos);
    }

    @Override
    public void InformacaoEspaco() {
        System.out.println("Informações do Laboratorio:");
        System.out.println("Capacidade:" + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Disponibilidade: " + getDisp());
        System.out.println("Equipamentos: " + getEquipamentos());
    }
}
