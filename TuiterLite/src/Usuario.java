import java.awt.*;
import java.util.Objects;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private final String email;
    private String nome;
    private Image foto;
    private int contTuites;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private NivelUsuario nivel;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.contTuites = 0;
        this.nivel = NivelUsuario.INICIANTE;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    void contabilizarNovoTuite() {
        this.contTuites++;
        atualizarNivel();
    }

    private void atualizarNivel() {
        if (this.contTuites >= MIN_TUITES_NINJA) {
            this.nivel = NivelUsuario.NINJA;
        } else if (this.contTuites >= MIN_TUITES_SENIOR) {
            this.nivel = NivelUsuario.SENIOR;
        } else {
            this.nivel = NivelUsuario.INICIANTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }
}
