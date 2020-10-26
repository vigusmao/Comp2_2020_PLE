public class ArquivoCorrompidoException extends Exception {

    private final int quantLinhasInvalidas;

    public ArquivoCorrompidoException(int quantLinhasInvalidas) {
        this.quantLinhasInvalidas = quantLinhasInvalidas;
    }

    public int getQuantLinhasInvalidas() {
        return this.quantLinhasInvalidas;
    }
}
