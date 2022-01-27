import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected double divida;
    protected Cliente cliente;
    protected Banco banco;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void pegarEmprestimo(double valor) {
        saldo += valor;
        double percentual = 0.89 / 100;
        double valorDiv = (valor * percentual) + valor;
        divida += valorDiv;
    }

    public void fazDeposito(String resp) {
        Scanner scan = new Scanner(System.in);

        switch (resp.toUpperCase(Locale.ROOT)) {
            case "S":
                System.out.println("Digite o valor do depósito:");
                depositar(scan.nextDouble());
                break;
            case "N":
                depositar(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    public void fazSaque(String resp) {
        Scanner scan = new Scanner(System.in);

        switch (resp.toUpperCase(Locale.ROOT)) {
            case "S":
                System.out.println("Digite o valor do saque:");
                sacar(scan.nextDouble());
                break;
            case "N":
                sacar(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    public void fazTransferencia(String resp, Conta contaDestino) {
        Scanner scan = new Scanner(System.in);

        switch (resp.toUpperCase(Locale.ROOT)) {
            case "S":
                System.out.println("Digite o valor da transferência:");
                transferir(scan.nextDouble(), contaDestino);
                break;
            case "N":
                transferir(0, contaDestino);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }

    public void fazEmprestimo(String resp) {
        Scanner scan = new Scanner(System.in);

        switch (resp.toUpperCase(Locale.ROOT)) {
            case "S":
                System.out.println("Digite o valor do empréstimo: ");
                pegarEmprestimo(scan.nextDouble());
                break;
            case "N":
                pegarEmprestimo(0);
                break;
            default:
                System.out.println("Caractéres não permitido");
                System.exit(0);
        }
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getDivida() {
        return divida;
    }

    protected void imprimirInfosComuns() {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

        System.out.println("============= " + banco.getNome() + " =============");
        System.out.println("\n");
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agencia: " + agencia);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Saldo: " + dinheiro.format(saldo));
        System.out.println("\n");
        System.out.println("Pendencias: " + dinheiro.format(divida));
    }


}
