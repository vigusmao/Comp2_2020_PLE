import java.util.Scanner;

public class Hello {

    // atributos



    // métodos



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome, por favor: ");
        String nome = scanner.nextLine();

        System.out.println("Oi, " + nome + "!");

        int numero;
        numero = scanner.nextInt();
        System.out.println("Obrigado pelo numero " + numero);
    }
}
