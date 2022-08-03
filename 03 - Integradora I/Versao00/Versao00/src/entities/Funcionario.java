package entities;

import java.util.ArrayList;

public class Funcionario extends Vendedor {

    private int anosAntiguidade;
    private ArrayList<Vendedor> afiliados = new ArrayList<>();

    // Construtor
    public Funcionario(String nome, int anosAntiguidade) {
        super.nome = nome;
        super.pontosPorVenda = 5;
        this.anosAntiguidade = anosAntiguidade;
    }

    // Agrega um afiliado ao funcionário, e por sua vez soma pontos.
    public void addAfiliado(Vendedor afiliado) {
        this.afiliados.add(afiliado);
        System.out.println(afiliado.nome + " agora é afiliado de " + super.nome);
    }

    // Implementação do método abstrato de Vendedor
    // Por cada ano de antiguidade obtem-se 5 pontos, por cada afiliado também 10 pontos
    @Override
    public int calcularPontos() {
        return (this.afiliados.size() * 10) + (this.anosAntiguidade * 5);
    }
}
