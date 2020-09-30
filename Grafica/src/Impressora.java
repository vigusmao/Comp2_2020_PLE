import java.awt.*;

public abstract class Impressora {

    private String nome;
    private String marca;

    private int quantCaracteresImpressos;
    protected int quantCaracteresImpressosDesdeUltimaRecarga;

    private float consumoPercentualPorCaracter;

    // se eu não coloco construtor algum, será acrescentado automaticamente como abaixo
//    public Impressora() {
//        super();
//    }

    public Impressora(String nome, String marca) {
//        super();  // <------ acrescentado automaticamente pelo compilador Java
        this.nome = nome;
        this.marca = marca;
        this.consumoPercentualPorCaracter = 0.001f;  // default
    }

    public float getConsumoPercentualPorCaracter() {
        return consumoPercentualPorCaracter;
    }

    public void setConsumoPercentualPorCaracter(float consumoPercentualPorCaracter) {
        this.consumoPercentualPorCaracter = consumoPercentualPorCaracter;
    }

    public void imprimir(String texto) {
        if (verificarNecessidadeRecarga(texto)) {
            recarregar();
        }

        quantCaracteresImpressos += texto.length();
        quantCaracteresImpressosDesdeUltimaRecarga += texto.length();

        boolean sucesso = executarImpressaoNoPapel(texto);

        if (sucesso) {
            System.out.println("Texto impresso com sucesso!");
        } else {
            System.out.println("Falha na impressão do texto");
        }
    }

    public void imprimir(Image imagem) {
        // ToDo
    }

    /**
     * Realiza a impressão DE FATO, isto é, joga tinta no papel fazendo aparecer o texto.
     * @param texto
     */
    protected abstract boolean executarImpressaoNoPapel(String texto);

    boolean verificarNecessidadeRecarga(String texto) {
        System.out.println("Verificando a necessidade de recarga...");

        float percentualJaConsumido = quantCaracteresImpressosDesdeUltimaRecarga *
                consumoPercentualPorCaracter;

        float percentualRequerido = texto.length() *
                consumoPercentualPorCaracter;

        return percentualJaConsumido + percentualRequerido > 100;
    }

    public void recarregar() {
        efetuarRecarga();
        this.quantCaracteresImpressosDesdeUltimaRecarga = 0;
    }

    protected abstract void efetuarRecarga();
}
