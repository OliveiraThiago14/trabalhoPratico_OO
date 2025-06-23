package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Scanner;

@Getter
@AllArgsConstructor
public class Reserva {
    private Integer dtInicio;
    private Integer dtFim;
    private Integer hrInicio;
    private Integer hrFim;




    public static boolean sobreposicao(Reserva r1, Reserva r2){
        boolean sobreposicaoDeDias = (r1.dtInicio <= r2.dtFim && r1.dtFim >= r2.dtInicio);

        if (!sobreposicaoDeDias) {
            return false;
        }

        boolean sobreposicaoDeHoras = !(r1.hrFim <= r2.hrInicio || r1.hrInicio >= r2.hrFim);

        return sobreposicaoDeHoras;
    }


}
