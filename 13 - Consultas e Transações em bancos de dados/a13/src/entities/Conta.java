package entities;

public class Conta {

    private int id;
    private String nome;
    private String numconta;
    private double saldo;

    public Conta() {
    }

    public Conta(String nome, String numconta, double saldo) {
        this.nome = nome;
        this.numconta = numconta;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumconta() {
        return numconta;
    }

    public void setNumconta(String numconta) {
        this.numconta = numconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
