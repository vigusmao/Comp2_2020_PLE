import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AlbumTest {

    private Random random = new Random();

    private Album<Figurinha> album;
    private final int TOTAL_FIGURINHAS = 200;
    private final int QUANT_FIGURINHAS_POR_PACOTE = 3;

    @Before
    public void setUp() {
        album = new Album<>(TOTAL_FIGURINHAS, QUANT_FIGURINHAS_POR_PACOTE);
    }

    @Test
    public void testarRecebimentoPacotinhoQualquer() {
        Figurinha[] novoPacotinho = criarPacotinhoFigurinhas(null);  // posições aleatórias

        album.receberNovoPacotinho(novoPacotinho);
        assertEquals(1, album.getTotalItensRecebidos());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE,
                album.getQuantItensColados() + album.getQuantItensRepetidos());

        for (Figurinha item : novoPacotinho) {
            assertTrue(album.possuiItemColado(item));
        }

        // equivalentemente... (e pior!)
//        for (int i = 0; i < QUANT_FIGURINHAS_POR_PACOTE; i++) {
//            assertTrue(album.possuiItemColado(novoPacotinho[i]));
//        }

    }

    @Test
    public void testarRecebimentoFigurinhaRepetida() {

        int[] posicoes = new int[] {1, 1, 1};

        // equivalentemente...
//        int[] posicoes = new int[3];
//        posicoes[0] = 1;
//        posicoes[1] = 1;
//        posicoes[2] = 1;
        Figurinha[] primeiroPacotinho = criarPacotinhoFigurinhas(posicoes);

        album.receberNovoPacotinho(primeiroPacotinho);
        assertEquals(1, album.getQuantItensColados());
        assertEquals(TOTAL_FIGURINHAS - 1, album.getQuantItensFaltando());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE - 1, album.getQuantItensRepetidos());
        assertTrue(album.possuiItemRepetido(1));
        assertTrue(album.possuiItemRepetido(primeiroPacotinho[0]));  // outra forma
        Figurinha item = new Figurinha();
        item.setPosicao(1);
        assertTrue(album.possuiItemRepetido(item));  // outra forma


        posicoes = new int[] {10, 23, 1};
        Figurinha[] segundoPacotinho = criarPacotinhoFigurinhas(posicoes);
        album.receberNovoPacotinho(segundoPacotinho);
        assertEquals(3, album.getQuantItensColados());
        assertEquals(QUANT_FIGURINHAS_POR_PACOTE, album.getQuantItensRepetidos());
        assertTrue(album.possuiItemColado(10));
        assertTrue(album.possuiItemColado(23));
        assertFalse(album.possuiItemRepetido(10));
        assertFalse(album.possuiItemRepetido(23));
        assertTrue(album.possuiItemRepetido(1));

        assertEquals(2, album.getTotalItensRecebidos());
    }

//    @Test
//    public void testarPreenchimentoAutomaticoDasUltimasFigurinhas() {
//        // aqui o álbum está ainda vazio
//        album.encomendarItensRestantes();
//        assertEquals("Não deve ser possível encomendar as selos faltantes " +
//                "antes de ter 90% ou mais do álbum já preenchido",
//                0, album.getQuantItensColados());
//
//        // vamos agora preencher o álbum quase totalmente
//        float limiteMinimo = TOTAL_FIGURINHAS * Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR;
//        while (album.getQuantItensColados() < limiteMinimo) {
//            Figurinha[] pacotinho = criarPacotinho(null);
//            album.receberNovoPacotinho(pacotinho);
//        }
//
//        album.encomendarItensRestantes();
//        assertEquals("Depois da encomenda, o álbum deve estar completo",
//                TOTAL_FIGURINHAS, album.getQuantItensColados());
//    }

    @Test
    public void testarPacotinhoRecebidoComTamanhoErrado() {
        Figurinha[] pacotinhoTosco = criarPacotinhoFigurinhas(new int[] {2, 7});
        album.receberNovoPacotinho(pacotinhoTosco);
        assertEquals(0, album.getTotalItensRecebidos());
        assertEquals(0, album.getQuantItensColados());
        assertEquals(0, album.getQuantItensRepetidos());
    }

    @Test
    public void testarItensComTiposMisturados() {
        int[] posicoes = new int[] {10, 12, 15};
        Figurinha[] primeiroPacotinho = criarPacotinhoFigurinhas(posicoes);
        album.receberNovoPacotinho(primeiroPacotinho);

        // sdflksdlkdsj

        Colecionavel item;

        for (int posicao : posicoes) {
            item = album.getItem(posicao);
            assertEquals(posicao, item.getPosicao());
        }

        item = album.getItem(33);
        assertNull(item);
    }

    private Colecionavel[] criarPacotinhoComTiposMisturados(int[] posicoesDesejadas) {
        int tamanhoPacotinho = posicoesDesejadas == null ?
                QUANT_FIGURINHAS_POR_PACOTE :
                posicoesDesejadas.length;

        Colecionavel[] novoPacotinho = new Colecionavel[tamanhoPacotinho];
        for (int i = 0; i < tamanhoPacotinho; i++) {
            int posicaoDaFigurinha = posicoesDesejadas == null ? escolherPosicaoAleatoria() :
                    posicoesDesejadas[i];
            Colecionavel item = posicaoDaFigurinha % 2 == 0 ? new Figurinha() : new Selo();
            item.setPosicao(posicaoDaFigurinha);
            novoPacotinho[i] = item;
        }
        return novoPacotinho;
    }

    private Selo[] criarPacotinhoSelos(int[] posicoesDesejadas) {
        int tamanhoPacotinho = posicoesDesejadas == null ?
                QUANT_FIGURINHAS_POR_PACOTE :
                posicoesDesejadas.length;

        Selo[] novoPacotinho = new Selo[tamanhoPacotinho];
        for (int i = 0; i < tamanhoPacotinho; i++) {
            int posicaoDaFigurinha = posicoesDesejadas == null ? escolherPosicaoAleatoria() :
                    posicoesDesejadas[i];
            Selo item = new Selo();
            item.setPosicao(posicaoDaFigurinha);
            novoPacotinho[i] = item;
        }
        return novoPacotinho;
    }

    private Figurinha[] criarPacotinhoFigurinhas(int[] posicoesDesejadas) {
        int tamanhoPacotinho = posicoesDesejadas == null ?
                QUANT_FIGURINHAS_POR_PACOTE :
                posicoesDesejadas.length;

        Figurinha[] novoPacotinho = new Figurinha[tamanhoPacotinho];
        for (int i = 0; i < tamanhoPacotinho; i++) {
            int posicaoDaFigurinha = posicoesDesejadas == null ? escolherPosicaoAleatoria() :
                    posicoesDesejadas[i];
            Figurinha item = new Figurinha();
            item.setPosicao(posicaoDaFigurinha);
            novoPacotinho[i] = item;
        }
        return novoPacotinho;
    }

    private int escolherPosicaoAleatoria() {
        return random.nextInt(TOTAL_FIGURINHAS) + 1;
    }
}