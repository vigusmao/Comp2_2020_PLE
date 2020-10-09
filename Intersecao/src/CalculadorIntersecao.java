import java.util.List;

public abstract class CalculadorIntersecao<T extends Comparable> {

    public abstract int getQuantidadeElementosEmComum(List<T> lista1, List<T> lista2);
}
