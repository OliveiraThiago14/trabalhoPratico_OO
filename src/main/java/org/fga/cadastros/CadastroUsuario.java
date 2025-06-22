package org.fga.cadastros;

import org.fga.entidades.Usuario;
import org.fga.util.Pair;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario<T extends Usuario> extends Cadastro {
    private List<Pair<T, OffsetDateTime>> db = new ArrayList<>();

    @Override
    public Integer cadastrar(T usuario){
        if(buscar(usuario.getMatricula()) != null) {
            return 0;
        }
        db.add(new Pair<>(usuario, OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)));
        num++;
        return num;
    }

    @Override
    public T buscar(String matricula){
        for (Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getMatricula().equals(matricula)) {
                return found.getFirst();
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(String matricula, T usuario) {
        for(Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getMatricula().equals(matricula)) {
                found.setFirst(usuario);
                found.setSecond(OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS));
                return true;
            }
        }
        return false;
    }
}
