public class ListaAgencias {

    private Agencia[] itens;
    private int quantItens;

    public ListaAgencias() {
        itens = new Agencia[4];
        quantItens = 0;
    }

    /**
     * Adiciona um item novo na primeira posição vaga da lista.
     *
     * @param item O novo item.
     */
    public void adicionarItem(Agencia item) {
        if (this.quantItens == this.itens.length) {
            // array "cheio", preciso criar novo array
            redimensionarArray();
        }
        this.itens[this.quantItens++] = item;
    }

    /**
     * @return a quantidade de objetos presentes na lista
     */
    public int getTamanho() {
        return quantItens;
    }

    /**
     * Retorna o item da posição desejada.
     *
     * @param posicao a posição desejada
     * @return o item desejado, caso exista; null, se a posição informada não existir na lista
     */
    public Object obterItem(int posicao) {
        if (posicao >= this.quantItens || posicao < 0) {
            return null;  // como combinado
        }
        return this.itens[posicao];
    }

    private void redimensionarArray() {
        // crio um novo array
        Agencia[] novoArray = new Agencia[this.itens.length * 2];

        // copio o array antigo para o array novo
        for (int i = 0; i < this.itens.length; i++) {
            novoArray[i] = this.itens[i];
        }

        // reaponto o atributo this.itens para a nova região de memória alocada
        this.itens = novoArray;
    }
}
