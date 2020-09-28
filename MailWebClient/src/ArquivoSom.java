public class ArquivoSom extends Arquivo {

    public ArquivoSom(String nome, String extensao) {
        super(nome, extensao);
    }

    @Override
    public void exibir() {
        System.out.println("Tocando o som do arquivo...");
    }

}
