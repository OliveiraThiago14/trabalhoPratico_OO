package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;
import org.fga.util.Common;
import org.fga.entidades.Reserva;
import org.fga.util.Pair;
import org.fga.util.TipoReserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public abstract class EspacosFisicos extends Common{
    private String nomeEspaco;
    private int capacidade;
    private String localizacao;

    public EspacosFisicos(String nomeEspaco ,int capacidade, String localizacao) {
        this.nomeEspaco = nomeEspaco;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
    }

    public void informacaoEspaco() {
        System.out.println("Nome do Espaco: " + nomeEspaco);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Localizacao: " + localizacao);
    }
}

