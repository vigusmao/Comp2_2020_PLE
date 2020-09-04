package main;

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

    public Banco() {
        this.contas = new Conta[10];
        this.correntistas = new Correntista[10];
        this.agencias = new Agencia[10];
        this.gerentes = new Gerente[10];
    }

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

    public Gerente adicionarGerente(String nome) {
        Gerente novoGerente = new Gerente(nome);
        this.gerentes[this.quantGerentes++] = novoGerente;
        return novoGerente;
    }

    public Correntista adicionarCorrentista(String nome, int senhaNumerica) {
        Correntista novoCorrentista = new Correntista(nome, senhaNumerica);
        this.correntistas[this.quantCorrentistas++] = novoCorrentista;
        return novoCorrentista;
    }

    public Agencia adicionarAgencia(int codigo, String nome) {
        Agencia novaAgencia = new Agencia();
        this.agencias[this.quantAgencias++] = novaAgencia;
        return novaAgencia;

    }

    public int getQuantAgencias() {
        return quantAgencias;
    }
}
