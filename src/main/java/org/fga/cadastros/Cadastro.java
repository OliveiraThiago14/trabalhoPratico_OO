package org.fga.cadastros;

import org.fga.util.Common;
import org.fga.util.Pair;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Cadastro<T extends Common> {
    protected Integer num = 0;
    protected List<Pair<T, OffsetDateTime>> db = new ArrayList<>();

    public Integer cadastrar(T usuario){
        if(buscar(usuario.getId()) != null) {
            return null;
        }
        db.add(new Pair<>(usuario, OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)));
        num++;
        return num;
    }

    public T buscar(Integer id){
        for (Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getId() == id) {
                return found.getFirst();
            }
        }
        return null;
    }

    public boolean atualizar(Integer id, T usuario) {
        for(Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getId() == id) {
                found.setFirst(usuario);
                found.setSecond(OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS));
                return true;
            }
        }
        return false;
    }
}
