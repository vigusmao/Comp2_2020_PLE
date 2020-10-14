public class SenhaInvalidaException extends Exception {

    private int contTentativas;

    public int getContTentativas() {
        return contTentativas;
    }

    public void setContTentativas(int contTentativas) {
        this.contTentativas = contTentativas;
    }
}
