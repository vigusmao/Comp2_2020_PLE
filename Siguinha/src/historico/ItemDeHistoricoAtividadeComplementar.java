package historico;

import entidades.Aluno;

public class ItemDeHistoricoAtividadeComplementar extends ItemDeHistorico {

    private char conceito;  // A, B, C, D

    public ItemDeHistoricoAtividadeComplementar(Aluno aluno, int ano, int semestre) {
        super(aluno, ano, semestre);
    }

    public char getConceito() {
        return conceito;
    }

    public void setConceito(char conceito) {
        if (conceito != 'A' && conceito != 'B' && conceito != 'C' && conceito != 'D') {
            // ToDo lançar exceção!!
            return;  // por ora, apenas retorna sem setar o conceito que não faz sentido
        }

        this.conceito = conceito;
    }

    @Override
    public String getDescricao() {
        return String.format("Atividade Complementar com conceito %c", this.conceito);
    }
}
