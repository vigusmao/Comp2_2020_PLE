import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private List<Usuario> usuarios;  // transformar em um Map<String, Usuario> usuarioByEmail;

    private List<HashtagComContador> hashtags;  // transformar em um Map<String, Integer> contByHashtag;

    public TuiterLite() {
        this.usuarios = new ArrayList<>();
        this.hashtags = new ArrayList<>();
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

        if (this.usuarios.contains(novoUsuario)) {
            return null;
        }

        this.usuarios.add(novoUsuario);

        return novoUsuario;
    }

    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, não faz nada e retorna null.
     * Se o usuário não estiver cadastrado, não faz nada e retorna null.
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {

        if (texto.length() > TAMANHO_MAXIMO_TUITES) {
            return null;
        }

        if (!this.usuarios.contains(usuario)) {
            return null;
        }

        Tuite tuite = new Tuite(usuario, texto);

        Collection<String> hashtagsDoTuite = tuite.getHashtags();
        for (String hashtag : hashtagsDoTuite) {
            HashtagComContador hashtagComContador = localizarHashtagComContador(hashtag);
            if (hashtagComContador != null) {
                hashtagComContador.cont++;
            } else {
                hashtagComContador = new HashtagComContador(hashtag, 1);
                this.hashtags.add(hashtagComContador);
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
        int maxCont = 0;
        String result = null;
        for (HashtagComContador hashtagComContador : this.hashtags) {
            if (hashtagComContador.cont > maxCont) {
                maxCont = hashtagComContador.cont;
                result = hashtagComContador.hashtag;
            }
        }
        return result;
    }

    private HashtagComContador localizarHashtagComContador(String hashtag) {
        for (HashtagComContador hashtagComContador : this.hashtags) {
            if (hashtagComContador.hashtag.equals(hashtag)) {
                return hashtagComContador;
            }
        }
        return null;
    }

    private class HashtagComContador {
        final String hashtag;
        int cont;
        HashtagComContador(String hashtag, int cont) {
            this.hashtag = hashtag;
            this.cont = cont;
        }
    }

    // Mainzinho bobo, apenas ilustrando String.split(regexp), e o String.startsWith()

    public static void main(String[] args) {
        String frase = "Testando algo,sdf com #hashtags no meio #teste vamos ver!fdfgf";
        String[] palavras = frase.split("[\\s,!]");
        for (String palavra : palavras) {
            if (palavra.startsWith("#")) {
                System.out.println(palavra);
            }
        }

        // Ilustrando o uso de um StringBuilder (ou StringBuffer)
        StringBuffer sb = new StringBuffer();
        sb.append("Oi,");
        sb.append(" tudo bem?");
        sb.append("0").append("1").append(2).append("3");
        String resultadoDasConcatenacoes = sb.toString();
        System.out.println(resultadoDasConcatenacoes);

        /* equivalentemente (mas bem menos performático,
              porque cria novas Strings a cada concatenação) */
        String minhaString;
        minhaString = "Oi,";
        minhaString += " tudo bem?";
        minhaString += "0";
        minhaString += "1";
        minhaString += "2";
        minhaString += "3";
        System.out.println(minhaString);

    }
}
