import java.util.ArrayList;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;

    private ArrayList<String> hashtags;

    private T anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.hashtags = new ArrayList<>();
        extrairHashtags();
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    public Object getAnexo() {
        return anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    private void extrairHashtags() {
        String[] tokens = this.texto.split("[\\s,]");
        for (String token : tokens) {
            if (token.startsWith("#")) {
                this.hashtags.add(token);
            }
        }
    }
}
