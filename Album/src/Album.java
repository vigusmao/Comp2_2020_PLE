import java.util.ArrayList;

public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private int totalFigurinhasDoAlbumCompleto;
    private int quantFigurinhasPorPacotinho;
    private int totalPacotinhosRecebidos;

    // guardaremos as figurinhas NA ORDEM EM QUE FORAM RECEBIDAS, isto é, de forma desordenada por posição
    private ArrayList<Figurinha> figurinhasColadas;

    // idem
    private ArrayList<Figurinha> figurinhasRepetidas;


    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhasDoAlbumCompleto = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.totalPacotinhosRecebidos = 0;

        this.figurinhasColadas = new ArrayList<>();
        this.figurinhasRepetidas = new ArrayList<>();

    }

    /**
     * Recebe um novo pacotinho. Se o tamanho do pacotinho não for o tamanho "correto",
     * ignora este pacotinho.
     *
     * @param pacotinho O pacotinho novo.
     */
    public void receberNovoPacotinho(Figurinha[] pacotinho) {
        if (pacotinho.length != this.quantFigurinhasPorPacotinho) {
            return;  // não faz nada!!!!
        }

        this.totalPacotinhosRecebidos++;

        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            if (possuiFigurinhaColada(figurinha)) {
                // repetida! -- adiciono no bolinho de repetidas
                this.figurinhasRepetidas.add(figurinha);
            } else {
                this.figurinhasColadas.add(figurinha);
            }
        }

        // equivalentemente, usar um "for each"
//        for (Figurinha figurinha : pacotinho) {
//            if (possuiFigurinhaColada(figurinha)) {
//                // repetida! -- adiciono no bolinho de repetidas
//                this.figurinhasRepetidas.add(figurinha);
//            } else {
//                this.figurinhasColadas.add(figurinha);
//            }
//        }
    }

    public int getTotalPacotinhosRecebidos() {
        return this.totalPacotinhosRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        // valida a regra dos 10%

        if (getQuantFigurinhasColadas() <
                this.totalFigurinhasDoAlbumCompleto * PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
            return;  // não pode ainda auto-completar
        }

        for (int i = 1; i <= this.totalFigurinhasDoAlbumCompleto; i++) {
            if (!possuiFigurinhaColada(i)) {
                Figurinha figurinha = new Figurinha(
                        i, "http://urlDaFigurinha" + i + ".jpg");
                this.figurinhasColadas.add(figurinha);
            }
        }
    }

    public boolean possuiFigurinhaColada(int posicao) {
        for (Figurinha figurinha : this.figurinhasColadas) {
            if (figurinha.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        for (Figurinha figurinha : this.figurinhasRepetidas) {
            if (figurinha.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        return this.figurinhasColadas.size();
    }

    public int getQuantFigurinhasRepetidas() {
        return this.figurinhasRepetidas.size();
    }

    public int getQuantFigurinhasFaltando() {
        return this.totalFigurinhasDoAlbumCompleto - getQuantFigurinhasColadas();
    }

}
