package org.fga.cadastros;

import org.fga.entidades.Usuario;

public abstract class Cadastro {
    protected Integer num = 0;
    public abstract Integer cadastrar(Usuario usuario);
    public abstract Usuario buscar(String matricula);
    public abstract boolean atualizar(String matricula, Usuario usuario);
}
