public class ImpressoraMatricial extends Impressora {

    public ImpressoraMatricial(String nome) {
        super(nome, "Única Marca do Mundo Para Matriciais");
    }

    @Override
    public void imprimir(String texto) {
        System.out.println("Imprimindo do jeito de uma impressora matricial...");
    }
}
