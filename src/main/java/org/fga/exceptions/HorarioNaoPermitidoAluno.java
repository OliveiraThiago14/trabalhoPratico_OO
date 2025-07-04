package org.fga.exceptions;
import java.io.IOException;
import java.lang.Exception;

public class HorarioNaoPermitidoAluno extends IOException {
    public HorarioNaoPermitidoAluno() {
        super("Horario nao permitido para alunos.");
    }
}
