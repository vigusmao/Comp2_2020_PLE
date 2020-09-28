public class EmailEnviado extends Email {


    /**
     * Anexa um arquivo ao e-mail
     * @param arquivo O arquivo desejado (max 1 MB)
     * @return true, se arquivo foi anexado com sucesso; falso, caso contrário
     */
    public boolean anexarArquivo(Arquivo arquivo) {

        int tamanho = arquivo.getTamanhoEmBytes();
        if (tamanho > Math.pow(2, 20)) {  // 1MB
            return false;
        }

        System.out.println(String.format(
                "Anexando arquivo no email... (%d bytes)", tamanho));

        this.arquivoEmAnexo = arquivo;
        return true;
    }

}
