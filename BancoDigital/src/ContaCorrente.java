import java.util.Locale;
import java.util.Scanner;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato() {
        System.out.println("\n");
        System.out.println(" === Extrato da Conta Corrente ===");
        imprimirInfosComuns();
    }




}
