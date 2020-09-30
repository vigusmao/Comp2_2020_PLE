package historico;

import entidades.Aluno;
import entidades.Disciplina;
import ui.Siguinha;

public class ItemDeHistoricoDisciplinaCursada extends ItemDeHistorico {

    private Disciplina disciplina;

    private float mediaFinal;

    public ItemDeHistoricoDisciplinaCursada(Aluno aluno, int ano, int semestre,
                                            Disciplina disciplina, float mediaFinal) {
        super(aluno, ano, semestre);
        this.disciplina = disciplina;
        this.mediaFinal = mediaFinal;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    @Override
    public String getDescricao() {
        return String.format("%s (%s) - média %.1f - %d créditos",
                this.disciplina.getNome(), this.disciplina.getCodigo(),
                this.mediaFinal, this.disciplina.getCreditos());
    }
}
