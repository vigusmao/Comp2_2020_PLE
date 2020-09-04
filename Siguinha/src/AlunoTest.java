import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    private Aluno aluno;
    private Disciplina disciplina1;
    private Disciplina disciplina2;
    private Disciplina disciplina3;

    @Before
    public void setUp() {
        aluno = new Aluno(12345, 2018, "Aluno Teste");

        disciplina1 = new Disciplina("MAB001", "Disciplina 1");
        disciplina1.setCreditos(4);

        disciplina2 = new Disciplina("MAB002", "Disciplina 2");
        disciplina2.setCreditos(6);

        disciplina3 = new Disciplina("MAJ003", "Disciplina 3");
        disciplina3.setCreditos(6);
    }

    @Test
    public void getDreTest() {
       assertEquals(12345, aluno.getDre());
    }

    @Ignore
    @Test
    public void getCraTest() {

    }

    @Test
    public void getConclusaoDiscipinaTest() {
        ItemDeHistorico[] resultadoObtido = aluno.getDisciplinasCursadas();
        assertNotNull(resultadoObtido);
        for (int i = 0; i < resultadoObtido.length; i++) {
            assertNull(resultadoObtido[i]);
        }
        assertEquals(0, aluno.getQuantDisciplinasCursadas());

        // o aluno vai cursar a primeira disciplina
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);

        resultadoObtido = aluno.getDisciplinasCursadas();
        ItemDeHistorico primeiroItem = resultadoObtido[0];
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals(2019, primeiroItem.getAno());
        assertEquals(2, primeiroItem.getSemestre());
        verificarAtualizacaoCreditos(1, 6.5f, 4);

        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);
        // verificar todas as disciplinas do histórico até aqui
        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        ItemDeHistorico segundoItem = resultadoObtido[1];
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(2, 7.4f, 10);

        // o aluno vai cursar a terceira disciplina
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 1);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        ItemDeHistorico terceiroItem = resultadoObtido[2];
        assertEquals("MAJ003", terceiroItem.getDisciplina().getCodigo());
        verificarAtualizacaoCreditos(3, 8.375f, 16);
    }

    @Test
    public void retornarHistoricoTest() {
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);
        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 2);

        String historicoRetornado = aluno.retornarHistoricoAsString();
        String historicoEsperado =
                "MAB001 - média 6.5 - 4 créditos - 2019.2\n" +
                "MAB002 - média 8.0 - 6 créditos - 2020.1\n" +
                "MAJ003 - média 10.0 - 6 créditos - 2020.2";
        assertEquals(historicoEsperado, historicoRetornado);
    }

    private void verificarAtualizacaoCreditos(int quantDiscipinasEsperado,
                                              float craEsperado,
                                              int creditosAcumuladosEsperado) {
        assertEquals(quantDiscipinasEsperado, aluno.getQuantDisciplinasCursadas());
        assertEquals(craEsperado, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        assertEquals(creditosAcumuladosEsperado, aluno.getCreditosAcumulados());
    }

}