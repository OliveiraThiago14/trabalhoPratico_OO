package org.fga.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.fga.util.Common;

@Getter
@Setter
@ToString(callSuper = true)
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
