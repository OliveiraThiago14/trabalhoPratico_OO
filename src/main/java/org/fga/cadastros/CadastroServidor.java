package org.fga.cadastros;

import org.fga.entidades.ServidorAdm;
import org.fga.util.Pair;

import java.time.OffsetDateTime;

public class CadastroServidor extends CadastroUsuario<ServidorAdm>{
    private static CadastroServidor instancia;

    public static synchronized CadastroServidor getInstancia(){
        if(instancia != null){
            return instancia;
        }
        return instancia = new CadastroServidor();
    }
}
