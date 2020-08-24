public class Aluno {

    // atributos (regra geral: todos private)
    private String nome;
    private long dre;
    private int creditosAcumulados;  //       Somatorio_d [creditos(d)]

    private float cra;               // cra = Somatorio_d [media(d) * creditos(d) /
                                     //       creditosAcumulados


    // métodos
    void imprimirHistorico() {

    }

    public float getCra() {   // accessor method (getters and setters)
        return cra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void registrarConclusaoDisciplina(String codigoDisciplina,
                                      int quantCreditos,
                                      float mediaFinal) {

        // ToDo incluir disciplina no histórico


        // recupero o numerador corrente (antes da nova disciplina)
        float numeradorCorrenteCra = this.cra * this.creditosAcumulados;

        this.creditosAcumulados += quantCreditos;

        // atualizar o CRA do aluno
        float novaParcela = quantCreditos * mediaFinal;
        cra = (numeradorCorrenteCra + novaParcela) / this.creditosAcumulados;
    }
}
