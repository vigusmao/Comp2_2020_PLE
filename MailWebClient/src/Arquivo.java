import java.util.Date;

public abstract class Arquivo {

    private String nome;

    private String extensao;

    private int tamanhoEmBytes;

    private Byte[] conteudoEmBytes;

    private final Date dataCriacao;

    private Date dataUltimaModificao;

    public Arquivo(String nome, String extensao) {
        this.nome = nome;
        this.extensao = extensao;
        this.dataCriacao = new Date();  // now
    }

    public Byte[] getConteudo() {
        return conteudoEmBytes;  // ToDo
    }

    public int getTamanhoEmBytes() {
        return tamanhoEmBytes;
    }

    public Date getDataCriacao() {
        return dataCriacao;  // ToDo
    }

    /**
     * Exibe o conteúdo do arquivo de forma amigável, isto é, dependendo do tipo
     * do arquivo, a exibição deverá ser feita de uma maneira muito específica
     * (um som deve ser tocado, um filme deve ser exibido, um texto deve ser impresso
     * na tela, etc.)
     */
    public abstract void exibir();

    /**
     * Copia o conteúdo a partir de um Arquivo de origem.
     * @param outroArquivo o arquivo-fonte (origem)
     */
    public void copiar(Arquivo outroArquivo) {
        this.conteudoEmBytes = outroArquivo.getConteudo();
        this.tamanhoEmBytes = outroArquivo.getTamanhoEmBytes();
        this.dataUltimaModificao = new Date();
    }
}
