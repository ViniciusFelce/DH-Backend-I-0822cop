package entities;

public class Estagiario extends Vendedor {

    public Estagiario(String nome) {
        super.nome = nome;
        super.pontosPorVenda = 5;
        super.tipo = "Estagiário";
    }

    @Override
    public int calcularPontos() {
        return this.vendas * pontosPorVenda;
    }
}
