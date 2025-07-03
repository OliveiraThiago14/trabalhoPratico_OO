package org.fga.cadastros;

import lombok.Getter;
import org.fga.entidades.Usuario;
import org.fga.util.Common;
import org.fga.util.Pair;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Cadastro<T extends Common> {
    @Getter
    protected Integer num = 0;
    protected List<Pair<T, OffsetDateTime>> db = new ArrayList<>();

    public Integer cadastrar(T usuario){
        if(buscar(usuario.getId()) != null) {
            return null;
        }
        Pair<T, OffsetDateTime> par = new Pair<>(usuario, OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        par.getFirst().setId(++num);
        db.add(par);
        return num;
    }

    public T buscar(Integer id){
        if(id == null) return null;
        return db.get(id-1).getFirst();
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

    protected abstract void listar(String tipo);
}
