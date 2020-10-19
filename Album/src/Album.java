import java.util.ArrayList;

public class Album<T extends Colecionavel> {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private int totalItensDoAlbumCompleto;
    private int quantItensPorPacotinho;
    private int totalItensRecebidos;
    private int quantItensColados;

    // guardaremos os itens no álbum usando ENDEREÇAMENTO DIRETO, ou seja,
    // item de chave (no caso, a posição no álbum) x na posição x do array
    private ArrayList<T> itensColados;

    // idem
    private ArrayList<T> itensRepetidos;


    public Album(int totalItens, int quantItensPorPacotinho) {
        this.totalItensDoAlbumCompleto = totalItens;
        this.quantItensPorPacotinho = quantItensPorPacotinho;
        this.totalItensRecebidos = 0;
        this.quantItensColados = 0;

        this.itensColados = new ArrayList<>();
        // inicializa o álbum com nulls, para que todas as posições do álbum já possam ser acessadas
        for (int i = 1; i <= this.totalItensDoAlbumCompleto + 1; i++) {  // não usaremos a posição 0
            this.itensColados.add(null);
        }

        this.itensRepetidos = new ArrayList<>();

    }

    /**
     * Recebe um novo pacotinho. Se o tamanho do pacotinho não for o tamanho "correto",
     * ignora este pacotinho.
     *
     * @param pacotinho O pacotinho novo.
     */
    public void receberNovoPacotinho(T[] pacotinho) {
        if (pacotinho.length != this.quantItensPorPacotinho) {
            return;  // não faz nada!!!!
        }

        this.totalItensRecebidos++;

        for (int i = 0; i < pacotinho.length; i++) {
            T item = pacotinho[i];
            if (possuiItemColado(item)) {
                // repetida! -- adiciono no bolinho de repetidas
                this.itensRepetidos.add(item);
            } else {
                colarItem(item);
            }
        }
    }

    public int getTotalItensRecebidos() {
        return this.totalItensRecebidos;
    }

//    /**
//     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
//     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
//     *
//     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
//     * não faz nada.
//     */
//    public void encomendarItensRestantes() {
//        // valida a regra dos 10%
//
//        if (getQuantItensColados() <
//                this.totalItensDoAlbumCompleto * PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
//            return;  // não pode ainda auto-completar
//        }
//
//        for (int i = 1; i <= this.totalItensDoAlbumCompleto; i++) {
//            if (!possuiItemColado(i)) {
//                Figurinha item = new Figurinha();
//                item.setPosicao(i);
//                colarItem(item);
//            }
//        }
//    }

    private void colarItem(T item) {
        this.itensColados.set(item.getPosicao(), item);
        this.quantItensColados++;
    }

    public boolean possuiItemColado(int posicao) {
        return this.itensColados.get(posicao) != null;
    }

    public boolean possuiItemColado(T figurinha) {  // overload
        return possuiItemColado(figurinha.getPosicao());
    }

    public boolean possuiItemRepetido(int posicao) {
        for (T item : this.itensRepetidos) {
            if (item.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiItemRepetido(T item) {  // overload
        return possuiItemRepetido(item.getPosicao());
    }

    public T getItem(int posicao) {
        if (possuiItemColado(posicao)) {
            return this.itensColados.get(posicao);
        }
        return null;
    }

    public int getQuantItensColados() {
        return this.quantItensColados;
    }

    public int getQuantItensRepetidos() {
        return this.itensRepetidos.size();
    }

    public int getQuantItensFaltando() {
        return this.totalItensDoAlbumCompleto - getQuantItensColados();
    }
}
