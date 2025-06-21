package org.fga.cadastros;

import org.fga.entidades.Professor;

public class CadastroProfessor extends CadastroUsuario<Professor>{
    private static CadastroProfessor instancia;

    public static synchronized CadastroProfessor getInstancia(){
        if(instancia != null) {
            return instancia;
        }
        return instancia = new CadastroProfessor();
    }
}
