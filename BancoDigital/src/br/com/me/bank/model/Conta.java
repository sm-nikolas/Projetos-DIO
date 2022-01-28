package br.com.me.bank.model;

import java.text.NumberFormat;
import java.util.Locale;

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
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Número da conta: " + getNumeroConta());
        System.out.println("Saldo: " + dinheiro.format(getSaldo()));
        System.out.println("\n");
        System.out.println("Pendencias: " + dinheiro.format(getDivida()));
    }


}
