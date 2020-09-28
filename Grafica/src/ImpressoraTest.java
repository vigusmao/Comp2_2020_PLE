import org.junit.Test;

import static org.junit.Assert.*;

public class ImpressoraTest {

    @Test
    public void testarImpressoraTanqueDeTinta() {
        ImpressoraTanqueDeTinta impressoraTanqueDeTinta = new ImpressoraTanqueDeTinta(
                "Impressora de Teste", "Sem Marca");
        executarTeste(impressoraTanqueDeTinta);
    }

    @Test
    public void testarImpressoraJatoDeTinta() {
        ImpressoraJatoDeTinta impressoraJatoDeTinta = new ImpressoraJatoDeTinta(
                "Impressora de Teste", "Sem Marca", true);
        executarTeste(impressoraJatoDeTinta);

        impressoraJatoDeTinta.executarLimpezaBicos();
    }

    @Test
    public void testarImpressoraLaser() {
        ImpressoraLaser impressoraLaser = new ImpressoraLaser();
        executarTeste(impressoraLaser);
    }

    @Test
    public void testarImpressoraMatricial() {
        ImpressoraMatricial impressoraMatricial = new ImpressoraMatricial("Blah");
        executarTeste(impressoraMatricial);
    }

    private void executarTeste(Impressora impressora) {
        // cada caracter vai consumir 10 porcento da tinta!!
        impressora.setConsumoPercentualPorCaracter(10);

        impressora.imprimir("1234567");

        assertTrue(impressora.verificarNecessidadeRecarga("1234"));


    }

}