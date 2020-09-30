public class ImpressoraMatricial extends Impressora {

    public ImpressoraMatricial(String nome) {
        super(nome, "Única Marca do Mundo Para Matriciais");
    }

    @Override
    protected boolean executarImpressaoNoPapel(String texto) {
        System.out.println("Jogando tinta no papel do jeito que uma matricial faz...");
        return true;
    }

    @Override
    public void efetuarRecarga() {
        System.out.println("Trocando fita da impressora matricial...");
    }
}
