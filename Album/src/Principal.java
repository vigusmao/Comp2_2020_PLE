import java.util.ArrayList;
import java.util.Random;

public class Principal {

    // mainzinho apenas para ilustrar a diferença entre array e ArrayList
    public static void main(String[] args) {

        String[] stringArray = new String[10];
        System.out.println(stringArray.length);


        ArrayList<String> stringList = new ArrayList<>();

        
        // para que eu possa, caso queira, acessar posições da ArrayList antes mesmo de colocar coisas nela,
        // eu preciso "inicializá-la", ou seja, preciso adicionar nulls (ou o que quer que faça sentido)
        for (int i = 1; i <= 10; i++) {
            stringList.add(null);
        }
        System.out.println(stringList.size());  // tamanho lógico (quantos objetos eu já coloquei lá)

        stringArray[3] = "String da posição 3";

        stringList.set(3, "String da posição 3");

        System.out.println("stringArray[3] = " + stringArray[3]);
        System.out.println("stringList.get(3) = " + stringList.get(3));
    }
}
