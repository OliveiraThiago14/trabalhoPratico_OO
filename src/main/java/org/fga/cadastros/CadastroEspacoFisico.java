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

    public void cadastrarEquipamento(Integer idEspaco, String nomeEquipamento, Integer quantidadeEquipamento) {
        var equipamentos = buscar(idEspaco).getEquipamentos();
        for (Pair<String, Integer> equipamento : equipamentos) {
            if (equipamento.getFirst().equals(nomeEquipamento)) {
                equipamento.setSecond(equipamento.getSecond() + quantidadeEquipamento);
                return;
            }
        }
        equipamentos.add(new Pair<>(nomeEquipamento, quantidadeEquipamento));
    }

    public void listarEquipamento(int idEspaco) {
        var equipamentos = buscar(idEspaco).getEquipamentos();
        for (Pair<String, Integer> equipamento : equipamentos) {
            System.out.println(STR."Equipamento: \{equipamento.getFirst()} Quantidade: \{equipamento.getSecond()}");
        }
    }

    public void reservarEspaco(Integer idEspaco, Reserva novaReserva) {
        EspacoFisico espaco = buscar(idEspaco);
        var reservasDoEspaco = espaco.getReservasDoEspaco();
        for (Reserva reserva : reservasDoEspaco) {
            if (Reserva.sobreposicao(reserva, novaReserva)) {
                System.out.println("Reserva não concedida!");
                return;
            }
        }
        System.out.println("Reserva Concedida!");
        reservasDoEspaco.add(novaReserva);
        espaco.getHistoricoDeReservasFeitas().add(new Pair<>(TipoReserva.ADD.getDescricao(), novaReserva));
    }

    public void removerReserva(Integer idEspaco, Reserva reservaExistente) {
        EspacoFisico espaco = buscar(idEspaco);
        var reservasDoEspaco = espaco.getReservasDoEspaco();
        if(reservasDoEspaco.contains(reservaExistente)) {
            reservasDoEspaco.remove(reservaExistente);
            System.out.println("Reserva removida com sucesso!");
            espaco.getHistoricoDeReservasFeitas().add(new Pair<>(TipoReserva.DELETE.getDescricao(), reservaExistente));
            return;
        }
        System.out.println("Reserva não encontrada!");
    }

    public void historicoReservas(Integer idEspaco){
        EspacoFisico espaco = buscar(idEspaco);
        for(var reserva : espaco.getHistoricoDeReservasFeitas()){
            System.out.println(STR."\{reserva.getFirst()}, \{reserva.getSecond()}");
        }
    }

}