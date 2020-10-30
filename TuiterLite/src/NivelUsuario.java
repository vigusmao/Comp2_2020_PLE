public enum NivelUsuario {

    INICIANTE(0, 1),
    SENIOR(200, 3),
    NINJA(1000, 5),
    MESTRE_SUPREMO(5000, 40);

    private int minTuites;
    private int pontosPorTuite;

    /**
     * chamado automaticamente para cada valor do enum
     * durante a inicialização do enum
     */
    NivelUsuario(int minTuites, int pontosPorTuite) {
        this.minTuites = minTuites;
        this.pontosPorTuite = pontosPorTuite;
    }

//    public int getMinTuites(NivelUsuario nivel) {
//        return minTuitesByNivel.get(nivel);
//    }

    public int getMinTuites() {
        return this.minTuites;
    }

    public int getPontosPorTuite() {
        return pontosPorTuite;
    }
}
