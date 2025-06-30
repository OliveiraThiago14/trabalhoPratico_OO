package org.fga.util;

import lombok.Getter;

@Getter
public enum TipoReserva {
    DELETE("Delete"),
    ADD("Add");

    private String descricao;

    TipoReserva(String descricao) {
        this.descricao = descricao;
    }
}
