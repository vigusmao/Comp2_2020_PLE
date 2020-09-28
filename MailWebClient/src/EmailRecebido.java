public class EmailRecebido extends Email {

    public void extrairArquivo() {

        Arquivo arquivoRecebido = null;

        String extensao = recuperarExtensaoDoAnexo();
        String nome = recuperarNomeDoAnexo();


        switch (extensao) {
            case ".jpg":
                arquivoRecebido = new ArquivoImagem(nome, extensao);
                ((ArquivoImagem) arquivoRecebido).setNumeroDeCores(256);
                break;

            case ".txt":
                arquivoRecebido = new ArquivoTexto(nome, extensao);
                break;

            case ".wav":
                arquivoRecebido = new ArquivoSom(nome, extensao);
                break;
        }

        this.arquivoEmAnexo = arquivoRecebido;
    }

    private String recuperarExtensaoDoAnexo() {
        return ".fgdgf";  // EXEMPLO!!!!!!!!
        // na prática, a gente decodificaria de fato o anexo e veria sua extensão
    }

    private String recuperarNomeDoAnexo() {
        return "meuArquivoAnexado";  // EXEMPLO!!!!
        // na prática, a gente decodificaria de fato o anexo e veria seu nome
    }
}
