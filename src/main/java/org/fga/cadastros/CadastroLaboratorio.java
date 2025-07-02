package org.fga.cadastros;

import org.fga.espacos.Laboratorio;

public class CadastroLaboratorio extends CadastroEspacoFisico<Laboratorio> {
    public static CadastroLaboratorio instancia;

    public static synchronized CadastroLaboratorio getInstancia() {
        if (instancia == null) {
            instancia = new CadastroLaboratorio();
        }
        return instancia;
    }
}
