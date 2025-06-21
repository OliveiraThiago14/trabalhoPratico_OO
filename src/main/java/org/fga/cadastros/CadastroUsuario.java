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
    public Integer cadastrar(Usuario usuario){
        T usuarioNovo = (T) usuario;
        if(buscar(usuarioNovo.getMatricula()) != null) {
            return 0;
        }
        db.add(new Pair<>(usuarioNovo, OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)));
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
    public boolean atualizar(String matricula, Usuario usuario) {
        T usuarioNovo = (T) usuario;
        for(Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getMatricula().equals(matricula)) {
                found.setFirst(usuarioNovo);
                found.setSecond(OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS));
                return true;
            }
        }
        return false;
    }
}