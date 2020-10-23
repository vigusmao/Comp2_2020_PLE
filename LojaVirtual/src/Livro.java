public class Livro extends Produto implements Vendavel {

    private final String titulo;

    private final String autor;

    private final int anoDePublicacao;

    private final int numeroDePaginas;

    public Livro(String titulo, String autor,
                 int anoDePublicacao, int numeroDePaginas,
                 float precoEmReais) {
        super(String.format("Livro: %s (%s)", titulo, autor),
                CategoriaProduto.PUBLICACAO, precoEmReais);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String toString() {
        return String.format("Livro %s com id %d, contendo %d paginas",
                this.titulo, this.id, this.numeroDePaginas);
    }

}
