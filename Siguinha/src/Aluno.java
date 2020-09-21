import java.util.ArrayList;
import java.util.Calendar;

public class Aluno {

    // atributos (regra geral: todos private)

    private String nome;
    private final long dre;
    private final int anoDeMatricula;
    private int creditosAcumulados;  //       Somatorio_d [creditos(d)]

    private float cra;               // cra = Somatorio_d [media(d) * creditos(d) /

    private ArrayList<ItemDeHistorico> disciplinasCursadas;

    // construtor
    public Aluno(long dre, int anoDeMatricula, String nome) {
        this.dre = dre;
        this.anoDeMatricula = anoDeMatricula;
        this.nome = nome;
        this.disciplinasCursadas = new ArrayList<>();
    }

    // métodos

    String retornarHistoricoAsString() {
       String resultado = "";

       for (int i = 0; i < this.disciplinasCursadas.size(); i++) {
           ItemDeHistorico item = this.disciplinasCursadas.get(i);
           // MAB001 - média 6.5 - 4 créditos - 2020.1
           resultado = resultado + item.getDisciplina().getCodigo() +
                   " - média " + item.getMediaFinal() +
                   " - " + item.getDisciplina().getCreditos() + " créditos" +
                   " - " + item.getAno() + "." + item.getSemestre();
           if (i < this.disciplinasCursadas.size() - 1) {
               resultado = resultado + "\n";
           }
       }
       return resultado;
    }

    public ArrayList<ItemDeHistorico> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public int getQuantDisciplinasCursadas() {
        return this.disciplinasCursadas.size();
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

    public int getAnoDeMatricula() {
        return anoDeMatricula;
    }

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

    public void registrarConclusaoDisciplina(Disciplina disciplina,
                                             float mediaFinal,
                                             int anoConclusao,
                                             int semestreConclusao) {

        ItemDeHistorico novoItem = new ItemDeHistorico(
                disciplina, this, anoConclusao, semestreConclusao, mediaFinal);

        this.disciplinasCursadas.add(novoItem);

        // recupero o numerador corrente (antes da nova disciplina)
        float numeradorCorrenteCra = this.cra * this.creditosAcumulados;

        int creditos = disciplina.getCreditos();
        this.creditosAcumulados += creditos;

        // atualizar o CRA do aluno
        float novaParcela = creditos * mediaFinal;
        this.cra = (numeradorCorrenteCra + novaParcela) / this.creditosAcumulados;
    }

    // Overload (ou "sobrecarga")
    public void registrarConclusaoDisciplina(Disciplina disciplina,
                                             float mediaFinal) {

        int ano = Calendar.getInstance().get(Calendar.YEAR);  // pega o ano corrente
        int mes = Calendar.getInstance().get(Calendar.MONTH); // pega o mês corrente
        int semestre = mes <= 6 ? 1 : 2;  // computa o semestre corrente baseado no mês

        // passa ano e semestre correntes para a versão "principal" deste método
        registrarConclusaoDisciplina(disciplina, mediaFinal, ano, semestre);
    }

    @Override
    public String toString() {
        return String.format("%s (DRE: %d)", this.nome, this.dre);
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno(111, 2018, "Aluno Teste");
        Disciplina d1 = new Disciplina("D1", "qualquer coisa");
        Disciplina d2 = new Disciplina("D2", "qualquer outra coisa");
        aluno.registrarConclusaoDisciplina(d1, 8, 2019, 1);
        aluno.registrarConclusaoDisciplina(d2, 6.5f);
        System.out.println(aluno.retornarHistoricoAsString());
    }
}
