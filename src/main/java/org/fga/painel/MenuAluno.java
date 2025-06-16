package org.fga.painel;

import org.fga.entidades.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuAluno extends Menu {

    @Override
    protected Aluno dadosNovo(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    Aluno aluno = new Aluno(separado[0], separado[1], separado[2], separado[3], separado[4], separado[5], separado[6]);
                    return aluno;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    protected String lerNome(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    System.out.println(separado[0]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return "";
    }

    @Override
    protected String lerEmail(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    System.out.println(separado[1]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    protected String lerMatricula(String nome) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[0].trim().equals(nome)){
                    System.out.println(separado[5]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    protected String lerCurso(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    System.out.println(separado[4]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    protected String lerTelefone(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    System.out.println(separado[2]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    protected String lerSemestre(String matricula) {
        try (Scanner scanner = new Scanner(new File("alundb.txt"))){
            while (scanner.hasNextLine()){
                String info = scanner.nextLine();
                String[] separado = info.split(",");
                if (separado.length > 0 && separado[5].trim().equals(matricula)){
                    System.out.println(separado[6]);
                    return "";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
