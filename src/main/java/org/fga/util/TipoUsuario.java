package org.fga.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    SERVIDOR("Servidor");

    private String tipo;
}
