package org.fga.cadastros;

import org.fga.entidades.ServidorAdm;

public class CadastroServidor extends CadastroUsuario<ServidorAdm>{
    private static CadastroServidor instancia;

    public static synchronized CadastroServidor getInstancia(){
        if(instancia != null){
            return instancia;
        }
        return instancia = new CadastroServidor();
    }

    public static listarServidor(){

    }
}
