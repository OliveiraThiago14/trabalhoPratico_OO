package org.fga.painel;

import org.fga.cadastros.CadastroAuditorio;
import org.fga.cadastros.CadastroLaboratorio;
import org.fga.cadastros.CadastroSala;
import org.fga.entidades.Reserva;
import org.fga.espacos.Auditorio;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;

import java.util.Scanner;

public class MenuEspacoFisico{
    static Scanner sc = new Scanner(System.in);
    static CadastroAuditorio cadastroAuditorio = CadastroAuditorio.getInstancia();
    static CadastroLaboratorio cadastroLaboratorio = CadastroLaboratorio.getInstancia();
    static CadastroSala cadastroSala = CadastroSala.getInstancia();

    public static void goToMenu() {

        System.out.println("\nBem vindo ao Menu de Espacos Fisicos\nEscolha um opção: ");
        System.out.println("1 - Cadastrar Espaco Fisico");
        System.out.println("2 - Mostrar Espacos Fisicos");
        System.out.println("3 - Fazer Reserva de Espaco Fisicos");
        System.out.println("4 - Exibir Historico de Reservas Feitas");
        System.out.println("5 - Cadastrar Equipamento");
        System.out.println("6 - Sair do Menu");

        int escolha = sc.nextInt();
        switch (escolha) {
            case 1 -> criarEspacoFisico();
            case 2 -> listarEspacos();
            case 3 -> iniciarReserva();
            case 4 -> mostrarHistoricoReservas();
            case 5 -> cadastrarEquipamento();
            case 6 -> {
                MenuAluno.goToMenuAluno();
                return;
            }
            default -> {
                System.out.println("Escolha uma opção valida!");
                goToMenu();
            }
        }
        goToMenu();
    }

    public static Reserva infoReserva(){
        System.out.println("Informe a data de inicio da sua reserva: ");
        int dtInicio = sc.nextInt();
        System.out.println("Informe a data de fim da sua reserva: ");
        int dtFim = sc.nextInt();
        System.out.println("Informe a hora de inicio da sua reserva: ");
        int horInicio = sc.nextInt();
        System.out.println("Informe a hora de fim da sua reserva: ");
        int horFim = sc.nextInt();
        Reserva reserva = new Reserva(dtInicio, dtFim, horInicio, horFim);
        return reserva;
    }

    private static void listarEspacos() {
        int tipoEspaco = escolhaEspaco();
        if(tipoEspaco == -1){
            goToMenu();
            return;
        }

        switch (tipoEspaco){
            case 1 -> cadastroSala.listarEspacos();
            case 2 -> cadastroLaboratorio.listarEspacos();
            case 3 -> cadastroAuditorio.listarEspacos();
        }
    }

    private static void iniciarReserva(){
        int op = escolhaEspaco();
        if(op == -1){
            goToMenu();
            return;
        }

        switch (op) {
            case 1 -> cadastroSala.reservarEspaco(infoReserva());
            case 2 -> cadastroLaboratorio.reservarEspaco(infoReserva());
            case 3 -> cadastroAuditorio.reservarEspaco(infoReserva());
            default -> System.out.println("Erro ao cadastrar Espaco! Esse espaço fisico não existe");
        }
    }

    private static int escolhaEspaco(){
        System.out.println("Informe o tipo de espaço fisico que deseja realizar a acão: ");
        System.out.println("1. Sala\n2. Laboratorio\n3. Auditorio\n4. Voltar ao Menu");
        int tipoEspaco = sc.nextInt();
        if(tipoEspaco == 4) {
            return -1;
        }
        if(tipoEspaco > 4 || tipoEspaco < 1){
            System.out.println("Opção inválida! Tente novamente.");
            return escolhaEspaco();
        }
        return tipoEspaco;
    }

    private static void criarEspacoFisico() {
        int tipoDeEspaco = escolhaEspaco();
        if(tipoDeEspaco == -1){
            goToMenu();
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

        switch (tipoDeEspaco) {
            case 1 -> {
                Sala sala = new Sala(nomeEspaco, capacidade, loc);
                cadastroSala.cadastrar(sala);
            }
            case 2 -> {
                Laboratorio laboratorio = new Laboratorio(nomeEspaco, capacidade, loc);
                cadastroLaboratorio.cadastrar(laboratorio);
            }
            case 3 -> {
                Auditorio auditorio = new Auditorio(nomeEspaco, capacidade, loc);
                cadastroAuditorio.cadastrar(auditorio);
            }
            default -> System.out.println("Erro ao cadastrar Espaco! Esse espaço fisico não existe");
        }
    }

    private static void mostrarHistoricoReservas() {
        int tipoDeEspaco = escolhaEspaco();
        if(tipoDeEspaco == -1){
            goToMenu();
            return;
        }

        switch (tipoDeEspaco) {
            case 1 -> cadastroSala.historicoReservas();
            case 2 -> cadastroLaboratorio.historicoReservas();
            case 3 -> cadastroAuditorio.historicoReservas();
            default -> System.out.println("Erro ao mostrar histórico de reservas! Esse espaço fisico não existe");
        }
    }

    private static void cadastrarEquipamento() {
        int tipoDeEspaco = escolhaEspaco();
        if(tipoDeEspaco == -1){
            goToMenu();
            return;
        }

        System.out.println("Informe o nome do equipamento: ");
        String nomeEquipamento = sc.next();
        sc.nextLine();

        System.out.println("Informe a quantidade desse equipamento no espaco: ");
        int quantidade = sc.nextInt();

        switch (tipoDeEspaco) {
            case 1 -> cadastroSala.cadastrarEquipamento(nomeEquipamento, quantidade);
            case 2 -> cadastroLaboratorio.cadastrarEquipamento(nomeEquipamento, quantidade);
            case 3 -> cadastroAuditorio.cadastrarEquipamento(nomeEquipamento, quantidade);
            default -> System.out.println("Erro ao cadastrar Equipamento! Esse espaço fisico não existe");
        }
    }
}
