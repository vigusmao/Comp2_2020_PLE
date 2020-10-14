public class SaldoInsuficienteException extends Exception {

    private float deficit;

    public float getDeficit() {
        return deficit;
    }

    public void setDeficit(float deficit) {
        this.deficit = deficit;
    }
}
