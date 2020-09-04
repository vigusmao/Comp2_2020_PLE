package main;

public class Principal {

    public static void main(String[] args) {

        Banco banco = new Banco();
        Agencia agencia = new Agencia();
        Correntista correntista = new Correntista("Fulano", 1234);

        Conta conta = banco.criarConta(agencia, correntista);
        System.out.println(conta.getSaldo());
        conta.receberDepositoEmDinheiro(200);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getHistoricoOperacoes()[0]);
    }
}
