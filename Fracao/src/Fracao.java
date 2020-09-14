public class Fracao {

    public static final String SEPARADOR = "/";

    private int numerador;
    private int denominador;
    private boolean positiva;

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean positiva) {
        if (numerador < 0 || denominador <= 0) {
            // ToDo lançar uma exçeção
            numerador = 0;  // por ora criaremos uma fração nulo se parâetros inválidos
        }

        if (numerador == 0) {  // padroniza frações nulas
            this.numerador = 0;
            this.denominador = 1;  // sempre 1 para frações nulas
            this.positiva = false;

        } else {
            this.numerador = numerador;
            this.denominador = denominador;
            this.positiva = positiva;
        }
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
        double valor = this.numerador / (double) this.denominador;  // ToDo poderia memoizar!!
        return this.positiva ? valor : -valor;
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */
    public Fracao getFracaoGeratriz() {

        if (numerador == 0) {  // fracao nula
            return this;
        }

        int mdc = MatematicaBasica.calcularMdc(this.numerador, this.denominador);

        if (mdc == 1) {
            return this;
        }

        Fracao fracaoGeratriz = new Fracao(
                this.numerador / mdc, this.denominador / mdc, this.positiva);

        return fracaoGeratriz;  // ToDo poderia memoizar!!
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public boolean isPositiva() {
        return this.positiva;
    }

    @Override
    public String toString() {
        return String.format("%s%d%s",
                !this.positiva && this.numerador != 0 ? "-" : "",
                this.numerador,
                this.denominador == 1 ? "" :
                        String.format("%s%d", SEPARADOR, this.denominador));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Fracao.class) {
            return false;
        }

        Fracao outraFracao = (Fracao) obj;

        // um jeito não muito bom (porque pode ter problema de precisão)
        // return outraFracao.getValorNumerico() == this.getValorNumerico();

        Fracao minhaFracaoGeratriz = this.getFracaoGeratriz();
        Fracao outraFracaoGeratiz = outraFracao.getFracaoGeratriz();

        return minhaFracaoGeratriz.getNumerador() == outraFracaoGeratiz.getNumerador() &&
                minhaFracaoGeratriz.getDenominador() == outraFracaoGeratiz.getDenominador() &&
                this.isPositiva() == outraFracao.isPositiva();
    }
}
