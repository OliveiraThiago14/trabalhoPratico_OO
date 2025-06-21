package org.fga.painel;

import org.fga.cadastros.CadastroAluno;
import org.fga.cadastros.CadastroProfessor;
import org.fga.entidades.Aluno;
import org.fga.entidades.Professor;

public class MenuAluno {
    public static void main(String[] args) {
        Aluno a, a1;
        Professor p, p1;
        a = new Aluno("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenharias","241011600", "terceiro");
        p = new Professor("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenharias","241011600", "terceiro");
        a1 = new Aluno("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenharias","341011600", "terceiro");
        p1 = new Professor("Thiago", "thi@aluno.unb.br", "61982898289","0101","engenhaaa","441011600", "terceiro");
        CadastroAluno ca = CadastroAluno.getInstacia();
        CadastroProfessor cp = CadastroProfessor.getInstancia();
        CadastroProfessor cp2 = CadastroProfessor.getInstancia();
        System.out.println(ca.cadastrar(a));
        System.out.println(cp.cadastrar(p));
        System.out.println(ca.cadastrar(a1));
        System.out.println(cp.cadastrar(p1));
        System.out.println(cp2.cadastrar(p));
        System.out.println(ca.buscar("241011600"));
        System.out.println(ca.atualizar("241011600", a1));
        System.out.println(ca.buscar("241011600"));
        System.out.println(ca.buscar("341011600"));
    }
}
