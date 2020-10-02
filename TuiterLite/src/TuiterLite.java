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

    public static int TAMANHO_MAXIMO_TUITES = 120;

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retora null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {
        // ToDo IMPLEMENT ME!!!
        return null;
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
        // ToDo IMPLEMENT ME!!!
        return null;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        // ToDo IMPLEMENT ME!!!
        return null;
    }
}
