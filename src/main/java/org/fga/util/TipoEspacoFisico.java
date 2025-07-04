package org.fga.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoEspacoFisico {
    SALA("Sala"),
    AUDITORIO("Auditório"),
    LABORATORIO("Laboratório");

    private String tipo;
}
