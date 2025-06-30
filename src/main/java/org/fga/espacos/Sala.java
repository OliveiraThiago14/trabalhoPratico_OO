package org.fga.espacos;

public class Sala extends EspacosFisicos{
    public Sala(String nomeEspaco,int capacidade, String loc) {
        super(nomeEspaco, capacidade, loc);
    }

    @Override
    public void informacaoEspaco() {
        System.out.println("Informações da Sala:");
        System.out.println("Capacidade:" + getCapacidade());
        System.out.println("Localizacao: " + getLocalizacao());
    }
}
