public class ObjetoQueFazAlgo {

    private int atributo1;

    private float atributo2;

    ObjetoAuxiliar outroObjeto;

    public ObjetoQueFazAlgo() {
        outroObjeto = new ObjetoAuxiliar();  // composicao
    }

    public int facaAlgo(int parametro1, String parametro2)
            throws MinhaExcecao, DataInvalidaException, OutraExcecaoQualquer {

        // verifica se os parâmetros fazem sentido
        if (false) {  // se parâmetro inválido, por exemplo, valor negativo a ser sacado
            throw new MinhaExcecao();
        }

        // verifica quais outras pré-condições (estado global do sistema)
        if (false) {  // exemplo, verifica se hoje é um dia útil (se não for, não pode sacar)
            throw new DataInvalidaException();
        }
        // agora de fato faz o que foi pedido

        try {
            executaMetodoAuxiliar1(parametro1);
        } catch (ExcecaoEspecifica excecaoEspecifica) {
            excecaoEspecifica.printStackTrace();
        }

        String s = executaMetodoAuxiliar2(parametro2);

//        try {
//            outroObjeto.facaAlgoImportanteParaAMinhaTarefa();
//        } catch (ExcecaoEspecifica e) {
//            // trato a exceção aqui mesmo, do jeito que eu achar conveniente
//        }

        // ou...

        try {

            int resultadoRecebidoDoObjetoAuxiliar = outroObjeto.facaAlgoImportanteParaAMinhaTarefa();

            atributo1 = resultadoRecebidoDoObjetoAuxiliar;  // faco o que eu quiser com o valor recebido
            // 1
            // 2
            // terminou

        } catch (ExcecaoEspecifica|OutraExcecaoQualquer e) {
            // trato localmente, se quisertrato localmente, se quiser
//            throw e;   // e relanço a mesma exçeção, se quiser
            throw new OutraExcecaoQualquer();  // ou lanço uma exceção que faça mais sentido para o meu chamador
        } catch (MinhaExcecao e) {
            // resolve o problema e segue a vida!
        } finally {
            // faz algo (normalmente usado para fechar/liberar algum recurso que foi alocado)
        }

        try {
            outroObjeto.facaAlgoImportanteParaAMinhaTarefa();
        } catch (ExcecaoEspecifica excecaoEspecifica) {
            excecaoEspecifica.printStackTrace();
        }


        if (s.length() > 10) {
            // aja de um jeito
        } else {
            // aja de outro jeito
        }

        // segue fazendo o que foi pedido

        if (atributo1 > parametro1) {
            return 501;
        }

        return 502 + parametro1;
    }

    private void executaMetodoAuxiliar1(int x) throws ExcecaoEspecifica {

    }

    private String executaMetodoAuxiliar2(String s) {
        // aplica uma logica qualquer e retorna uma String
        return "12134ckjxc";
    }

    public int getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(int atributo1) {
        this.atributo1 = atributo1;
    }

    public float getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(float atributo2) {
        this.atributo2 = atributo2;
    }

    public ObjetoAuxiliar getOutroObjeto() {
        return outroObjeto;
    }

    public void setOutroObjeto(ObjetoAuxiliar outroObjeto) {
        this.outroObjeto = outroObjeto;
    }
}
