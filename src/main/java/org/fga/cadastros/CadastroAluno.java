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

    @Override
    public void listar(String tipo){
        System.out.println("\n" + tipo +" cadastrados:");
        for (Pair<Aluno, OffsetDateTime> par : db){
            System.out.println("\n" + tipo + " " + par.getFirst().toString());
        }
    }
}