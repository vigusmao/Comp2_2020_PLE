import java.util.ArrayList;

public class AlbumSelos {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private int totalSelosDoAlbumCompleto;
    private int quantSelosPorPacotinho;
    private int totalPacotinhosRecebidos;
    private int quantSelosColadas;

    // guardaremos as selos no álbum usando ENDEREÇAMENTO DIRETO, ou seja,
    // selo de chave (no caso, a posição no álbum) x na posição x do array
    private ArrayList<Selo> selosColadas;

    // idem
    private ArrayList<Selo> selosRepetidas;


    public AlbumSelos(int totalSelos, int quantSelosPorPacotinho) {
        this.totalSelosDoAlbumCompleto = totalSelos;
        this.quantSelosPorPacotinho = quantSelosPorPacotinho;
        this.totalPacotinhosRecebidos = 0;
        this.quantSelosColadas = 0;

        this.selosColadas = new ArrayList<>();
        // inicializa o álbum com nulls, para que todas as posições do álbum já possam ser acessadas
        for (int i = 1; i <= this.totalSelosDoAlbumCompleto + 1; i++) {  // não usaremos a posição 0
            this.selosColadas.add(null);
        }

        this.selosRepetidas = new ArrayList<>();

    }

    /**
     * Recebe um novo pacotinho. Se o tamanho do pacotinho não for o tamanho "correto",
     * ignora este pacotinho.
     *
     * @param pacotinho O pacotinho novo.
     */
    public void receberNovoPacotinho(Selo[] pacotinho) {
        if (pacotinho.length != this.quantSelosPorPacotinho) {
            return;  // não faz nada!!!!
        }

        this.totalPacotinhosRecebidos++;

        for (int i = 0; i < pacotinho.length; i++) {
            Selo selo = pacotinho[i];
            if (possuiSeloColada(selo)) {
                // repetida! -- adiciono no bolinho de repetidas
                this.selosRepetidas.add(selo);
            } else {
                colarSelo(selo);
            }
        }
    }

    public int getTotalPacotinhosRecebidos() {
        return this.totalPacotinhosRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em AlbumSelos.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarSelosRestantes() {
        // valida a regra dos 10%

        if (getQuantSelosColadas() <
                this.totalSelosDoAlbumCompleto * PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
            return;  // não pode ainda auto-completar
        }

        for (int i = 1; i <= this.totalSelosDoAlbumCompleto; i++) {
            if (!possuiSeloColada(i)) {
                Selo selo = new Selo();
                selo.setPosicao(i);
                colarSelo(selo);
            }
        }
    }

    private void colarSelo(Selo selo) {
        this.selosColadas.set(selo.getPosicao(), selo);
        this.quantSelosColadas++;
    }

    public boolean possuiSeloColada(int posicao) {
        return this.selosColadas.get(posicao) != null;
    }

    public boolean possuiSeloColada(Selo selo) {  // overload
        return possuiSeloColada(selo.getPosicao());
    }

    public boolean possuiSeloRepetida(int posicao) {
        for (Selo selo : this.selosRepetidas) {
            if (selo.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiSeloRepetida(Selo selo) {  // overload
        return possuiSeloRepetida(selo.getPosicao());
    }

    public Selo getSelo(int posicao) {
        if (possuiSeloColada(posicao)) {
            return this.selosColadas.get(posicao);
        }
        return null;
    }

    public int getQuantSelosColadas() {
        return this.quantSelosColadas;
    }

    public int getQuantSelosRepetidas() {
        return this.selosRepetidas.size();
    }

    public int getQuantSelosFaltando() {
        return this.totalSelosDoAlbumCompleto - getQuantSelosColadas();
    }


}
