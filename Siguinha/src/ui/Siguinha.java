package ui;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Siguinha {

    public final static float MEDIA_MINIMA_PARA_APROVACAO = 5.0f;

    public static char getSeparadorDecimal() {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        return symbols.getDecimalSeparator();
    }

    public static void main(String[] args) {

        System.out.println("Bem-vindo(a) ao SIGUINHA!");

        // aqui começa a execução e a interface com o usuário
    }
}
