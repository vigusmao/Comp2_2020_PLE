public class FaltouTintaException extends Exception {

    private String corFaltante;

    public FaltouTintaException(String corFaltante) {
        super();
        this.corFaltante = corFaltante;
    }

    public String getCorFaltante() {
        return corFaltante;
    }
}
