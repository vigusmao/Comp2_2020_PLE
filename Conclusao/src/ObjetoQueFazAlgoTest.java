import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ObjetoQueFazAlgoTest {

    private ObjetoQueFazAlgo meuObjetoASerTestado;

    private ObjetoAuxiliar objetoAuxiliarMock;

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
        objetoAuxiliarMock = Mockito.mock(ObjetoAuxiliar.class);  // new ObjetoAuxiliar();
        meuObjetoASerTestado.setOutroObjeto(objetoAuxiliarMock);
    }

    @Test
    public void testarFuncionamentoDoFacaAlgoAssumindoValorPequenoVindoDoMetodoAuxiliar()
            throws MinhaExcecao, DataInvalidaException, OutraExcecaoQualquer, ExcecaoEspecifica {

        // primeiro teste, assumindo valor de retorno 5 para aqueeeeele método lento auxiliar
        when(objetoAuxiliarMock.facaAlgoImportanteParaAMinhaTarefa()).thenReturn(5);

        int resultado = meuObjetoASerTestado.facaAlgo(10, "blablabla");
        assertEquals(512, resultado);

        resultado = meuObjetoASerTestado.facaAlgo(-599, "dslkfjsdfk");
        assertEquals(501, resultado);
    }

    @Test
    public void testarFuncionamentoDoFacaAlgoAssumindoValorGrandeVindoDoMetodoAuxiliar()
            throws MinhaExcecao, DataInvalidaException, OutraExcecaoQualquer, ExcecaoEspecifica {

        // segundo teste, assumindo valor de retorno 5 para aqueeeeele método lento auxiliar
        when(objetoAuxiliarMock.facaAlgoImportanteParaAMinhaTarefa()).thenReturn(50000);

        int resultado = meuObjetoASerTestado.facaAlgo(10, "blablabla");
        assertEquals(501, resultado);

        resultado = meuObjetoASerTestado.facaAlgo(-599, "dslkfjsdfk");
        assertEquals(501, resultado);
    }
}