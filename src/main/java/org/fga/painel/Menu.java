package org.fga.painel;

import org.fga.cadastros.CadastroProfessor;
import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.Professor;
import org.fga.exceptions.DiasExcedidosException;

public class Menu {
    public static void main(String[] args) throws DiasExcedidosException {
        CadastroServidor cadastroServidor = CadastroServidor.getInstancia();
        CadastroProfessor cadastroProfessor = CadastroProfessor.getInstancia();

        Professor professor = new Professor("pedro", "pedro@gmail.com", "61992138123", "pedro", "241011546", "prof", "eng");
        cadastroProfessor.cadastrar(professor);
    }
}