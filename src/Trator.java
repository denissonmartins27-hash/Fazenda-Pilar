public class Trator {

    private String placa;
    private double capacidadeMaxima;

    public Trator(String placa, double capacidadeMaxima) {
        this.placa = placa;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    @Override
    public String toString() {
        return placa + ";" + capacidadeMaxima;
    }
    
}