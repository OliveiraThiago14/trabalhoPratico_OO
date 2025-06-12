package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.entidades.Aluno;

public class MenuAluno {
    public static void main(String[] args) {
        Aluno aluno;
        aluno = new Aluno("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenharias","241011600", "terceiro");
        CadastroAluno.getInstacia();
        CadastroAluno a = new CadastroAluno();
        a.cadastrarAluno(aluno);
    }
}
