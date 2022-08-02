package entities;

public class Efetivo extends Funcionario {

    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public Efetivo() {
    }

    public Efetivo(String nome, String sobrenome, String numconta, double salarioBase, double descontos, double bonificacoes) {
        super(nome, sobrenome, numconta);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }

    @Override
    public double calcularSaldo() {
        return salarioBase + bonificacoes - descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Gerado um recibo - Func. EFETIVO.");
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Foi depositado uma quantia de " + quantia);
    }
}
