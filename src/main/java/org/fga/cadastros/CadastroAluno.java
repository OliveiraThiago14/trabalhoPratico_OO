package org.fga.cadastros;

import org.fga.entidades.Aluno;

public class CadastroAluno extends CadastroUsuario<Aluno> {
    private static CadastroAluno instancia;

    public static CadastroAluno getInstacia() {
        if (instancia != null) {
            return instancia;
        }
        return instancia = new CadastroAluno();
    }
}