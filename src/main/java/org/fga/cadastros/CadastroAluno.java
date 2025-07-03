package org.fga.cadastros;

import org.fga.entidades.Aluno;
import org.fga.util.Pair;

import java.time.OffsetDateTime;

public class CadastroAluno extends CadastroUsuario<Aluno> {
    private static CadastroAluno instancia;

    public static CadastroAluno getInstancia() {
        if (instancia != null) {
            return instancia;
        }
        return instancia = new CadastroAluno();
    }

}