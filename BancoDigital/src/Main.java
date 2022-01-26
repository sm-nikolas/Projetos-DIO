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

//        Depósito
        if (respDeposito.equalsIgnoreCase("S")){
            System.out.println("Digite o valor do depósito:");
            cc.depositar(scan.nextDouble());
        }else if(respDeposito.equalsIgnoreCase("N")){
            cc.depositar(0);
        }else{
            System.out.println("Caractéres não permitido");
            System.exit(0);
        }


//        Saque
        if (respSaque.equalsIgnoreCase("S")){
            System.out.println("Digite o valor do Saque:");
            cc.sacar(scan.nextDouble());
        }else if(respSaque.equalsIgnoreCase("N")){
            cc.sacar(0);
        }else{
            System.out.println("Caractéres não permitido");
            System.exit(0);
        }

//        Transferência
        if (respTranferencia.equalsIgnoreCase("S")){
            System.out.println("Digite o valor da Transferência:");
            cc.transferir(scan.nextDouble(), cp);
        }else if(respTranferencia.equalsIgnoreCase("N")){
            cc.transferir(0, cc);
        }else{
            System.out.println("Caractéres não permitido");
            System.exit(0);
        }


//        Empréstimo
        if (respEmprestimo.equalsIgnoreCase("S")){
            System.out.println("Digite o valor do empréstimo:");
            cc.pegarEmprestimo(scan.nextDouble());
        }else if(respEmprestimo.equalsIgnoreCase("N")){
            cc.pegarEmprestimo(0);
        }else{
            System.out.println("Caractéres não permitido");
            System.exit(0);
        }


        if (respTranferencia.equalsIgnoreCase("N") && respDeposito.equalsIgnoreCase("N")
            && respSaque.equalsIgnoreCase("N") && respEmprestimo.equalsIgnoreCase("N")){
            System.out.println("======== Obrigado pela preferência =======");
            System.exit(0);
        }

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}

