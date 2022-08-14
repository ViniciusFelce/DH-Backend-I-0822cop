package br.com.dh.aula01.entities;

public class Quadrado implements Figura {

    private int lado;

    public Quadrado() {
    }

    public Quadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * this.lado;
    }
}
