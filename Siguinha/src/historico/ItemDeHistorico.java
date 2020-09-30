package historico;

import entidades.Aluno;

import java.util.Calendar;

public abstract class ItemDeHistorico {

    private int ano;

    private int semestre;

    private Aluno aluno;

    public ItemDeHistorico(Aluno aluno, int ano, int semestre) {
        this.aluno = aluno;
        setAno(ano);
        this.semestre = semestre;
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

    @Override
    public String toString() {
        return String.format("%d.%d - %s",
                this.ano, this.semestre, getDescricao());
    }

    protected abstract String getDescricao();
}
