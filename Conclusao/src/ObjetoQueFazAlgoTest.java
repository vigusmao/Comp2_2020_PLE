import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjetoQueFazAlgoTest {

    private ObjetoQueFazAlgo meuObjetoASerTestado;

    private ObjetoAuxiliarMock objetoAuxiliarMock;

    @Before
    public void setUp() {
        meuObjetoASerTestado = new ObjetoQueFazAlgo();

        /* gostaria de fingir que o método facaAlgoImportanteParaAMinhaTarefa()
           do ObjetoAuxiliar que será chamado de dentro do meu ObjetoQueFazAlgo
           retornasse, digamos, o valor 5, sem ter que de fato depender de algo externo
           como um banco de dados, a Internet, um sistema de terceiros, algo que o usuário
           precise digitar na hora no teclado, etc. etc.

           Para isso, vamos usar um mock para o ObjetoAuxiliar
         */
        objetoAuxiliarMock = new ObjetoAuxiliarMock();
        meuObjetoASerTestado.setOutroObjeto(objetoAuxiliarMock);
    }

    @Test
    public void testarFuncionamentoDoFacaAlgoAssumindoValorPequenoVindoDoMetodoAuxiliar()
            throws MinhaExcecao, DataInvalidaException, OutraExcecaoQualquer {

        // primeiro teste, assumindo valor de retorno 5 para aqueeeeele método lento auxiliar
        objetoAuxiliarMock.setValorDeRetornoEspecificadoNaHoraPeloTeste(5);

        int resultado = meuObjetoASerTestado.facaAlgo(10, "blablabla");
        assertEquals(512, resultado);

        resultado = meuObjetoASerTestado.facaAlgo(-599, "dslkfjsdfk");
        assertEquals(501, resultado);
    }

    @Test
    public void testarFuncionamentoDoFacaAlgoAssumindoValorGrandeVindoDoMetodoAuxiliar()
            throws MinhaExcecao, DataInvalidaException, OutraExcecaoQualquer {

        // primeiro teste, assumindo valor de retorno 5 para aqueeeeele método lento auxiliar
        objetoAuxiliarMock.setValorDeRetornoEspecificadoNaHoraPeloTeste(50000);

        int resultado = meuObjetoASerTestado.facaAlgo(10, "blablabla");
        assertEquals(501, resultado);

        resultado = meuObjetoASerTestado.facaAlgo(-599, "dslkfjsdfk");
        assertEquals(501, resultado);
    }

    private class ObjetoAuxiliarMock extends ObjetoAuxiliar {

        int valorDeRetornoEspecificadoNaHoraPeloTeste;

        @Override
        public int facaAlgoImportanteParaAMinhaTarefa()
                throws ExcecaoEspecifica, OutraExcecaoQualquer, MinhaExcecao {

            return valorDeRetornoEspecificadoNaHoraPeloTeste;
        }

        void setValorDeRetornoEspecificadoNaHoraPeloTeste(int valor) {
            valorDeRetornoEspecificadoNaHoraPeloTeste = valor;
        }
    }

}