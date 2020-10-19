public class Selo {

    private int posicao;

    private float valorNominal;

    private String pais;

    // ...

    public Selo() {

    }

    public Selo(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public float getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(float valorNominal) {
        this.valorNominal = valorNominal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
