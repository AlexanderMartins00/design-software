package br.com.escola;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de escola:");
        System.out.println("1 - Escola pública");
        System.out.println("2 - Escola privada");
        System.out.println("3 - Escola técnica");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();

        EscolaFactory factory;

        if (opcao == 1) {
            factory = new EscolaPublicaFactory();
        } else if (opcao == 2) {
            factory = new EscolaPrivadaFactory();
        } else if (opcao == 3) {
            factory = new EscolaTecnicaFactory();
        } else {
            System.out.println("Opção inválida.");
            scanner.close();
            return;
        }

        SalaDeAula sala = new SalaDeAula(factory);
        sala.iniciarAula();

        scanner.close();
    }
}
