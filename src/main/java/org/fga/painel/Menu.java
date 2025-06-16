package org.fga.painel;

import org.fga.cadastros.CadastroProfessores;
import org.fga.cadastros.CadastroServidores;
import org.fga.entidades.Professor;
import org.fga.exceptions.DiasExcedidosException;


public class Menu {
    public static void main(String[] args) throws DiasExcedidosException {
        CadastroServidores cadastroServidores = CadastroServidores.getInstancia();
        CadastroProfessores cadastroProfessores = CadastroProfessores.getInstancia();

        Professor professor = new Professor("pedro", "pedro@gmail.com", "61992138123", "pedro", "241011546", "prof", "eng");
        cadastroProfessores.cadastrarProf(professor);
    }
}