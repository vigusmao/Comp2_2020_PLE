import java.util.Objects;

public class Produto {

    private static long nextSeqNum = 1;

    protected final long id;  // identificador único (sequencial) deste objeto

    private String descricao;

    private int pesoEmGramas;

    private int volumeEmCentimetrosCubicos;

    private float precoEmReais;

    private CategoriaProduto categoria;

    private int quantidadeEmEstoque;

    public Produto(String descricao, CategoriaProduto categoria, float precoEmReais) {
        this.id = nextSeqNum++;
        this.descricao = descricao;
        this.categoria = categoria;
        this.precoEmReais = precoEmReais;
    }

    public long getId() {
        return this.id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public void setPesoEmGramas(int pesoEmGramas) {
        this.pesoEmGramas = pesoEmGramas;
    }

    public int getVolumeEmCentimetrosCubicos() {
        return volumeEmCentimetrosCubicos;
    }

    public void setVolumeEmCentimetrosCubicos(int volumeEmCentimetrosCubicos) {
        this.volumeEmCentimetrosCubicos = volumeEmCentimetrosCubicos;
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
