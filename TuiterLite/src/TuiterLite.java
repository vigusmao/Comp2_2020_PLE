import java.util.*;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite<T> {

    public static final int TAMANHO_MAXIMO_TUITES = 120;

    private Map<String, Usuario> usuarioByEmail;

    private Map<String, Integer> contByHashtag;
    private String hashtagMaisComum;
    private int contOcorrenciasHashtagMaisComum;

    public TuiterLite() {
        this.usuarioByEmail = new HashMap<>();
        this.contByHashtag = new HashMap<>();
    }

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retorna null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {
        Usuario novoUsuario = new Usuario(nome, email);

        if (this.usuarioByEmail.containsKey(email)) {
            return null;
        }

        this.usuarioByEmail.put(email, novoUsuario);

        return novoUsuario;
    }

    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, lança exceção.
     * Se o usuário não estiver cadastrado, lança exceção.
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     *
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * @throws TamanhoMaximoExcedidoException se o texto for maior do que o limite permitido
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) throws TamanhoMaximoExcedidoException {

        if (texto.length() > TAMANHO_MAXIMO_TUITES) {
            throw new TamanhoMaximoExcedidoException();
        }

        Usuario usuarioExistente = this.usuarioByEmail.get(usuario.getEmail());
        // verifica se o usuário é conhecido
        if (usuarioExistente == null) {
            return null;  // ToDo lançar uma exceção
        }

        Tuite tuite = new Tuite(usuario, texto);

        Collection<String> hashtagsDoTuite = tuite.getHashtags();

        for (String hashtag : hashtagsDoTuite) {
            int cont = localizarOcorrenciasAnteriores(hashtag);
            this.contByHashtag.put(hashtag, ++cont);
            if (cont > this.contOcorrenciasHashtagMaisComum) {
                this.hashtagMaisComum = hashtag;
                this.contOcorrenciasHashtagMaisComum = cont;
            }
        }

        usuario.contabilizarNovoTuite();
        return tuite;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        return this.hashtagMaisComum;
    }

    private int localizarOcorrenciasAnteriores(String hashtag) {
        Integer resultado = this.contByHashtag.get(hashtag);
        return resultado == null ? 0 : resultado;

//        // outro jeito
//        if (this.contByHashtag.containsKey(hashtag)) {
//            return this.contByHashtag.get(hashtag);
//        }
//
//        return 0;
    }

    // Mainzinho bobo, apenas ilustrando String.split(regexp), e o String.startsWith()


    private static int encontrarMaior(List<Integer> lista) {
        return Collections.max(lista);

//        int maior = Integer.MIN_VALUE;
//        for (int elemento : lista) {
//            if (elemento > maior) {
//                maior = elemento;
//            }
//        }
//
//        return maior;
    }



    public static void main(String[] args) {

        int tamanho = 500_000_000;
        List<Integer> lista = new ArrayList<>(tamanho);

        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            lista.add(random.nextInt());
        }

        System.out.println("Encontrando o maior...");
        long inicio = System.currentTimeMillis();
        int maior = encontrarMaior(lista);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nmaior = %d (duracao = %d milissegundos)", maior, duracao);


    }
}
