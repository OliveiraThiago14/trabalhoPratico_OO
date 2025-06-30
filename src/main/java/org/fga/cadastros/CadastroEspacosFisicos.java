package org.fga.cadastros;

import lombok.ToString;
import org.fga.entidades.Reserva;
import org.fga.espacos.EspacosFisicos;
import org.fga.util.Pair;
import org.fga.util.TipoReserva;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class CadastroEspacosFisicos<T extends EspacosFisicos> extends Cadastro<T> {
    List<Pair<String, String>> equipamentos = new ArrayList<>();
    private List<Pair<String, Reserva>> historicoDeReservasFeitas;
    private List<Reserva> reservasDoEspaco;

    public Integer getIdByNome(String nome) {
        for (Pair<T, OffsetDateTime> found : db) {
            if (found.getFirst().getNomeEspaco().equals(nome)) {
                return found.getFirst().getId();
            }
        }
        return null;
    }

    public void listarEspacos() {
        System.out.println("\nEspacos cadastrados:");
        for (Pair<T, OffsetDateTime> par : db) {
            System.out.println(par.getFirst().toString());
        }
    }

    public void cadastrarEquipamento(String nome, String descricao) {
        for (Pair<String, String> equipamento : equipamentos) {
            if (equipamento.getFirst().equals(nome)) {
                System.out.println("Equipamento já cadastrado!");
                return;
            }
        }
        equipamentos.add(new Pair<>(nome, descricao));
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