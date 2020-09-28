public class ArquivoImagem extends Arquivo {

    int numeroDeCores;

    public ArquivoImagem(String nome, String extensao) {
        super(nome, extensao);
    }

    public int getNumeroDeCores() {
        return numeroDeCores;
    }

    public void setNumeroDeCores(int numeroDeCores) {
        this.numeroDeCores = numeroDeCores;
    }

    @Override
    public void exibir() {
        System.out.println("Desenhando imagem na tela...");
    }
}
