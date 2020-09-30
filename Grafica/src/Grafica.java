import java.util.Scanner;

public class Grafica {

    public static void main(String[] args) {

        Impressora minhaImpressora;

        minhaImpressora = criarImpressora();

        minhaImpressora.imprimir("Hello!");
        System.out.println(minhaImpressora.getConsumoPercentualPorCaracter());
    }

    private static Impressora criarImpressora() {
        Impressora impressora;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual tipo (J: jato de tinta | L: laser | M : matricial)");
        String tipo = scanner.nextLine();
        System.out.println("Qual a marca?");
        String marca = scanner.nextLine();
        System.out.println("Qual o modelo?");
        String modelo = scanner.nextLine();

        char c = tipo.toLowerCase().charAt(0);
        switch (c) {
            case 'j':
                System.out.println("Eh colorida? (S|N)");
                String ehColorida = scanner.nextLine();
                impressora = new ImpressoraJatoDeTinta(marca, modelo,
                        ehColorida.toLowerCase().charAt(0) == 's');
                break;

            case 't':
                impressora = new ImpressoraTanqueDeTinta(marca, modelo);
                break;

            case 'm':
                impressora = new ImpressoraMatricial(marca);
                break;

            case 'l': default:
                impressora = new ImpressoraLaser();
                break;
        }

        return impressora;
    }
}
