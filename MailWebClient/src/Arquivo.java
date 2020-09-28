import java.util.Date;

public abstract class Arquivo {

    private String nome;

    private String extensao;

    private int tamanhoEmBytes;

    private final Date dataDeCriacao;

    public Arquivo(String nome, String extensao) {
        this.nome = nome;
        this.extensao = extensao;
        this.dataDeCriacao = new Date();  // now
    }

    public Byte[] getConteudo() {
        return null;  // ToDo
    }

    public int getTamanhoEmBytes() {
        return tamanhoEmBytes;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;  // ToDo
    }

    /**
     * Exibe o conteúdo do arquivo de forma amigável, isto é, dependendo do tipo
     * do arquivo, a exibição deverá ser feita de uma maneira muito específica
     * (um som deve ser tocado, um filme deve ser exibido, um texto deve ser impresso
     * na tela, etc.)
     */
    public abstract void exibir();
}
