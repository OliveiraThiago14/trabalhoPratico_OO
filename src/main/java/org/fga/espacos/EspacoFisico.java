package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;
import org.fga.entidades.Reserva;
import org.fga.util.Common;
import org.fga.util.Pair;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class EspacoFisico extends Common{
    private String nomeEspaco;
    private int capacidade;
    private String localizacao;
    private List<Pair<String, Integer>> equipamentos = new ArrayList<>();
    private List<Pair<String, Reserva>> historicoDeReservasFeitas = new ArrayList<>();
    private List<Reserva> reservasDoEspaco = new ArrayList<>();

    public EspacoFisico(String nomeEspaco , int capacidade, String localizacao) {
        this.nomeEspaco = nomeEspaco;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Nome do Espaco: " + nomeEspaco + ", Capacidade: " + capacidade + ", Localizacao: " + localizacao;
    }
}

