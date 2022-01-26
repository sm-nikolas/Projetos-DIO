public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n");
        System.out.println(" === Extrato da Conta Corrente ===");
        imprimirInfosComuns();
    }


}
