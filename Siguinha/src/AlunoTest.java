import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void getDreTest() {
       Aluno aluno = new Aluno(12345, "Aluno Teste");
       assertEquals(12345, aluno.getDre());
    }

    @Ignore
    @Test
    public void getCraTest() {

    }

    @Test
    public void getConclusaoDiscipinaTest() {
        Aluno aluno = new Aluno(12345, "Aluno Teste");

        String[] resultadoObtido = aluno.getDisciplinasCursadas();
        assertNotNull(resultadoObtido);
        for (int i = 0; i < resultadoObtido.length; i++) {
            assertNull(resultadoObtido[i]);
        }
        assertEquals(0, aluno.getQuantDisciplinasCursadas());

        // o aluno vai cursar a primeira disciplina
        aluno.registrarConclusaoDisciplina("MAB001", 4, 6.5f);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", resultadoObtido[0]);
        assertEquals(1, aluno.getQuantDisciplinasCursadas());
        assertEquals(6.5f, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        // ou...
        //assertTrue(aluno.getCra() == 6.5f);
        assertEquals(4, aluno.getCreditosAcumulados());

        // o aluno vai cursar a segunda disciplina
        aluno.registrarConclusaoDisciplina("MAB002", 6, 8);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", resultadoObtido[0]);
        assertEquals("MAB002", resultadoObtido[1]);
        assertEquals(2, aluno.getQuantDisciplinasCursadas());
        assertEquals(7.4f, aluno.getCra(), 0);  // o terceiro parâmetro é a maior diferença aceitável
        // ou...
        //assertTrue(aluno.getCra() == 6.5f);
        assertEquals(10, aluno.getCreditosAcumulados());


        // o aluno vai cursar a terceira disciplina
        aluno.registrarConclusaoDisciplina("MAJ003", 6, 10);

        resultadoObtido = aluno.getDisciplinasCursadas();
        assertEquals("MAB001", resultadoObtido[0]);
        assertEquals("MAB002", resultadoObtido[1]);
        assertEquals("MAJ003", resultadoObtido[2]);
        assertEquals(3, aluno.getQuantDisciplinasCursadas());
    }

}