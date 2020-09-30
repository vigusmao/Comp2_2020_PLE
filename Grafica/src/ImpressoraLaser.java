public class ImpressoraLaser extends Impressora {

    public ImpressoraLaser() {
        super("Impressora a Laser Com Nome Default", "Modelo Default");
    }

    @Override
    protected boolean executarImpressaoNoPapel(String texto) {
        System.out.println("Jogando tinta no papel do jeito que uma impressora a laser faz...");
        return true;
    }

    @Override
    public void efetuarRecarga() {
        System.out.println("Trocando o toner da impressora a laser...");
    }
}
