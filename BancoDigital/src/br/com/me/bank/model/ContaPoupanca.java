package br.com.me.bank.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);

    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n");
        System.out.println(" === Extrato da Conta Poupança ===");
        imprimirInfosComuns();
    }
}
