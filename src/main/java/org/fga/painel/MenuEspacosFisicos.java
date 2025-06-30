package org.fga.painel;

import org.fga.cadastros.CadastroAuditorio;
import org.fga.cadastros.CadastroEspacosFisicos;
import org.fga.entidades.Reserva;
import org.fga.espacos.Auditorio;
import org.fga.espacos.EspacosFisicos;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.fga.cadastros.CadastroEspacosFisicos.*;

public class MenuEspacosFisicos {
    Scanner sc = new Scanner(System.in);


    public void MenuEspaco() {

        System.out.println("\nBem vindo ao Menu de Espacos Fisicos\n Escolha um opção: ");
        System.out.println("1 - Cadastrar Espaco Fisico");
        System.out.println("2 - Mostrar Espacos Fisicos");
        System.out.println("3 - Fazer Reserva de Espaco Fisicos");
        System.out.println("4 - Exibir Historico de Reservas Feitas");
        System.out.println("5 - Sair do Menu");
        CadastroEspacosFisicos cad = CadastroEspacosFisicos.getInstancia();
        CadastroAuditorio cadastroAuditorio = new CadastroAuditorio();

        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                EspacosFisicos espacosFisicos = criarEspacoFisico();
                cad.cadastrar(espacosFisicos);
                break;
            case 2:
                cad.listarEspacos();
                break;
            case 3:
                decisoes();
                break;
            case 4:
                Sala sala = new Sala();
                sala.historicoReservas();
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.historicoReservas();
                Auditorio auditorio = new Auditorio();
                auditorio.historicoReservas();
                break;
            case 5:
                System.exit(0);
                break;
                default:
                    System.out.println("Escolha uma opção valida!");
                    MenuEspaco();
                    break;
        }


    }
    public Reserva  infoReserv(){
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


    private void decisoes(){
        System.out.println("Escolha o Espaco Fisico que Deseja Reservar: ");
        System.out.println("1- Sala\n 2- Laboratorio\n 3- Auditorio\n 4- Voltar ao Menu");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                Sala sala = new Sala();
                sala.reservarEspaco(infoReserv());
                break;
            case 2:
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.reservarEspaco(infoReserv());
                break;
            case 3:
                Auditorio auditorio = new Auditorio();
                auditorio.reservarEspaco(infoReserv());
                break;
            case 4:
                MenuEspaco();
                break;
            default:
                System.out.println("Escolha um espaco valido!");
                decisoes();
                break;
        }
    }

    private EspacosFisicos criarEspacoFisico(){
        List<String> equipamentos = new ArrayList<>();
        List<String> disp = new ArrayList<>();
        System.out.println("Informe o tipo de espaço fisico que deseja cadastrar: ");
        System.out.println("1. Sala\n 2. Laboratorio\n 3. Auditorio");
        int tipoDeEspaco  = sc.nextInt();
        System.out.println("Informe o nome do espaco: ");
        String nomeEspaco = sc.next();
        sc.nextLine();
        System.out.println("Informe a capacidade: ");
        int capacidade = sc.nextInt();
        System.out.println("Informe o localizacao: ");
        String loc = sc.nextLine();
        System.out.println("Informe a quantidade de equipamentos: ");
        int qtd = sc.nextInt();

        while(qtd > 0) {
            String equip = sc.nextLine();
            equipamentos.add(equip);
            qtd--;
        }

        switch (tipoDeEspaco) {
            case 1:
                return new Sala(nomeEspaco, capacidade, loc, disp , equipamentos);
            case 2:
                return new Laboratorio(nomeEspaco, capacidade, loc, disp , equipamentos);
            case 3:
                return new Auditorio(nomeEspaco, capacidade, loc, disp , equipamentos);
            default:
                System.out.println("Erro ao cadastrar Espaco! Esse espaço fisico não existe");
                break;
        }
        return null;
    }
}
