public class RegistroColheita {

    private String data;
    private String matriculaFuncionario;
    private String codigoTalhao;
    private String placaTrator;
    private double litros;
    private String destino;

    public RegistroColheita(String data,
                            String matriculaFuncionario,
                            String codigoTalhao,
                            String placaTrator,
                            double litros,
                            String destino) {

        this.data = data;
        this.matriculaFuncionario = matriculaFuncionario;
        this.codigoTalhao = codigoTalhao;
        this.placaTrator = placaTrator;
        this.litros = litros;
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public String getCodigoTalhao() {
        return codigoTalhao;
    }

    public String getPlacaTrator() {
        return placaTrator;
    }

    public double getLitros() {
        return litros;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return data + ";" +
               matriculaFuncionario + ";" +
               codigoTalhao + ";" +
               placaTrator + ";" +
               litros + ";" +
               destino;
    }
}