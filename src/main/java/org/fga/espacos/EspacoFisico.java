package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;
import org.fga.util.Common;

@Getter
@Setter
public abstract class EspacoFisico extends Common{
    private String nomeEspaco;
    private int capacidade;
    private String localizacao;

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

