package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Laboratorio extends EspacosFisicos {
    public Laboratorio(String nomeEspaco, int capacidade, String loc) {
        super(nomeEspaco, capacidade, loc);
    }
}
