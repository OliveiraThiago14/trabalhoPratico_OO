package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.cadastros.CadastroServidor;
import org.fga.entidades.Aluno;
import org.fga.entidades.Professor;

public class TestesAluno {
    public static void main(String[] args) {
        Aluno a1,a2,a3,a4;
        a1 = new Aluno("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenharias","241011600", "terceiro");
        a2 = new Aluno("Pedro", "pam@gmail.com", "61981818982", "0000", "eng de software", "241011655", "terceiro");
        a3 = new Aluno("Gustava", "guga@gmail.com", "982345567", "0901", "eng de software", "241011455", "terceiro");
        a4 = new Aluno("Guilherme", "guibala@gmail.com", "982423588", "0405", "eng de soft", "241011877", "terceiro");
        CadastroAluno.getInstacia();
        CadastroAluno a = new CadastroAluno();
        MenuAluno menu = new MenuAluno();
        a.cadastrar(a1);
        a.cadastrar(a2);
        a.cadastrar(a3);
        a.cadastrar(a4);
        Aluno a33 = new Aluno("Gustavo", "guga@gmail.com", "982345567", "0901", "eng de software", "241011455", "terceiro");
        a.atualizar("241011455", a33);

        CadastroServidor cadastroServidores = CadastroServidor.getInstancia();
        CadastroProfessor cadastroProfessores = CadastroProfessor.getInstancia();

        Professor professor = new Professor("pedro", "pedro@gmail.com", "61992138123", "pedro", "241011546", "prof", "eng");
        cadastroProfessores.cadastrar(professor);
    }
}
