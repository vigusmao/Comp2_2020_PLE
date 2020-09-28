import java.awt.*;

public class Impressora {

    private String nome;
    private String marca;

    private int quantCaracteresImpressos;
    private int quantCaracteresImpressosDesdeUltimaRecarga;

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

        System.out.println("Enviando texto para a impressora física...");
    }

    public void imprimir(Image imagem) {
        // ToDo
    }

    boolean verificarNecessidadeRecarga(String texto) {
        System.out.println("Verificando a necessidade de recarga...");

        float percentualJaConsumido = quantCaracteresImpressosDesdeUltimaRecarga *
                consumoPercentualPorCaracter;

        float percentualRequerido = texto.length() *
                consumoPercentualPorCaracter;

        return percentualJaConsumido + percentualRequerido > 100;
    }

    public void recarregar() {
        System.out.println("Recarregando...");

        quantCaracteresImpressosDesdeUltimaRecarga = 0;
    }

}
