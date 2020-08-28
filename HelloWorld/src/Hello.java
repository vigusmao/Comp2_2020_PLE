import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {

        Scanner meuScanner = new Scanner(System.in);

        System.out.println("Digite seu nome, por favor: ");
        String nome = meuScanner.nextLine();

        System.out.println("Oi, " + nome + "!");

        int numero;
        numero = meuScanner.nextInt();

        String stringFormatada = String.format("Obrigado pelo numero %d, %s!", numero, nome);
        System.out.println(stringFormatada);
        // equivalentemente...
        // System.out.printf("Obrigado pelo numero %d, %s!\n", numero, nome);

    }
}
