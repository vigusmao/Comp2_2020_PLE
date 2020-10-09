import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteCalculadorIntersecao {

    private static final int MAXIMO = 120_000;

    private List<Integer> lista1;
    private List<Integer> lista2;

    @Before
    public void setup() {
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();
    }

    @Test
    public void testarCalculadorIngenuo() {
        rodarTeste(new CalculadorIntersecaoIngenuo());
    }

    @Test
    public void testarCalculadorViaBuscaBinaria() {
        rodarTeste(new CalculadorIntersecaoViaBuscaBinaria());
    }

    @Test
    public void testarCalculadorEsperto() {
        rodarTeste(new CalculadorIntersecaoEsperto());
    }

    private void rodarTeste(CalculadorIntersecao<Integer> calculador) {
        System.out.println("Rodando teste para " + calculador.getClass());

        // criando uma lista de múltiplos de 3
        for (int i = 1; i <= MAXIMO; i += 3) {
            lista1.add(i);
        }

        // criando uma lista de múltiplos de 5
        for (int i = 1; i <= MAXIMO; i += 5) {
            lista2.add(i);
        }

        long inicio = System.currentTimeMillis();

        int tamanhoIntersecao = calculador.getQuantidadeElementosEmComum(
                lista1, lista2);

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println(String.format("duracao = %.3f segundos", (duracao / 1000f)));

        assertEquals(MAXIMO / 15, tamanhoIntersecao);
    }

}
