import java.util.ArrayList;

public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private int totalFigurinhasDoAlbumCompleto;
    private int quantFigurinhasPorPacotinho;

    private ArrayList<Figurinha> figurinhasColadas;
    private ArrayList<Figurinha> figurinhasRepetidas;


    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhasDoAlbumCompleto = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;

        this.figurinhasColadas = new ArrayList<>();
        this.figurinhasRepetidas = new ArrayList<>();

    }

    public void receberNovoPacotinho(Figurinha[] pacotinho) {
        // ToDo IMPLEMENT ME!!!
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            // faça alguma coisa com essa figurinha recebida
            // (uma boa ideia é armazená-la em algum tipo de estrutura)
        }

        // equivalentemente, usar um "for each"
        for (Figurinha figurinha : pacotinho) {

        }
    }

    public int getTotalPacotinhosRecebidos() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        // ToDo IMPLEMENT ME!!!    (será preciso validar a regra dos 10%)
    }

    public boolean possuiFigurinhaColada(int posicao) {
        // ToDo IMPLEMENT ME!!!
        return false;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        // ToDo IMPLEMENT ME!!!
        return false;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        // ToDo IMPLEMENT ME!!!
        return Integer.MAX_VALUE;
        // só pra retornar alguma coisa, evitando ainda o loop infinito nos testes quebrados
    }

    public int getQuantFigurinhasRepetidas() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    public int getQuantFigurinhasFaltando() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

}
