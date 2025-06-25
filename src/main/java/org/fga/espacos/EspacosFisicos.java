package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;
import org.fga.entidades.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Getter
@Setter

public abstract class EspacosFisicos {
    private String nomeEspaco;
    private int capacidade;
    private String loc;
    private List<String> equipamentos;
    private List<Reserva> reservasDoEspaco;
    private List<Reserva> historicoDeReservasFeitas;

    Scanner sc = new Scanner(System.in);
    public EspacosFisicos(String nomeEspaco ,int capacidade, String loc, List<String> disp, List<String> equipamentos) {
        this.nomeEspaco = nomeEspaco;
        this.capacidade = capacidade;
        this.loc = loc;
        this.reservasDoEspaco = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
        this.historicoDeReservasFeitas = new ArrayList<>();
    }

    public EspacosFisicos() {
    }

    public void reser(){
        for(Reserva reserva : getHistoricoDeReservasFeitas()){
            System.out.println(reserva);
        }
    }



    public boolean reservarEspaco(Reserva novaReserva) {
        for (Reserva reservasDoEspaco : getReservasDoEspaco()) {
            if (Reserva.sobreposicao(reservasDoEspaco, novaReserva)) {
                System.out.println("Reserva não concedida!");
                return false;
            }
        }
        System.out.println("Reserva Concedida!");
        getReservasDoEspaco().add(novaReserva);
        getHistoricoDeReservasFeitas().add(novaReserva);
        return true;
    }

    public void removerReserva(Reserva ReservaExistente) {
        if(getReservasDoEspaco().contains(ReservaExistente)) {
            getReservasDoEspaco().remove(ReservaExistente);
            System.out.println("Reserva removida com sucesso!");
        }
        System.out.println("Reserva não encontrada!");
    }

    public void informacaoEspaco() {
        System.out.println("Nome do Espaco: " + getNomeEspaco());
        System.out.println("Capacidade: " + getCapacidade());
        System.out.println("Localizacao: " + getLoc());
        System.out.println("Equipamentos: " + getEquipamentos());
        System.out.println("Reservas do Espaco: ");
        for (Reserva reservasDoEspaco : getReservasDoEspaco()) {
            System.out.println(reservasDoEspaco);
        }
    }



    }

