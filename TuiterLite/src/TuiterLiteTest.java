import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class TuiterLiteTest {

    private TuiterLite tuiterLite;
    private Usuario usuario;

    @Before
    public void setUp() {
        // cria um TuiterLite
        tuiterLite = new TuiterLite();

        // cria um usuário
        usuario = tuiterLite.cadastrarUsuario("Fulano", "fulano@teste.com");

        // cria uma imagem para o usuário
        Image foto = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);  // mock
        usuario.setFoto(foto);
    }

    @Test
    public void testeUsuariosReconhecidosCorretamente() {
        assertEquals("Duas instâncias de Usuario devem ser consideradas iguais se possuirem o mesmo email",
                this.usuario, new Usuario("Fulano de Tal", "fulano@teste.com"));
    }

    @Test
    public void testeAutorDoTuite() {
        Tuite tuite = tuiterLite.tuitarAlgo(usuario, "Testando");
        assertEquals("O tuíte deve retornar corretamente seu autor",
                usuario, tuite.getAutor());
    }

    @Test
    public void testeTuiteDeUsuarioDesconhecido() {
        assertNull("Não deve ser possível tuitar algo se o usuário é desconhecido",
                tuiterLite.tuitarAlgo(
                        new Usuario("Usuário Desconhedido", "unknown@void.com"),
                        "Testando"));
    }

    @Test
    public void testeTamanhoTuite() {
        assertNotNull(tuiterLite.tuitarAlgo(usuario, "Teste curto"));

        // testaremos para 100 tamanhos diferentes, todos maiores do que o máximo permitido
        for (int excessoCaracteres = 1; excessoCaracteres <= 100; excessoCaracteres++) {

            // cria uma String muito grande
            int tamanho = TuiterLite.TAMANHO_MAXIMO_TUITES + excessoCaracteres;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= tamanho; i++) {
                sb.append("x");
            }
            String texto = sb.toString();

            assertNull("Um tuite maior do que o tamanho máximo deve ser ignorado",
                    tuiterLite.tuitarAlgo(usuario, texto));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testeAnexo() {

        Tuite tuite = tuiterLite.tuitarAlgo(usuario, "Testando");

        // vamos anexar a foto do usuário no tuíte que ele acabou de fazer
        tuite.anexarAlgo(usuario.getFoto());
        assertEquals("O tuíte deve retornar corretamente o objeto que foi anexado a ele",
                usuario.getFoto(), tuite.getAnexo());

        // agora vamos anexar um outro objeto qualquer ao mesmo tuíte
        Object objeto = new Object();
        tuite.anexarAlgo(objeto);
        assertEquals("O tuíte deve sobrescrever o anexo anterior (se existir) com o novo anexo",
                objeto, tuite.getAnexo());
    }

    @Test
    public void testeApenasUmTipoPermitidoComoAnexo() {

        // vamos criar um outro TuiterLite aqui, especificando que ele deverá se relacionar com o tipo Image
        TuiterLite<Image> tuiterLiteQueAceitaApenasImagensComoAnexo = new TuiterLite<>();
        tuiterLiteQueAceitaApenasImagensComoAnexo.cadastrarUsuario(usuario.getNome(), usuario.getEmail());
        Tuite<Image> tuite = tuiterLiteQueAceitaApenasImagensComoAnexo.tuitarAlgo(usuario, "Testando");

        // agora vamos anexar
        tuite.anexarAlgo(usuario.getFoto());
        assertNotNull(tuite.getAnexo());

        // Deixe as linhas seguintes comentadas, mas verifique o comportamento desejado indicado abaixo
        // (note que estamos tentando anexar outros tipos de objetos que não são Image).

//        tuite.anexarAlgo(usuario);       // essa linha, se fosse descomentada, daria erro de compilação
//        tuite.anexarAlgo("1234");        // essa linha, se fosse descomentada, daria erro de compilação
//        tuite.anexarAlgo(new Object());  // essa linha, se fosse descomentada, daria erro de compilação
    }

    @Test
    public void testeHashtags() {

        Tuite tuite = tuiterLite.tuitarAlgo(usuario, "#LAB5 Testando algo com #hashtag ao longo... #teste");

        // vamos testar se as hashtags (palavras iniciadas por #) foram corretamente detectadas

        assertTrue("Hashtags devem ser detectadas automaticamente e adicionadas ao tuíte",
                tuite.getHashtags().contains("#hashtag"));
        assertTrue("Hashtags devem ser detectadas automaticamente inclusive no começo do tuíte",
                tuite.getHashtags().contains("#LAB5"));
        assertTrue("Hashtags devem ser detectadas automaticamente inclusive no fim do tuite",
                tuite.getHashtags().contains("#teste"));

        // e agora vamos ver se não há falsos positivos
        assertFalse(tuite.getHashtags().contains("#algo"));
        assertFalse(tuite.getHashtags().contains("algo"));
        assertFalse(tuite.getHashtags().contains("#paralelepipedo"));

        // finalmente, vamos tuitar outra coisa para ver se as hashtags estão sendo registradas corretamente no sistema
        tuiterLite.tuitarAlgo(usuario, "Repetindo o uso de uma hashtag #LAB5");
        assertEquals("Hashtags devem ser contabilizadas corretamente pelo sistema",
                "#LAB5", tuiterLite.getHashtagMaisComum());
    }

    @Test
    public void testeTipoUsuario() {
        // sanity check
        assertEquals("Um usuário sem nenhum tuite deve estar no nível INICIANTE",
                NivelUsuario.INICIANTE, usuario.getNivel());

        // vamos tuitar várias vezes com o mesmo usuário, mas não ainda a ponto de promovê-lo ao próximo nível
        for (int i = 1; i < Usuario.MIN_TUITES_SENIOR; i++) {
            tuiterLite.tuitarAlgo(usuario, "Oi!");
        }

        // vamos verificar que o usuário ainda é INICIANTE
        assertEquals("Um usuário não pode ser promovido antes de ter feito" +
                        Usuario.MIN_TUITES_SENIOR + " tuítes",
                NivelUsuario.INICIANTE, usuario.getNivel());

        // agora vamos produzir mais um tuite daquele usuário
        tuiterLite.tuitarAlgo(usuario, "Oi! Vou ser promovido!");

        // verifique a promoção ao nível seguinte
        assertEquals("O usuário deve ser promovido automaticamente a SENIOR quando atinge a marca de " +
                Usuario.MIN_TUITES_SENIOR + " tuítes",
                NivelUsuario.SENIOR, usuario.getNivel());

        // vamos agora passá-lo para o próximo nível
        for (int i = 1; i <= Usuario.MIN_TUITES_NINJA - Usuario.MIN_TUITES_SENIOR; i++) {
            tuiterLite.tuitarAlgo(usuario, "Para o alto e avante!");
        }

        // verifique a promoção ao nível seguinte
        assertEquals("O usuário deve ser promovido automaticamente a NINJA quando atinge a marca de " +
                Usuario.MIN_TUITES_NINJA + " tuítes",
                NivelUsuario.NINJA, usuario.getNivel());
    }

    /////
    /////   ATENÇÃO: Este teste deve rodar rapidamente (poucos segundos)
    /////
    @Test
    public void testePerformanceContabilizacaoDasHashtags() {

        int tamanho = 32000;

        long inicio = System.currentTimeMillis();
        for (int i = 1; i <= tamanho; i++) {
            String hashtag = String.format("#%d", i);
            tuiterLite.tuitarAlgo(usuario, hashtag);
        }
        tuiterLite.tuitarAlgo(usuario, "#5");
        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("duracao (" + tamanho + " tuites) = " +
                duracao + " milissegundos");

        inicio = System.currentTimeMillis();
        assertEquals("#5", tuiterLite.getHashtagMaisComum());
        duracao = System.currentTimeMillis() - inicio;
        System.out.println("duracao (encontrar hashtag mais comum) = " +
                duracao + " milissegundos");
    }

    /////
    /////   ATENÇÃO: Este teste deve rodar rapidamente (poucos segundos)
    /////
    @Test
    public void testePerformanceTuites() {
        int tamanho = 32000;

        long inicio = System.currentTimeMillis();

        // vamos cadastrar um número grande de usuários
        for (int i = 1; i <= tamanho; i++) {
            String nome = String.format("Usuário %d", i);
            String email = String.format("usuario%d@email.com", i);
            tuiterLite.cadastrarUsuario(nome, email);
        }

        // agora vamos tentar fazer um número grande de tuítes com usuário desconhecido
        Usuario usuarioNaoCadastrado = new Usuario("Usuário Desconhedido", "unknown@void.com");
        for (int i = 1; i <= tamanho; i++) {
            assertNull(tuiterLite.tuitarAlgo(usuarioNaoCadastrado, "Teste"));
        }

        System.out.println("duracao = " +
                (System.currentTimeMillis() - inicio) + " milissegundos");
    }
}