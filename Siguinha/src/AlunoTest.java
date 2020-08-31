import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void getDreTest() {
       Aluno aluno = new Aluno(12345, 2018, "Aluno Teste");
       assertEquals(12345, aluno.getDre());
    }

    @Ignore
    @Test
    public void getCraTest() {

    }

    @Test
    public void getConclusaoDiscipinaTest() {
        Aluno aluno = new Aluno(12345, 2018, "Aluno Teste");

        ItemDeHistorico[] resultadoObtido = aluno.getDisciplinasCursadas();
        assertNotNull(resultadoObtido);
        for (int i = 0; i < resultadoObtido.length; i++) {
            assertNull(resultadoObtido[i]);
        }
        assertEquals(0, aluno.getQuantDisciplinasCursadas());

        // o aluno vai cursar a primeira disciplina
        Disciplina disciplina1 = new Disciplina("MAB001", "Disciplina 1");
        disciplina1.setCreditos(4);
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);

        resultadoObtido = aluno.getDisciplinasCursadas();
        ItemDeHistorico primeiroItem = resultadoObtido[0];
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals(2019, primeiroItem.getAno());
        assertEquals(2, primeiroItem.getSemestre());
        assertEquals(1, aluno.getQuantDisciplinasCursadas());
        assertEquals(6.5f, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        // ou...
        //assertTrue(aluno.getCra() == 6.5f);
        assertEquals(4, aluno.getCreditosAcumulados());

        // o aluno vai cursar a segunda disciplina
        Disciplina disciplina2 = new Disciplina("MAB002", "Disciplina 2");
        disciplina2.setCreditos(6);
        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        ItemDeHistorico segundoItem = resultadoObtido[1];
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        assertEquals(2, aluno.getQuantDisciplinasCursadas());
        assertEquals(7.4f, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        // ou...
        //assertTrue(aluno.getCra() == 6.5f);
        assertEquals(10, aluno.getCreditosAcumulados());

        // o aluno vai cursar a terceira disciplina
        Disciplina disciplina3 = new Disciplina("MAJ003", "Disciplina 3");
        disciplina3.setCreditos(6);
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 1);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", primeiroItem.getDisciplina().getCodigo());
        assertEquals("MAB002", segundoItem.getDisciplina().getCodigo());
        ItemDeHistorico terceiroItem = resultadoObtido[2];
        assertEquals("MAJ003", terceiroItem.getDisciplina().getCodigo());
        assertEquals(3, aluno.getQuantDisciplinasCursadas());
        assertEquals(16, aluno.getCreditosAcumulados());
    }

    @Test
    public void retornarHistoricoTest() {
        Aluno aluno = new Aluno(12345, 2018, "Aluno Teste");

        Disciplina disciplina1 = new Disciplina("MAB001", "Disciplina 1");
        disciplina1.setCreditos(4);
        aluno.registrarConclusaoDisciplina(disciplina1, 6.5f, 2019, 2);

        Disciplina disciplina2 = new Disciplina("MAB002", "Disciplina 2");
        disciplina2.setCreditos(6);
        aluno.registrarConclusaoDisciplina(disciplina2, 8, 2020, 1);

        Disciplina disciplina3 = new Disciplina("MAB003", "Disciplina 3");
        disciplina3.setCreditos(6);
        aluno.registrarConclusaoDisciplina(disciplina3, 10, 2020, 2);

        String historicoRetornado = aluno.retornarHistoricoAsString();
        String historicoEsperado =
                "MAB001 - média 6.5 - 4 créditos - 2019.2\n" +
                "MAB002 - média 8.0 - 6 créditos - 2020.1\n" +
                "MAB003 - média 10.0 - 6 créditos - 2020.2";
        assertEquals(historicoEsperado, historicoRetornado);
    }

}