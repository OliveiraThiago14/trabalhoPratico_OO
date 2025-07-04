package org.fga.painel;

import org.fga.cadastros.CadastroAuditorio;
import org.fga.cadastros.CadastroEspacoFisico;
import org.fga.cadastros.CadastroLaboratorio;
import org.fga.cadastros.CadastroSala;
import org.fga.entidades.Reserva;
import org.fga.espacos.Auditorio;
import org.fga.espacos.EspacoFisico;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;
import org.fga.exceptions.DiasExcedidosException;
import org.fga.util.TipoEspacoFisico;
import org.fga.util.TipoUsuario;

import java.util.Scanner;

public class MenuEspacoFisico {
    private static final Scanner sc = new Scanner(System.in);
    private static final CadastroAuditorio cadastroAuditorio = CadastroAuditorio.getInstancia();
    private static final CadastroLaboratorio cadastroLaboratorio = CadastroLaboratorio.getInstancia();
    private static final CadastroSala cadastroSala = CadastroSala.getInstancia();

    public static void goToMenu(TipoUsuario tipo) {
        while (true) {
            System.out.println("\nBem vindo ao Menu de Espacos Fisicos\nEscolha um opção: ");
            System.out.println("1 - Cadastrar Espaco Fisico");
            System.out.println("2 - Mostrar Espacos Fisicos");
            System.out.println("3 - Fazer Reserva de Espaco Fisicos");
            System.out.println("4 - Exibir Historico de Reservas Feitas");
            System.out.println("5 - Cadastrar Equipamento");
            System.out.println("6 - Remover Espaco Fisico");
            System.out.println("7 - Sair do Menu");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> criarEspacoFisico(tipo);
                case 2 -> listarEspacos(tipo);
                case 3 -> iniciarReserva(tipo);
                case 4 -> mostrarHistoricoReservas(tipo);
                case 5 -> cadastrarEquipamento(tipo);
                case 6 -> removerEspacoFisico(tipo);
                case 7 -> {
                    return;
                }
                default -> System.out.println("Escolha uma opção valida!");
            }
        }
    }

    private static void removerEspacoFisico(TipoUsuario tipo) {
        int op = escolhaEspaco();
        if (op == -1) {
            goToMenu(tipo);
            return;
        }
        System.out.println("Informe o nome do espaço fisico que deseja remover: ");
        sc.nextLine();
        String nomeEspaco = sc.nextLine();

        CadastroEspacoFisico cadastroEspacoFisico = cadastroFactory(op);
        if(cadastroEspacoFisico == null) return;

        Integer idEspaco = cadastroEspacoFisico.getIdByNome(nomeEspaco);

        if(idEspaco == null) {
            System.out.println("Erro ao Remover Espaco! Esse espaço fisico não existe");
            return;
        }
        cadastroEspacoFisico.delete(idEspaco);
        System.out.println("Espaço removido com sucesso!");
    }


    public static Reserva infoReserva(TipoUsuario tipo) throws DiasExcedidosException {
        System.out.println("Informe a data de inicio da sua reserva: ");
        int dtInicio = sc.nextInt();
        System.out.println("Informe a data de fim da sua reserva: ");
        int dtFim = sc.nextInt();
        System.out.println("Informe a hora de inicio da sua reserva: ");
        int horInicio = sc.nextInt();
        System.out.println("Informe a hora de fim da sua reserva: ");
        int horFim = sc.nextInt();
        if (TipoUsuario.ALUNO.equals(tipo) && dtFim - dtInicio >= 1) {
            throw new DiasExcedidosException();

        }
        return new Reserva(dtInicio, dtFim, horInicio, horFim);
    }

    private static void listarEspacos(TipoUsuario tipo) {
        int tipoEspaco = escolhaEspaco();
        if (tipoEspaco == -1) {
            goToMenu(tipo);
            return;
        }
        switch (tipoEspaco) {
            case 1 -> cadastroSala.listar(TipoEspacoFisico.SALA);
            case 2 -> cadastroLaboratorio.listar(TipoEspacoFisico.LABORATORIO);
            case 3 -> cadastroAuditorio.listar(TipoEspacoFisico.AUDITORIO);
        }
    }

    private static void iniciarReserva(TipoUsuario tipo) {
        int op = escolhaEspaco();
        if (op == -1) {
            goToMenu(tipo);
            return;
        }
        CadastroEspacoFisico cadastro = cadastroFactory(op);
        if (cadastro == null) return;
        System.out.println("Informe o nome do espaço fisico que deseja reservar: ");
        sc.nextLine();
        String nomeEspaco = sc.nextLine();

        Integer idEspaco = cadastro.getIdByNome(nomeEspaco);
        if(idEspaco == null){
            System.out.println("Erro ao Reservar Espaco! Esse espaço fisico não existe");
            return;
        }

        Reserva reserva;
        try {
            reserva = infoReserva(tipo);
            cadastro.reservarEspaco(reserva);
        } catch (DiasExcedidosException e) {
            System.out.println(e.getMessage());
            iniciarReserva(tipo);
        }
    }

    private static int escolhaEspaco() {
        System.out.println("Informe o tipo de espaço fisico que deseja realizar a acão: ");
        System.out.println("1. Sala\n2. Laboratorio\n3. Auditorio\n4. Voltar ao Menu");
        int tipoEspaco = sc.nextInt();
        if (tipoEspaco == 4) {
            return -1;
        }
        if (tipoEspaco > 4 || tipoEspaco < 1) {
            System.out.println("Opção inválida! Tente novamente.");
            return escolhaEspaco();
        }
        return tipoEspaco;
    }

    private static void criarEspacoFisico(TipoUsuario tipo) {
        int tipoDeEspaco = escolhaEspaco();
        if (tipoDeEspaco == -1) {
            goToMenu(tipo);
            return;
        }

        System.out.println("Informe o nome do espaco: ");
        sc.nextLine();
        String nomeEspaco = sc.nextLine();

        System.out.println("Informe a capacidade: ");
        int capacidade = sc.nextInt();

        System.out.println("Informe o localizacao: ");
        sc.nextLine();
        String loc = sc.nextLine();

        CadastroEspacoFisico cadastro = cadastroFactory(tipoDeEspaco);
        if(cadastro == null) return;

        EspacoFisico espacoFisico = null;
        switch (tipoDeEspaco) {
            case 1 -> espacoFisico = new Sala(nomeEspaco, capacidade, loc);
            case 2 -> espacoFisico = new Laboratorio(nomeEspaco, capacidade, loc);
            case 3 -> espacoFisico = new Auditorio(nomeEspaco, capacidade, loc);
        }
        cadastro.cadastrar(espacoFisico);
    }

    private static void mostrarHistoricoReservas(TipoUsuario tipo) {
        int tipoDeEspaco = escolhaEspaco();
        if (tipoDeEspaco == -1) {
            goToMenu(tipo);
            return;
        }

        CadastroEspacoFisico cadastro = cadastroFactory(tipoDeEspaco);
        if (cadastro == null) return;
        cadastro.historicoReservas();
    }

    private static void cadastrarEquipamento(TipoUsuario tipo) {
        int tipoDeEspaco = escolhaEspaco();
        if (tipoDeEspaco == -1) {
            goToMenu(tipo);
            return;
        }

        System.out.println("Informe o nome do equipamento: ");
        String nomeEquipamento = sc.next();
        sc.nextLine();

        System.out.println("Informe a quantidade desse equipamento no espaco: ");
        int quantidade = sc.nextInt();

        CadastroEspacoFisico cadastro = cadastroFactory(tipoDeEspaco);
        if (cadastro == null) return;
        cadastro.cadastrarEquipamento(nomeEquipamento, quantidade);
    }

    public static CadastroEspacoFisico cadastroFactory(int op){
        switch(op){
            case 1 -> {
                return CadastroSala.getInstancia();
            }
            case 2 -> {
                return CadastroLaboratorio.getInstancia();
            }
            case 3 -> {
                return CadastroAuditorio.getInstancia();
            }
            default -> {
                System.out.println("Erro! Esse espaço fisico não existe");
                return null;
            }
        }
    }
}
