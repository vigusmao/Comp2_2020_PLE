import java.util.ArrayList;

public class Banco {

    private String nome;

    private ArrayList<Conta> contas;
    private ArrayList<Correntista> correntistas;
    private ArrayList<Agencia> agencias;
    private ArrayList<Gerente> gerentes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.correntistas = new ArrayList<>();
        this.agencias = new ArrayList<>();
        this.gerentes = new ArrayList<>();
    }

    public void cadastrarCorrentista() {

    }

    public Conta criarConta(Agencia agencia, Correntista correntista) {
        long numero = getQuantContas() + 1;
        int digitoVerificador = obterDigitoVerificador(numero);
        numero *= 10;  // shift left em uma casa (base 10)
        numero += digitoVerificador;
        Conta novaConta = new Conta(numero, agencia, correntista);
        this.contas.add(novaConta);
        return novaConta;
    }

    public int getQuantContas() {
        return this.contas.size();
    }

    private int obterDigitoVerificador(long numero) {
        return Math.abs((int) numero) % 10;  // retorna o valor absoluto do inteiro
    }

    public Gerente adicionarGerente(String nome) {
        Gerente novoGerente = new Gerente(nome);
        this.gerentes.add(novoGerente);
        return novoGerente;
    }

    public Correntista adicionarCorrentista(String nome, int senhaNumerica) {
        Correntista novoCorrentista = new Correntista(nome, senhaNumerica);
        this.correntistas.add(novoCorrentista);
        return novoCorrentista;
    }

    public Agencia adicionarAgencia(int codigo, String nome) {
        Agencia novaAgencia = new Agencia();
        this.agencias.add(novaAgencia);
        return novaAgencia;

    }

    public int getQuantAgencias() {
        return this.agencias.size();
    }

    /**
     * Retorna uma conta pré-existente a partir do parâmetro de busca número da conta.
     *
     * @param numeroDaContaDesejada O número da conta que se quer localizar
     * @return A conta desejada, caso seja localizada; null, caso contrário
     */
    public Conta obterConta(long numeroDaContaDesejada) {
        for (int i = 0; i < getQuantContas(); i++) {
            Conta conta = this.contas.get(i);
            if (conta.getNumero() == numeroDaContaDesejada) {
                return conta;  // encontrei a conta desejada!!!
            }
        }
        return null;
    }

    /**
     * Retorna uma conta pré-existente a partir do parâmetro de busca correntista.
     * Se o mesmo correntista possuir mais de uma conta no banco,
     * retornará uma delas, arbitrariamente.
     *
     * @param correntista O dono da conta desejada
     * @return A conta desejada, caso seja localizada; null, caso contrário
     */
    public Conta obterConta(Correntista correntista) {
        for (int i = 0; i < getQuantContas(); i++) {
            Conta conta = this.contas.get(i);
            if (conta.getCorrentista() == correntista) {
                return conta;  // encontrei a conta desejada!!!
            }
        }
        return null;
    }
}
