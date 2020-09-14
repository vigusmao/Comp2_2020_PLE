public class MatematicaBasica {  // poderia se chamar, por exemplo, MathUtils

    public static int calcularMdc(int x, int y) {
        if (x < y) {
            // swap
            int aux = x;
            x = y;
            y = aux;
        }

        // vou rodar o algoritmo de Euclides para M.D.C., já sabendo que x >= y
        int resto = x % y;
        while (resto != 0) {
            x = y;
            y = resto;
            resto = x % y;
        }
        return y;
    }
}
