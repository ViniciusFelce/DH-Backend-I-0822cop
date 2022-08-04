package entities;

public abstract class Funcionario {
    private String nome;
    private String sobrenome;
    private String numConta;

    public Funcionario(String nome, String sobrenome, String numConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numConta = numConta;
    }

    public void pagamentoSalario() {
        double quantia;
        quantia = calcularSaldo();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    public abstract double calcularSaldo();

    public abstract void imprimirRecibo(double quantia);

    public abstract void depositar(double quantia);

}