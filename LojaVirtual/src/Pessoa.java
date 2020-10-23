public class Pessoa implements Transportador {

    private final long cpf;
    private String nome;
    private String email;
    private String endereco;

    public Pessoa(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void transportar(Vendavel item, int quantidade, String enderecoDeEntrega) {
        // ToDo
    }
}
