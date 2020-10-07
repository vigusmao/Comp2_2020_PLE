import java.util.*;

public class Principal {

    private static final int TAMANHO = 40_000;

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        brincarComWrapperClasses();

        // TESTE 1
        System.out.println("Criando as coleções...");
        HashSet<Integer> conjunto = new HashSet<>();
        preencherComInteirosAleatorios(conjunto, TAMANHO);
        ArrayList<Integer> lista = new ArrayList<>(conjunto);  // "transformei" o set em list

        System.out.println("Vou começar os testes...");
        executarTesteContagemOcorrencias(lista);
        executarTesteContagemOcorrencias(conjunto);

        // TESTE 2

        HashMap<Integer, Float> craByDre = new HashMap<>();
        preencherComDresECrasAleatorios(craByDre, TAMANHO);

        ArrayList<Aluno> alunos = new ArrayList<>();
        // itera pelo mapa para copiar para o arrayList
        for (Map.Entry<Integer, Float> registro : craByDre.entrySet()) {
            Aluno aluno = new Aluno();
            aluno.dre = registro.getKey();
            aluno.cra = registro.getValue();
            alunos.add(aluno);
        }

//        craByDre.put(111, 6.5f);
//        craByDre.put(222, 7.5f);     // mapa.put("CHAVE", "VALOR")
//        craByDre.put(123, 4.1f);

        System.out.println(craByDre.get(333));  // procura pela chave, recebe o valor

        // MAPA
        long inicio = System.currentTimeMillis();
        int resultado = contarOcorrenciasDeCraBaixos(craByDre, 1, TAMANHO);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.println(resultado);
        System.out.println(String.format("duração (mapa): %.3fs", duracao / 1000f));

        // ARRAY LIST
        inicio = System.currentTimeMillis();
        resultado = contarOcorrenciasDeCraBaixos(alunos, 1, TAMANHO);
        duracao = System.currentTimeMillis() - inicio;
        System.out.println(resultado);
        System.out.println(String.format("duração (lista): %.3fs", duracao / 1000f));
    }

    private static void executarTesteContagemOcorrencias(Collection<Integer> colecao) {
        long inicio = System.currentTimeMillis();
        int resultado = contarOcorrencias(colecao, 1, TAMANHO);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.println(resultado);
        System.out.println(String.format("duração (%s): %.3fs", colecao.getClass(),
                duracao / 1000f));
    }

    private static void preencherComInteirosAleatorios(
            Collection<Integer> colecao, int quantidade) {
        while (colecao.size() < quantidade) {
            colecao.add(RANDOM.nextInt(100 * quantidade));
        }
    }

    private static void preencherComDresECrasAleatorios(
            HashMap<Integer, Float> mapa, int quantidade) {
        while (mapa.size() < quantidade) {
            mapa.put(RANDOM.nextInt(quantidade * 2), 10 * (float) RANDOM.nextDouble());
        }
    }

    private static int contarOcorrencias(Collection<Integer> colecao,
                                         int menor, int maior) {
        int cont = 0;
        for (int i = menor; i <= maior; i++) {
            if (colecao.contains(i)) {
                cont++;
            }
        }
        return cont;
    }

    private static int contarOcorrenciasDeCraBaixos(
            Map<Integer, Float> mapa, int menor, int maior) {
        int cont = 0;
        for (int dre = menor; dre <= maior; dre++) {
            Float cra = mapa.get(dre);
            if (cra != null && cra < 5) {
                cont++;
            }
        }
        return cont;
    }

    private static int contarOcorrenciasDeCraBaixos(
            Collection<Aluno> lista, int menor, int maior) {
        int cont = 0;
        for (int dre = menor; dre <= maior; dre++) {
            // PROCURO O ALUNO COM O DRE DESEJADO NA MINHA LISTA
            for (Aluno aluno : lista) {
                if (aluno.dre == dre) {
                    if (aluno.cra < 5) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }

    private static void brincarComWrapperClasses() {
        // x será um OBJETO contendo um inteiro
        Integer x;  // aqui x vale null
        x = 6;  // "auto-boxing", ou seja, equivale a x = Integer.valueOf(6);

        int y;   // aqui y vale 0
        y = 8;

        int z = y + x;  // "auto-unboxing" no x (de Integer para int)
        // cuidado com o unboxing de null!!!!
        int zz = y + (x == null ? 0 : x);
    }

    private static class Aluno {
        int dre;
        float cra;

    }
}
