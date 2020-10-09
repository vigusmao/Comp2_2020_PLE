import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BancoTest {

    private static final int FLOAT_DELTA = 0;

    private Banco banco;
    private Agencia agencia;
    private Correntista joao;
    private Correntista maria;
    private Gerente alice;
    private Gerente carlos;

    Conta conta1;
    Conta conta2;

    int senhaConta1;
    int senhaConta2;


    @Before
    public void setUp() {
        // crio o banco
        banco = new Banco();

        // adiciono gerentes
        alice = banco.adicionarGerente("Alice");
        carlos = banco.adicionarGerente("Carlos");

        // adiciono uma agência
        agencia = banco.adicionarAgencia(11111, "Agência Teste 1");
        agencia.setGerenteGeral(alice);

        // adiciono correntistas
        senhaConta1 = 1234;
        joao = banco.adicionarCorrentista("João", senhaConta1);
        senhaConta2 = 5678;
        maria = banco.adicionarCorrentista("Maria", senhaConta2);

        // adiciono contas
        conta1 = banco.criarConta(agencia, joao);
        conta2 = banco.criarConta(agencia, maria);
    }

    @Test
    public void testarCriacaoAgencia() {
        assertEquals(1, banco.getQuantAgencias());  // a agência criada no setUp
        Agencia novaAgencia = banco.adicionarAgencia(44444, "Nova Agência");
        assertNotNull("O banco deve retornar a agência recém-criada", novaAgencia);
        assertEquals(2, banco.getQuantAgencias());  // a agência criada no setUp
    }

    @Test
    public void testarCriacaoConta() {
        assertEquals("O saldo inicial de uma conta deve ser zero",
                0, conta1.getSaldo(), 0);
        assertEquals("O gerente default de uma conta nova é o gerente geral de sua agência",
                agencia.getGerenteGeral(), conta1.getGerente());
        assertEquals("A conta deve retornar corretamente seu dono", joao, conta1.getCorrentista());
    }

    @Test
    public void testarOperacoesBancarias() {
        conta1.receberDepositoEmDinheiro(300);
        assertEquals("O saldo deve refletir depósitos recebidos",
                300, conta1.getSaldo(), FLOAT_DELTA);

        conta1.sacar(10, senhaConta1);
        assertEquals("O saldo da conta de origem deve diminuir após um saque",
                290, conta1.getSaldo(), FLOAT_DELTA);

        conta1.sacar(1000, senhaConta1);
        assertEquals("Não deve ser possível sacar se não houver fundos suficientes (considerando o limite)",
                290, conta1.getSaldo(), FLOAT_DELTA);

        conta1.efetuarTransferencia(conta2, 250);
        assertEquals("O saldo da conta de origem deve diminuir após uma transferência",
                40, conta1.getSaldo(), FLOAT_DELTA);
        assertEquals("O saldo da conta de destino deve aumentar após uma transferência",
                250, conta2.getSaldo(), FLOAT_DELTA);

        conta1.sacar(130, senhaConta1);
        assertEquals("Deve ser possível sacar até o limite de " + Conta.LIMITE, -90,
                conta1.getSaldo(), FLOAT_DELTA);
    }

    @Ignore
    @Test
    public void testarSaqueComSenhaIncorreta() {
        conta1.sacar(10, 3333333);
        assertEquals("Saques não devem ser permitidos se a senha estiver incorreta",
                0, conta1.getSaldo(), FLOAT_DELTA);

        conta1.sacar(10, senhaConta1);
        assertEquals("Saques devem ser permitidos se a senha estiver correta",
                -10, conta1.getSaldo(), FLOAT_DELTA);
    }

    @Ignore
    @Test
    public void testarTransferenciaSemFundos() {
        conta1.efetuarTransferencia(conta2, 500);
        assertEquals("Não deve ser possível sacar se não houver fundos suficientes (considerando o limite)",
                0, conta1.getSaldo(), FLOAT_DELTA);
    }

    @Test
    public void testarObterConta() {
        Conta contaDoJoao = banco.obterConta(conta1.getNumero());
        assertEquals("O banco deve retornar corretamente uma conta baseado em seu número",
                conta1, contaDoJoao);

        Conta resultadoBuscaContaMaria = banco.obterConta(maria);
        assertEquals("O banco deve retornar corretamente uma conta baseado no dono da conta",
                conta2, resultadoBuscaContaMaria);

        // criaremos agora uma segunda conta para a mesma correntista Maria
        Conta novaContaParaMaria = banco.criarConta(agencia, maria);

        resultadoBuscaContaMaria = banco.obterConta(maria);
        // agora eu espero que o resultado dessa busca seja null, porque a Maria tem 2 contas!!!
        assertNull("Usuários com mais de uma conta devem fazer com que o método obterConta() " +
                "retorne null", resultadoBuscaContaMaria);

        Correntista outroObjetoRepresentandoAMesmaMaria = new Correntista("Maria", 333123);

        List<Conta> resultadoBuscaContasDaMaria = banco.obterContas(
                outroObjetoRepresentandoAMesmaMaria);

        assertEquals("Todas as contas de um correntista devem ser retornadas",
                2, resultadoBuscaContasDaMaria.size());
        assertFalse(resultadoBuscaContasDaMaria.contains(conta1));
        assertTrue(resultadoBuscaContasDaMaria.contains(conta2));
        assertTrue(resultadoBuscaContasDaMaria.contains(novaContaParaMaria));
    }

    @Test
    public void testarCriacaoDeMuitasContas() {
        for (int i = 0; i < 1000; i++) {
            banco.criarConta(agencia, maria);
        }
        assertEquals(1002, banco.getQuantContas());  // já havia 2 contas (criadas no setUp)
    }
}