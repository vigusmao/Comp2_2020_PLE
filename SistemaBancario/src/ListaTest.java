import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ListaTest {

    @Test
    public void testarOperacoesBasicas() {
        Lista minhaLista = new Lista();
        minhaLista.adicionarItem("1111");
        minhaLista.adicionarItem("22222");
        minhaLista.adicionarItem("333343243");
        Correntista correntista = new Correntista("Vinicius", 1234);
        minhaLista.adicionarItem(correntista);
        minhaLista.adicionarItem(correntista);
        minhaLista.adicionarItem(correntista);
        minhaLista.adicionarItem("09191091");

        assertEquals(7, minhaLista.getTamanho());

        assertEquals("22222", minhaLista.obterItem(1));
        assertEquals(correntista, minhaLista.obterItem(5));
    }
}