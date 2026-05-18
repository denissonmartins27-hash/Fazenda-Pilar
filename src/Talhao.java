public class Talhao {

    private String codigo;
    private String nome;
    private String variedadeCafe;
    private double estimativaProducao;

    public Talhao(String codigo, String nome,
                  String variedadeCafe,
                  double estimativaProducao) {

        this.codigo = codigo;
        this.nome = nome;
        this.variedadeCafe = variedadeCafe;
        this.estimativaProducao = estimativaProducao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getVariedadeCafe() {
        return variedadeCafe;
    }

    public double getEstimativaProducao() {
        return estimativaProducao;
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" +
               variedadeCafe + ";" + estimativaProducao;
    }
}