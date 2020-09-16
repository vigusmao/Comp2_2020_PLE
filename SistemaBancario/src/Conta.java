import java.util.Objects;

public class Conta {

    // O quão negativas as contas podem ficar.
    public final static int LIMITE = 100;

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

    private static int numeroSaques = 0;
    private static int numeroTransferencias = 0;
    private static int numeroDepositos = 0;


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
        depositar(valor, "em dinheiro");
    }

    public void sacar(float valor, int senha) {
        numeroSaques++;

        if (this.saldo - valor < -LIMITE) {  // saldo insuficiente
            return;  // ToDo lançar exceção
        }
        this.saldo -= valor;
        String novoItem = String.format("Saque: R$%.2f", valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }

    public void efetuarTransferencia(Conta contaDestino, float valor) {
        numeroTransferencias++;

        this.saldo -= valor;
        contaDestino.depositar(valor, this.getCorrentista().getNome());
        String novoItem = String.format(
                "Transferência efetuada para a conta %d: R$%.2f",
                contaDestino.getNumero(), valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }

    public void depositar(float valor, String descricaoOrigem) {
        numeroDepositos++;

        this.saldo += valor;
        String novoItem = String.format("Depósito %s: R$%.2f", descricaoOrigem, valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }

    public static void facaAlgumaCoisa(int x) {
        String msg = "Estou fazendo algo num contexto static com ";
        System.out.println(msg + x + " --- " + numeroDepositos);

    }

    public static int getNumeroSaques() {
        return numeroSaques;
    }

    public static int getNumeroTransferencias() {
        return numeroTransferencias;
    }

    public static int getNumeroDepositos() {
        return numeroDepositos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Conta outraConta = (Conta) o;
        return this.numero == outraConta.numero &&
                Objects.equals(this.agencia, outraConta.getAgencia());  // aqui ele já cuida dos nulls pra gente

    }

    @Override
    public int hashCode() {

        return Objects.hash(numero, agencia);
    }
}

