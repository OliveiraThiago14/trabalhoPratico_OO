package org.fga.painel;

import org.fga.cadastros.CadastroProfessores;
import org.fga.cadastros.CadastroServidores;
import org.fga.entidades.Professor;
import org.fga.exceptions.DiasExcedidosException;
import org.fga.entidades.Aluno;

public abstract class Menu {

    protected abstract Aluno dadosNovo(String matricula);

    protected abstract String lerNome(String matricula);
    protected abstract String lerEmail(String matricula);
    protected abstract String lerMatricula(String nome);
    protected abstract String lerCurso(String matricula);
    protected abstract String lerTelefone(String matricula);
    protected abstract String lerSemestre(String matricula);
}