package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fga.util.Common;

@Getter
@Setter
@AllArgsConstructor
public class Usuario extends Common {
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String matricula;
}
