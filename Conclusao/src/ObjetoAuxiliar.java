import java.util.Scanner;

public class ObjetoAuxiliar {

    public int facaAlgoImportanteParaAMinhaTarefa()
            throws ExcecaoEspecifica, OutraExcecaoQualquer, MinhaExcecao {
        // aqui dentro pode ocorrer uma situação qualquer que faça ESTE método
        // lançar (via throw) uma ExcecaoEspecifica

        boolean condicaoQualquer = false;  // por exemplo, depende um acesso a banco de dados
        boolean outraCondicao = false;  // por exemplo, depende de um acesso a sistema externo

        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();

        boolean terceiraCondicao = texto.length() > 10;

        if (condicaoQualquer) {
            // lança uma exceção (que está sendo criada neste momento)
            throw new ExcecaoEspecifica();
        } else if (outraCondicao) {
            throw new OutraExcecaoQualquer();
        }

        // sdfsdfdssfdfsd
        // terminou lindamente

        return 10000;   // o valor de retorna, na prática, poderia depender de algo externo,
                        // de algo muito lento, ou que não temos acesso em tempo de testes
    }
}
