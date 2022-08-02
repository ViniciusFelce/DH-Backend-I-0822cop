package entities;

public class Contratado extends Funcionario {

    private double valorHora;
    private int horas;

    public Contratado() {
    }

    public Contratado(String nome, String sobrenome, String numconta, double valorHora, int horas) {
        super(nome, sobrenome, numconta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularSaldo() {
        return valorHora * horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Gerado um recibo - Func. CONTRATADO/PJ.");
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Foi depositado uma quantia de " + quantia);
    }
}
