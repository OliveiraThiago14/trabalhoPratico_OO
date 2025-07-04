package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.Aluno;
import org.fga.entidades.Professor;
import org.fga.entidades.Usuario;
import org.fga.util.TipoUsuario;

public class TestesAluno {
    public static void main(String[] args) {
        MenuEspacoFisico menuEspaco = new MenuEspacoFisico();
        menuEspaco.goToMenu(TipoUsuario.PROFESSOR);
    }
}
