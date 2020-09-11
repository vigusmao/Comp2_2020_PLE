import org.junit.Test;

import static org.junit.Assert.*;

public class FracaoTest {

    @Test
    public void getValorNumericoTestParaFracaoPositiva() {
        Fracao fracao = new Fracao(1, 2, true);
        assertTrue("O valor numérico retornado deve ser " +
                        "o numerador dividido pelo denominador",
                fracao.getValorNumerico() == 0.5f);
    }

    @Test
    public void getValorNumericoTestParaFracaoNegativa() {
        Fracao fracao = new Fracao(1, 2, false);
        assertTrue("O valor numérico retornado deve ser " +
                        "o numerador dividido pelo denominador, com o sinal correto",
                fracao.getValorNumerico() == -0.5f);
    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoNaoIrredutivel() {
        Fracao fracao = new Fracao(4, 20, true);

        assertEquals(1, fracao.getFracaoIrredutivel().getNumerador());
        assertEquals(5, fracao.getFracaoIrredutivel().getDenominador());
        assertTrue(fracao.getFracaoIrredutivel().isPositiva());

    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoJaIrredutivel() {
        Fracao fracao = new Fracao(1, 3, true);
        assertTrue(fracao.getFracaoIrredutivel() == fracao);
    }

    @Test
    public void equalsTest() {
        Fracao x = new Fracao(3, 15, true);
        Fracao y = new Fracao(30, 150, true);
        Fracao w = new Fracao(30, 150, true);
        Fracao z = new Fracao(3, 15, false);

        assertEquals(x, x);
        assertEquals(y, w);
        assertEquals("Frações equivalentes precisam ser consideradas iguais",
                x, y);
        assertNotEquals("Frações com sinais opostos não podem ser iguais!",
                x, z);
    }

}