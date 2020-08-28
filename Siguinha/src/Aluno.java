public class Aluno {

    // atributos (regra geral: todos private)

    private String nome;
    private final long dre;
    private int creditosAcumulados;  //       Somatorio_d [creditos(d)]

    private float cra;               // cra = Somatorio_d [media(d) * creditos(d) /
    //       creditosAcumulados

    private int quantDisciplinasCursadas;
    private String[] disciplinasCursadas;

    // construtor
    public Aluno(long dre, String nome) {
        this.dre = dre;
        this.nome = nome;
        this.disciplinasCursadas = new String[16];
    }

    // métodos

    void imprimirHistorico() {

    }

    public String[] getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public int getQuantDisciplinasCursadas() {
        return quantDisciplinasCursadas;
    }

    public String getNome() {
        return nome == null ? "Sem Nome" : nome;

        // equivalentemente...
//        if (nome == null) {
//            return "Sem Nome";
//        }
//        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 30) {
            // ToDo: lançar uma exceção
            return;
        }

        this.nome = nome;
    }  // setter

    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public long getDre() {
        return dre;
    }

    public float getCra() {   // accessor method (getters and setters)
        return cra;
    }    // getter

    /* NÃO QUEREMOS UM SETTER COMO ESTE ABAIXO!!!!!
       PORQUE NÃO FAZ SENTIDO PERMITIR ESCREVER DIRETAMENTE NO CRA DO ALUNO,
       UMA VEZ QUE SE TRATA DE UM CAMPO QUE DEVE SER CALCULADO EM FUNÇÃO DE OUTROS */

//    public void setCra(float cra) {
//        if (cra < 0 || cra > 10) {
//            // ToDo: lançar uma exceção
//            return;
//        }
//        this.cra = cra;
//    }

    public void registrarConclusaoDisciplina(String codigoDisciplina,
                                             int quantCreditos,
                                             float mediaFinal) {

        this.disciplinasCursadas[this.quantDisciplinasCursadas] = codigoDisciplina;
        this.quantDisciplinasCursadas++;  // incrementa a quant já cursada

        // recupero o numerador corrente (antes da nova disciplina)
        float numeradorCorrenteCra = this.cra * this.creditosAcumulados;

        this.creditosAcumulados += quantCreditos;

        // atualizar o CRA do aluno
        float novaParcela = quantCreditos * mediaFinal;
        this.cra = (numeradorCorrenteCra + novaParcela) / this.creditosAcumulados;
    }



    @Override
    public String toString() {
        return String.format("%s (DRE: %d)", this.nome, this.dre);
    }
}
