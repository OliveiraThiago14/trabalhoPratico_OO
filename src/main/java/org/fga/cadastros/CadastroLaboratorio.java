package org.fga.cadastros;


public class CadastroLaboratorio extends CadastroEspacoFisico {
    public static CadastroLaboratorio instancia;

    public static synchronized CadastroLaboratorio getInstancia() {
        if (instancia == null) {
            instancia = new CadastroLaboratorio();
        }
        return instancia;
    }
}
