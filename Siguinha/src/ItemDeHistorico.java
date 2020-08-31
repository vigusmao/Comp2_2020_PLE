import java.util.Calendar;

public class ItemDeHistorico {

    private Disciplina disciplina;

    private int ano;

    private int semestre;

    private float mediaFinal;

    private Aluno aluno;

    public ItemDeHistorico(Disciplina disciplina, Aluno aluno,
                           int ano, int semestre, float mediaFinal) {
        this.disciplina = disciplina;
        this.aluno = aluno;
        setAno(ano);
        this.semestre = semestre;
        this.mediaFinal = mediaFinal;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        if (ano < aluno.getAnoDeMatricula() || ano > anoCorrente) {
            // lançar uma exceção
            return;  // sem setar o ano
        }
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre < 1 || semestre > 2) {
            // lançar uma exceção
            return;  // sem setar
        }
        this.semestre = semestre;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public boolean obteveAprovacao() {
        return this.mediaFinal >= Siguinha.MEDIA_MINIMA_PARA_APROVACAO;
    }
}
