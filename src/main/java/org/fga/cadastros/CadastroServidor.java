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
        instancia = new CadastroServidor();
        ServidorAdm primeiroServidor = new ServidorAdm("thiago", "gustavo@gmail.com", "guilherme", "pedro", "adm", "tudo", "tudo");
        instancia.cadastrar(primeiroServidor);
        return instancia;
    }
}
