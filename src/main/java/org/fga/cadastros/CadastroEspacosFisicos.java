package org.fga.cadastros;

import org.fga.espacos.EspacosFisicos;
import org.fga.util.Pair;

import java.time.OffsetDateTime;

public class CadastroEspacosFisicos extends Cadastro<EspacosFisicos> {
    public static CadastroEspacosFisicos instancia;

    public static synchronized CadastroEspacosFisicos getInstancia() {
        if (instancia == null) {
            instancia = new CadastroEspacosFisicos();
        }
        return instancia;
    }

    public Integer getIdByNome(String nome) {
        for (Pair<EspacosFisicos, OffsetDateTime> found : getInstancia().db) {
            if (found.getFirst().getNomeEspaco().equals(nome)) {
                return found.getFirst().getId();
            }
        }
        return null;
    }

    public void listarEspacos() {
        System.out.println("\nEspacos cadastrados:");
        for (Pair<EspacosFisicos, OffsetDateTime> par : getInstancia().db) {
            System.out.println(par.getFirst().toString());
        }
    }
}