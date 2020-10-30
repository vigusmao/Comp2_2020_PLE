import java.util.HashMap;
import java.util.Map;

public enum Dinheiro {

    MOEDA_DE_CINCO_CENTAVOS(0.05f),
    MOEDA_DE_DEZ_CENTAVOS(0.10f),
    MOEDA_DE_VINTE_E_CINCO_CENTAVOS(0.25f),
    MOEDA_DE_CINQUENTA_CENTAVOS(0.50f),
    MOEDA_DE_UM_REAL(1),
    NOTA_DE_DOIS_REAIS(2),
    NOTA_DE_CINCO_REAIS(5),
    NOTA_DE_DEZ_REAIS(10),
    NOTA_DE_VINTE_REAIS(20),
    NOTA_DE_CINQUENTA_REAIS(50),
    NOTA_DE_CEM_REAIS(100),
    NOTA_DE_DUZENTOS_REAIS(200);

    static Map<Float, Dinheiro> dinheiroByValorMonetario = new HashMap<>();

    static {  // é chamado uma única vez durante a inicialização da classe
        for (Dinheiro dinheiro : Dinheiro.values()) {
            dinheiroByValorMonetario.put(dinheiro.getValorMonetario(), dinheiro);
        }
    }

    private float valorMonetario;

    Dinheiro(float valor) {
        this.valorMonetario = valor;
    }

    public float getValorMonetario() {
        return valorMonetario;
    }

    public static Dinheiro getDinheiroByValorMonetario(float valorMonetario) {
        return dinheiroByValorMonetario.get(valorMonetario);
    }
}
