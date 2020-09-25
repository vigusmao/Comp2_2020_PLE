public class Produto {

    private static long nextSeqNum = 1;

    protected final long id;  // identificador único (sequencial) deste objeto

    public Produto() {
        this.id = nextSeqNum++;
    }

    public long getId() {
        return this.id;
    }
}
