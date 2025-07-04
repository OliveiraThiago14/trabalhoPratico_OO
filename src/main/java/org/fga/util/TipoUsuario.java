package org.fga.util;

import lombok.Getter;

@Getter
public enum TipoUsuario {
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    SERVIDOR("Servidor");

    private String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }
}
