package br.com.me.bank;

import br.com.me.bank.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Cliente nikolas = new Cliente();
        nikolas.setNome("Nikolas");

        Banco javaBank = new Banco();
        javaBank.setNome("JavaBank");


        Conta cc = new ContaCorrente(nikolas, javaBank);
        Conta cp = new ContaPoupanca(nikolas, javaBank);


        String respDeposito, respTranferencia, respSaque, respEmprestimo;

        System.out.println("Responda as perguntas abaixo com 'S' para sim e 'N' para não");


        System.out.println("Você deseja fazer um depósito? ");
        respDeposito = scan.next().toUpperCase();
        fazDeposito(scan, cc, respDeposito);

        System.out.println("Você deseja fazer um Saque? ");
        respSaque = scan.next().toUpperCase();
        fazSaque(scan, cc, respSaque);

        System.out.println("Você deseja fazer uma Transferência? ");
        respTranferencia = scan.next().toUpperCase();
        fazTranferencia(scan, cc, cp, respTranferencia);

        System.out.println("Você deseja fazer um Empréstimo? ");
        respEmprestimo = scan.next().toUpperCase();
        fazEmprestimo(scan, cc, respEmprestimo);


        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }

    private static void fazDeposito(Scanner scan, Conta cc, String respDeposito) {
        switch (respDeposito) {
            case "S":
                System.out.println("Digite o valor do depósito:");
                cc.depositar(scan.nextDouble());
                break;
            case "N":
                cc.depositar(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    private static void fazSaque(Scanner scan, Conta cc, String respSaque) {
        switch (respSaque) {
            case "S":
                System.out.println("Digite o valor do saque:");
                cc.sacar(scan.nextDouble());
                break;
            case "N":
                cc.sacar(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    private static void fazTranferencia(Scanner scan, Conta cc, Conta cp, String respTranferencia) {
        switch (respTranferencia) {
            case "S":
                System.out.println("Digite o valor da transferência:");
                cc.transferir(scan.nextDouble(), cp);
                break;
            case "N":
                cc.transferir(0, cp);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    private static void fazEmprestimo(Scanner scan, Conta cc, String respEmprestimo) {
        switch (respEmprestimo) {
            case "S":
                System.out.println("Digite o valor do empréstimo: ");
                cc.pegarEmprestimo(scan.nextDouble());
                break;
            case "N":
                cc.pegarEmprestimo(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }
}

