package org.fga.cadastros;

import org.fga.espacos.Sala;

public class CadastroSala extends CadastroEspacosFisicos<Sala>{
    private static CadastroSala instancia;

    public static synchronized CadastroSala getInstancia() {
        if (instancia == null) {
            instancia = new CadastroSala();
        }
        return instancia;
    }
}
