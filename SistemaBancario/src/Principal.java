public class Principal {

    public static void main(String[] args) {

        Correntista correntista1 = new Correntista("Carla da Costa", 11111);
        Correntista correntista2 = new Correntista("João da Silva", 11111);
        Agencia agencia = new Agencia();

        Conta conta1 = new Conta(1234, agencia, correntista1);
        Conta conta1Replica = new Conta(1234, agencia, correntista1);

        Conta conta2 = new Conta(2222, agencia, correntista2);

        System.out.println(conta1 == conta2);
        System.out.println(conta1 == conta1);

        System.out.println("conta1 == conta1Replica ? " + (conta1 == conta1Replica));
        System.out.println("conta1.equals(conta1Replica) ? " + conta1.equals(conta1Replica));

        String x = new String("1abcd2");
        String y = new String("1abcd2");

        System.out.println(x == y);
        System.out.println(x.equals(y));

        Conta conta3 = conta1;
        System.out.println("conta3 == conta1 ? " + (conta3 == conta1));
    }
}
