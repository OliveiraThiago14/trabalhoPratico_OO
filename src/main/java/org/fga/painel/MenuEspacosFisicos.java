package org.fga.painel;

import com.sun.net.httpserver.Request;
import org.fga.cadastros.CadastroEspacosFisicos;
import org.fga.entidades.Reserva;
import org.fga.espacos.Auditorio;
import org.fga.espacos.EspacosFisicos;
import org.fga.espacos.Laboratorio;
import org.fga.espacos.Sala;

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
        CadastroEspacosFisicos cad = new CadastroEspacosFisicos();


        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                cadastrarEspacoFisico();
                break;
            case 2:
                listarEspacos();
                break;
            case 3:
                decisoes();
                break;
            case 4:
                Sala sala = new Sala();
                sala.reser();
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.reser();
                Auditorio auditorio = new Auditorio();
                auditorio.reser();
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
        System.out.println("1- Sala\n 2- Laboratorio\n 3- Auditorio ");
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
            default:
                System.out.println("Escolha um espaco valido!");
                decisoes();
        }
    }



}
