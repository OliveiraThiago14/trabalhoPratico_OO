package org.fga.exceptions;

public class HorarioIndisponivelException extends RuntimeException {
    public HorarioIndisponivelException() {
        super("Horário indisponível para reserva.");
    }
}
