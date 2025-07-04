package org.fga.cadastros;

import lombok.Getter;
import org.fga.entidades.Reserva;
import org.fga.espacos.EspacoFisico;
import org.fga.util.Pair;
import org.fga.util.TipoEspacoFisico;
import org.fga.util.TipoReserva;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
public class CadastroEspacoFisico extends Cadastro<EspacoFisico> {
    List<Pair<String, Integer>> equipamentos = new ArrayList<>();
    private List<Pair<String, Reserva>> historicoDeReservasFeitas = new ArrayList<>();
    private List<Reserva> reservasDoEspaco = new ArrayList<>();

    public static CadastroEspacoFisico getInstancia() {
        return CadastroEspacoFisico.getInstancia();
    }

    public Integer getIdByNome(String nome) {
        for (Pair<EspacoFisico, OffsetDateTime> found : db) {
            if (found.getFirst().getNomeEspaco().equals(nome)) {
                return found.getFirst().getId();
            }
        }
        return null;
    }

    public void cadastrarEquipamento(String nome, Integer quantidade) {
        for (Pair<String, Integer> equipamento : equipamentos) {
            if (equipamento.getFirst().equals(nome)) {
                System.out.println("Equipamento já cadastrado!");
                return;
            }
        }
        equipamentos.add(new Pair<>(nome, quantidade));
    }
    public void listarEquipamento(TipoEspacoFisico tipo) {
        for (Pair<String, Integer> equipamento : equipamentos) {
            System.out.println("Equipamento: " + equipamento.getFirst() + " Quantidade: " + equipamento.getSecond());
        }
    }

    public boolean reservarEspaco(Reserva novaReserva) {
        for (Reserva reservasDoEspaco : reservasDoEspaco) {
            if (Reserva.sobreposicao(reservasDoEspaco, novaReserva)) {
                System.out.println("Reserva não concedida!");
                return false;
            }
        }
        System.out.println("Reserva Concedida!");
        reservasDoEspaco.add(novaReserva);
        historicoDeReservasFeitas.add(new Pair<>(TipoReserva.ADD.getDescricao(), novaReserva));
        return true;
    }

    public void removerReserva(Reserva reservaExistente) {
        if(reservasDoEspaco.contains(reservaExistente)) {
            reservasDoEspaco.remove(reservaExistente);
            System.out.println("Reserva removida com sucesso!");
        }
        historicoDeReservasFeitas.add(new Pair<>(TipoReserva.DELETE.getDescricao(), reservaExistente));
        System.out.println("Reserva não encontrada!");
    }

    public void historicoReservas(){
        for(var reserva : historicoDeReservasFeitas){
            System.out.println(reserva.getSecond());
        }
    }

}