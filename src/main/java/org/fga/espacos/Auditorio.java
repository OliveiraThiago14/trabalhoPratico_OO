package org.fga.espacos;

import java.util.List;

public class Auditorio extends EspacosFisicos{
    public Auditorio(String nomeEspaco, int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        super(nomeEspaco, capacidade, loc, disp, equipamentos);
    }

    @Override
    public void InformacaoEspaco() {
        System.out.println("Informações do Auditorio:");
        System.out.println("Capacidade:" + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Disponibilidade: " + getReservasDoEspaco());
        System.out.println("Equipamentos: " + getEquipamentos());
    }
}
