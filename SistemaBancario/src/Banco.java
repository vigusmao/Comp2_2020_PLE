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

        if (this.quantContas == this.contas.length) {
            // array "cheio", preciso criar novo array
            redimensionarArrayDeContas();
        }
        this.contas[this.quantContas++] = novaConta;
        return novaConta;
    }

    public int getQuantContas() {
        return this.quantContas;
    }

    private void redimensionarArrayDeContas() {
        // crio um novo array
        Conta[] novoArray = new Conta[this.contas.length * 2];

        // copio o array antigo para o array novo
        for (int i = 0; i < this.contas.length; i++) {
            novoArray[i] = this.contas[i];
        }

        // reaponto o atributo this.contas para a nova região de memória alocada
        this.contas = novoArray;
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


    /**
     * Retorna uma conta pré-existente a partir do parâmetro de busca número da conta.
     *
     * @param numeroDaContaDesejada O número da conta que se quer localizar
     * @return A conta desejada, caso seja localizada; null, caso contrário
     */
    public Conta obterConta(long numeroDaContaDesejada) {
        for (int i = 0; i < this.quantContas; i++) {
            Conta conta = this.contas[i];
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
        for (int i = 0; i < this.quantContas; i++) {
            Conta conta = this.contas[i];
            if (conta.getCorrentista() == correntista) {
                return conta;  // encontrei a conta desejada!!!
            }
        }
        return null;
    }
}
