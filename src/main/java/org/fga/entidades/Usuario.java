package org.fga.entidades;

import lombok.*;
import org.fga.util.Common;

@Getter
@Setter
@AllArgsConstructor
public class Usuario extends Common {
    public Usuario() {
    }
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String matricula;
}
