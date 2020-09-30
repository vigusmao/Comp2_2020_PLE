public class ImpressoraJatoDeTinta extends Impressora {

    private boolean colorida;

    public ImpressoraJatoDeTinta(String nome, String marca, boolean colorida) {
        super(nome, marca);
        this.colorida = colorida;
    }

    public void executarLimpezaBicos() {
        System.out.println("Executando limpeza dos bicos...");
    }

    public boolean isColorida() {
        return colorida;
    }

    public void setColorida(boolean colorida) {
        this.colorida = colorida;
    }

    @Override
    protected boolean executarImpressaoNoPapel(String texto) {
        if (texto.length() > 2) {
            executarLimpezaBicos();
        }

        System.out.println("Jogando tinta no papel do jeito que uma jato de tinta faz...");
        return true;
    }

    @Override
    public void efetuarRecarga() {
        System.out.println("Recarregando tinta da impressora jato de tinta...");
    }
}
