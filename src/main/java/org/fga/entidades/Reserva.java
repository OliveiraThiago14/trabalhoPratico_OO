package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

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

    @Override
    public String toString() {
        return STR."Reserva{dtInicio=\{dtInicio}, dtFim=\{dtFim}, hrInicio=\{hrInicio}, hrFim=\{hrFim}}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva other = (Reserva) obj;
        return Objects.equals(dtInicio, other.dtInicio) &&
               Objects.equals(dtFim, other.dtFim) &&
               Objects.equals(hrInicio, other.hrInicio) &&
               Objects.equals(hrFim, other.hrFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtInicio, dtFim, hrInicio, hrFim);
    }
}
