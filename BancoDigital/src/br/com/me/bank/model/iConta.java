package br.com.me.bank.model;

public interface iConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta conta);

    void pegarEmprestimo(double valor);

    void imprimirExtrato();
}
