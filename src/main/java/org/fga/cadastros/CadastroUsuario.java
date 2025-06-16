package org.fga.cadastros;

import org.fga.entidades.Usuario;

public abstract class CadastroUsuario {
    private Integer num;
    public abstract Integer cadastrar(Usuario usuario);
    public abstract Usuario buscar(String matricula);
    public abstract boolean atualizar(String matricula, Usuario usuario);
}
