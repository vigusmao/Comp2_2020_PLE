public class Roupa extends Produto {

    private final char tamanho;  //  'p' 'm' 'g', etc.
    private final String cor;

    public Roupa(String descricao, char tamanho, String cor, float precoEmReais) {
        super(String.format("Roupa: %s (tamanho %c)", descricao, tamanho),
                CategoriaProduto.VESTUARIO, precoEmReais);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public char getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }
}
