package org.fga.cadastros;

import lombok.Getter;
import org.fga.entidades.Usuario;
import org.fga.util.Common;
import org.fga.util.Pair;
import org.fga.util.TipoUsuario;
import org.fga.util.TipoEspacoFisico;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cadastro<T extends Common> {
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

    public void delete(Integer id) {
        for (Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getId() == id) {
                db.remove(found);
                return;
            }
        }
    }

    public void listar(TipoUsuario tipo){
        System.out.println("\n" + tipo.getTipo() + " cadastrados:");
        for (Pair<T, OffsetDateTime> par : db){
            System.out.println(par.getFirst().toString());
        }
    }

    public void listar(TipoEspacoFisico tipo){
        System.out.println("\n" + tipo.getTipo() + " cadastrados:");
        for (Pair<T, OffsetDateTime> par : db){
            System.out.println(par.getFirst().toString());
        }
    }
}
