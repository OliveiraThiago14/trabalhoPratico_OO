package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class Laboratorio extends EspacosFisicos {
    public Laboratorio(String nomeEspaco, int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        super(nomeEspaco, capacidade, loc, disp, equipamentos);
    }

    @Override
    public void InformacaoEspaco() {
        System.out.println("Informações do Laboratorio:");
        System.out.println("Capacidade:" + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Disponibilidade: " + getReservasDoEspaco());
        System.out.println("Equipamentos: " + getEquipamentos());
    }
}
