import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

        /* ATENÇÃO:  Este main() serve apenas para ilustrar o uso do Scanner apontando para
                     um arquivo de entrada. Ele não é o main() que vc precisa escrever
                     para resolver o exercíciodo LAB 8 descrito em LAB8.txt */



//        Scanner scanner = new Scanner(System.in);  para ler do standard in (teclado)


        File arquivo = new File("LAB8.txt");

        Scanner scanner = null;

        try {
            scanner = new Scanner(arquivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
//            try {
//                scanner.nextFloat();
//            } catch (Exception e) {
//
//            }
        }
    }
}
