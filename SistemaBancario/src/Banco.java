public class Banco {

    private String nome;

    private Conta[] contas;
    private int quantContas;

    private Correntista[] correntistas;
    private int quantCorrentistas;

    private Agencia[] agencias;
    private int quantAgencias;

    private Gerente[] gerentes;
    private int quantGerentes;

    public void cadastrarCorrentista() {

    }

    public Conta criarConta(Agencia agencia, Correntista correntista) {
        long numero = quantContas + 1;
        int digitoVerificador = obterDigitoVerificador(numero);
        numero *= 10;  // shift left em uma casa (base 10)
        numero += digitoVerificador;
        Conta novaConta = new Conta(numero, agencia, correntista);
        this.contas[this.quantContas++] = novaConta;
        return novaConta;
    }

    private int obterDigitoVerificador(long numero) {
        return Math.abs((int) numero) % 10;  // retorna o valor absoluto do inteiro
    }


}
