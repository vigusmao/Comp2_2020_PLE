public class Principal {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Banco Teste!");

        long x = 567;
        System.out.println("x = " + x);

        int y = (int) x;
        System.out.println("y = " + y);

        x = Integer.MAX_VALUE;
        System.out.println("x = " + x);

        x *= 100;
        System.out.println("x = " + x);

        y = (int) x;
        System.out.println("y = " + y);
    }
}
