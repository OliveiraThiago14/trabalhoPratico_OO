package org.fga.cadastros;

import org.fga.espacos.Auditorio;

public class CadastroAuditorio extends CadastroEspacoFisico<Auditorio> {
    public static CadastroAuditorio instancia;

    public static synchronized CadastroAuditorio getInstancia() {
        if (instancia == null) {
            instancia = new CadastroAuditorio();
        }
        return instancia;
    }
}
