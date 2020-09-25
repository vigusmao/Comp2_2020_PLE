public class Livro extends Produto {

    private int quantPaginas;

    @Override
    public String toString() {
        return String.format("Livro com id %d, contendo %d paginas",
                this.id, this.quantPaginas);

        // ou...
        //        return "Livro com id " + this.id + ", contendo " + quantPaginas;

    }
}
