import java.util.Random;

public class Principal {

    // mainzinho apenas para ilustrar o uso do Random
    public static void main(String[] args) {

        Random random = new Random();
        int[] numeros = new int[20];

        for (int i = 0; i < 20; i++) {
            numeros[i] = random.nextInt();
        }

        for (int x : numeros) {  // ilustrando um "for each"
            System.out.println(x);
        }
    }
}
