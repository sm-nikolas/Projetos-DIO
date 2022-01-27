import java.util.Locale;
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
        respDeposito = scan.next();

        System.out.println("Você deseja fazer um Saque? ");
        respSaque = scan.next();
        System.out.println("Você deseja fazer uma Transferência? ");
        respTranferencia = scan.next();
        System.out.println("Você deseja fazer um Empréstimo? ");
        respEmprestimo = scan.next();



        cc.fazDeposito(respDeposito);
        cc.fazSaque(respSaque);
        cc.fazTransferencia(respTranferencia, cp);
        cc.fazEmprestimo(respEmprestimo);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}

