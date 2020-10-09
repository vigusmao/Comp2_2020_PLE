import java.util.Collections;
import java.util.List;

public class CalculadorIntersecaoViaBuscaBinaria extends CalculadorIntersecao<Integer> {

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {
        // ordena a segunda lista
        Collections.sort(lista2);

        int cont = 0;

        // procura cada elemento da primeira lista na segunda lista via busca binária
        for (Integer elemento : lista1) {
            if (Collections.binarySearch(lista2, elemento) >= 0) {
                cont++;
            }
        }

        return cont;
    }
}
