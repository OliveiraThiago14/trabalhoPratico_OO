package org.fga.espacos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Laboratorio extends EspacoFisico {
    public Laboratorio(String nomeEspaco, int capacidade, String loc) {
        super(nomeEspaco, capacidade, loc);
    }
}
