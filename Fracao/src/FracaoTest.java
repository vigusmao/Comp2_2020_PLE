import org.junit.Test;

import static org.junit.Assert.*;

public class FracaoTest {

    private static final double DOUBLE_DELTA = 0.00000001;

    @Test
    public void getValorNumericoTestParaFracaoPositiva() {
        Fracao fracao = new Fracao(1, 2, true);
        assertEquals("O valor numérico retornado deve ser " +
                        "o numerador dividido pelo denominador",
                0.5, fracao.getValorNumerico(), DOUBLE_DELTA);
    }

    @Test
    public void getValorNumericoTestParaFracaoNegativa() {
        Fracao fracao = new Fracao(1, 2, false);
        assertEquals("O valor numérico retornado deve ser " +
                        "o numerador dividido pelo denominador, com o sinal correto",
                -0.5, fracao.getValorNumerico(), DOUBLE_DELTA);
    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoNaoIrredutivel() {
        Fracao fracao = new Fracao(4, 20, false);

        assertEquals(1, fracao.getFracaoGeratriz().getNumerador());
        assertEquals(5, fracao.getFracaoGeratriz().getDenominador());
        assertFalse("A fração irredutível retornada deve ter o mesmo sinal da fração original",
                fracao.getFracaoGeratriz().isPositiva());
    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoJaIrredutivel() {
        Fracao fracao = new Fracao(1, 3, true);
        assertTrue("Se a fração já é irredutível, ela deve retornar a si própria",
                fracao.getFracaoGeratriz() == fracao);
    }

    @Test
    public void equalsTest() {
        Fracao x = new Fracao(3, 15, true);
        Fracao y = new Fracao(30, 150, true);
        Fracao w = new Fracao(30, 150, true);
        Fracao z = new Fracao(3, 15, false);

        assertEquals(x, x);
        assertEquals(y, w);
        assertEquals("Frações equivalentes precisam ser consideradas iguais", x, y);
        assertNotEquals("Frações com sinais opostos não podem ser iguais!", x, z);
    }

    @Test
    public void testarFracoesNulas() {
        // cria várias frações, todas elas nulas (i.e., iguais a zero)
        Fracao x = new Fracao(0, 1, true);
        Fracao y = new Fracao(0, 345, true);
        Fracao z = new Fracao(0, 56, false);  // esse false deve ser desconsiderado, mas aceitável

        String msgFracoesNulas = "Frações nulas são sempre iguais entre si";
        assertEquals(msgFracoesNulas, x, y);
        assertEquals(msgFracoesNulas, x, z);
        assertEquals(msgFracoesNulas, y, z);

        assertEquals(0, x.getValorNumerico(), DOUBLE_DELTA);
        assertEquals(0, y.getValorNumerico(), DOUBLE_DELTA);
        assertEquals(0, z.getValorNumerico(), DOUBLE_DELTA);

        assertFalse("Frações nulas não são positivas!!!", x.isPositiva());
    }
}