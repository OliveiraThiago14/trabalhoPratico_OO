package org.fga.exceptions;

import java.io.IOException;

public class DiasExcedidosException extends IOException {
    public DiasExcedidosException() {
        super("O número de dias excedeu o limite permitido para a reserva.");
    }
}
