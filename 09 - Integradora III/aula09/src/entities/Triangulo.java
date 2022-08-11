package entities;

public class Triangulo {

    private String cor;
    private int tamanho;

    public Triangulo(String cor) {
        this.cor = cor;
        this.tamanho = 5;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Triangulo { " +
                "cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }
}
