public class MailWebClient {

    private int numeroDeExibicoesDeArquivo;

    public void exibirArquivo(EmailRecebido email) {
        email.extrairArquivo();
        Arquivo arquivo = email.getArquivoEmAnexo();

        if (arquivo == null) {
            System.out.println("Arquivo nulo ou inexistente");
            return;  // nada a fazer
        }

        arquivo.exibir();

        this.numeroDeExibicoesDeArquivo++;
    }

    public static void main(String[] args) {
        MailWebClient mailWebClient = new MailWebClient();

        // suponha que recebemos um email...
        EmailRecebido emailRecebido = new EmailRecebido();
        // ...e queremos exibir seu arquivo em anexo
        mailWebClient.exibirArquivo(emailRecebido);

    }
}
