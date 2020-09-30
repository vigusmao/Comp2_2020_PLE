package testes;

import entidades.Aluno;

public class AlunoParaTestes extends Aluno {

    public AlunoParaTestes(long dre, int anoDeMatricula, String nome) {
        super(dre, anoDeMatricula, nome);
    }

    public String retornarHistoricoAsString() {
        return super.retornarHistoricoAsString();
    }
}
