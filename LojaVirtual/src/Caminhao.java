public class Caminhao implements Transportador {

    private String nome;

    private int capacidadeMaximaEmKg;

    private int volumeMaximoEmCentimetrosCubicos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMaximaEmKg() {
        return capacidadeMaximaEmKg;
    }

    public void setCapacidadeMaximaEmKg(int capacidadeMaximaEmKg) {
        this.capacidadeMaximaEmKg = capacidadeMaximaEmKg;
    }

    public int getVolumeMaximoEmCentimetrosCubicos() {
        return volumeMaximoEmCentimetrosCubicos;
    }

    public void setVolumeMaximoEmCentimetrosCubicos(int volumeMaximoEmCentimetrosCubicos) {
        this.volumeMaximoEmCentimetrosCubicos = volumeMaximoEmCentimetrosCubicos;
    }

    public void transportar(Vendavel item, int quantidade, String enderecoDeEntrega) {
        // ToDo
    }
}
