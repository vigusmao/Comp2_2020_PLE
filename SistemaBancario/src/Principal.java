import java.util.List;

public class Principal {

    public static void main(String[] args) throws SenhaInvalidaException {

        Correntista correntista1 = new Correntista("Carla da Costa", 11111);
        Correntista correntista2 = new Correntista("João da Silva", 11111);
        Agencia agencia = new Agencia();

        Conta conta1 = new Conta(1234, agencia, correntista1);
        Conta conta2 = new Conta(2222, agencia, correntista2);

        conta1.depositar(100, "dinheiro");
        conta1.depositar(300, "dinheiro");
        conta2.depositar(200, "dinheiro");

        System.out.println(conta1.getNumeroDepositos());  // 3
        System.out.println(conta2.getNumeroDepositos());  // 3
        System.out.println(Conta.getNumeroDepositos());   // 3 (porque o atributo é static)

        try {
            conta1.efetuarTransferencia(conta2, 506, 11111);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente!!");  // e/ou outros tratamentos
            System.out.println(String.format("Ficaram faltando R$%.2f para conseguir!",
                    e.getDeficit()));
        }

        System.out.println(4);
    }
}
