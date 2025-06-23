package org.fga.espacos;

import org.fga.entidades.Reserva;

import java.util.List;

public class Sala extends EspacosFisicos{
    public Sala(String nomeEspaco,int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        super(nomeEspaco, capacidade, loc, disp, equipamentos);
    }

    public Sala() {

    }

    public void reser(){
        for(Reserva reserva : getHistoricoDeReservasFeitas()){

        }
    }

    @Override
    public void informacaoEspaco() {
        System.out.println("Informações da Sala:");
        System.out.println("Capacidade:" + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Disponibilidade: " + getReservasDoEspaco());
        System.out.println("Equipamentos: " + getEquipamentos());
    }
}
