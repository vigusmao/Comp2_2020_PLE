import java.util.List;

/**
 * Encontra a interseção de duas listas da maneira ingênua:
 * para cada elemento da primeira lista, percorre a segunda lista inteira
 * vendo se ele lá se encontra.
 */
public class CalculadorIntersecaoIngenuo extends CalculadorIntersecao<Integer> {

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {

        int cont = 0;

        for (Integer elemento : lista1) {
            if (lista2.contains(elemento)) {  // busca exaustiva
                cont++;
            }
        }

        return cont;
    }
}
