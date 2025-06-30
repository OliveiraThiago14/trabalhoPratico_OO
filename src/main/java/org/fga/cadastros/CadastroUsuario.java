package org.fga.cadastros;

import org.fga.entidades.Usuario;
import org.fga.util.Pair;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario<T extends Usuario> extends Cadastro<T> {
    public Integer getIdByMatricula(String matricula) {
        for (Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getMatricula().equals(matricula)) {
                return found.getFirst().getId();
            }
        }
        return null;
    }
}
