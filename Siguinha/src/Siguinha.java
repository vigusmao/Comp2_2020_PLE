public class Siguinha {

    public static void main(String[] args) {

        int x = 7;
        System.out.println(x);

        Aluno meuAluno;
        meuAluno = new Aluno(1234567, "Beltrano");
        System.out.println(meuAluno);

        meuAluno.setNome("Fulano de Tal");
        System.out.println(meuAluno);

        System.out.println("Creditos = " + meuAluno.getCreditosAcumulados() +
                        ", CRA = " + meuAluno.getCra());

        meuAluno.registrarConclusaoDisciplina("MAB123", 4, 6.5f);

        System.out.println("Creditos = " + meuAluno.getCreditosAcumulados() +
                ", CRA = " + meuAluno.getCra());

        meuAluno.registrarConclusaoDisciplina("MAB333", 6, 8);

        System.out.println("Creditos = " + meuAluno.getCreditosAcumulados() +
                ", CRA = " + meuAluno.getCra());
    }
}
