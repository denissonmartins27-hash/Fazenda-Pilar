public class Funcionario {

    private String nome;
    private String matricula;
    private String tipoContrato;

    public Funcionario(String nome, String matricula, String tipoContrato) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipoContrato = tipoContrato;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    @Override
    public String toString() {
        return nome + ";" + matricula + ";" + tipoContrato;
    }
}