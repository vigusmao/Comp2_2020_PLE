public class Conta {

    // O identificador único da conta.
    private final long numero;

    // O dono da conta.
    private final Correntista correntista;

    // O saldo corrente da conta, em reais.
    private float saldo;

    // Cada item será uma String descrevendo a operação (e sua data/hora) realizada.
    private String[] historicoOperacoes;
    private int quantItensHistorico;

    // O gerente da conta.
    private Gerente gerente;

    // A agência da qual faz parte esta conta.
    private Agencia agencia;

    public Conta(long numero, Agencia agencia, Correntista correntista) {
        this.numero = numero;
        this.agencia = agencia;  // agregação (referência a objeto pré-existente)
        this.correntista = correntista;  // agregação novamente
        this.historicoOperacoes = new String[10];  // composição (outro objeto criado junto)
        this.quantItensHistorico = 0;
        this.saldo = 0;
        this.gerente = agencia.getGerenteGeral();  // o gerente default fica sendo o gerente-geral da agência
    }

    public long getNumero() {
        return numero;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public float getSaldo() {
        return saldo;
    }

    public String[] getHistoricoOperacoes() {
        return historicoOperacoes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void receberDepositoEmDinheiro(float valor) {
        this.saldo += valor;
        String novoItem = String.format("Depósito em dinheiro: R$%.2f", valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
}

