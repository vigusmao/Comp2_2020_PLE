public class Principal {

    public static void main(String[] args) {

        LojaVirtual loja = new LojaVirtual();


        Livro livro = new Livro("Calculo II", "Simmons", 1968, 500, 120);

        loja.incluirItemNoEstoque(livro, 10);
    }

}
