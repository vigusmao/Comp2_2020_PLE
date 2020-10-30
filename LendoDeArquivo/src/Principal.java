import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

    private static final int NOTA_MINIMA_APROVACAO = 5;

    public static ResultadosTurma calcularMedia(String pathDoArquivo)
            throws FileNotFoundException, ArquivoCorrompidoException {

        File arquivo = new File(pathDoArquivo);

        int quantLinhasValidas = 0;
        int quantLinhasInvalidas = 0;
        float numerador = 0;
        float maiorNotaAteAqui = Float.MIN_VALUE;

        Scanner scanner = new Scanner(arquivo);

        ResultadosTurma resultados = new ResultadosTurma();

        while (scanner.hasNext()) {

            try {
                String linha = scanner.nextLine();

                String[] dreENota = linha.split(" ");
                long dre = Long.parseLong(dreENota[0]);
                float nota = Float.parseFloat(dreENota[1].replace(',', '.'));

                // Scanner.nextFloat() funciona com o separador decimal
                // definido pelo sistema operacional

//                float nota = Float.parseFloat(scanner.nextLine());
//      ou....    float nota = Float.valueOf(scanner.nextLine());
                // parseFloat() e valueOf() só funcionam com ponto
                // (representação interna do Java)


                quantLinhasValidas++;
                numerador += nota;

                if (nota >= NOTA_MINIMA_APROVACAO) {
                    resultados.quantAlunosAprovados++;
                } else {
                    resultados.quantAlunosReprovados++;
                }

                if (nota > maiorNotaAteAqui) {
                    maiorNotaAteAqui = nota;
                    resultados.dreDoAlunoDeMaiorMedia = dre;
                }

            } catch (Exception e) {
                quantLinhasInvalidas++;
            }
        }

        if (quantLinhasInvalidas > quantLinhasValidas) {
            throw new ArquivoCorrompidoException(quantLinhasInvalidas);
        }

        if (quantLinhasValidas == 0) {
            throw new ArquivoCorrompidoException(0);
        }

        resultados.mediaDaTurma = numerador / quantLinhasValidas;

        return resultados;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean finalizado = false;

        while (!finalizado) {
            System.out.printf("\nDigite o nome do arquivo: ");
            String nomeArquivo = scanner.nextLine();

            try {
                ResultadosTurma resultados = calcularMedia(nomeArquivo);
                System.out.println(resultados);
                finalizado = true;

            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!\n");

            } catch (ArquivoCorrompidoException e) {
                System.out.printf("\nArquivo corrompido com %d linhas inválidas.",
                        e.getQuantLinhasInvalidas());
                finalizado = true;
            }
        }
    }
}
