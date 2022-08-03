package entities;

public abstract class Vendedor {

    protected String nome;
    protected int vendas = 0;
    protected int pontosPorVenda;

    // Métodos
    public void vender(int qtdeVendas) {
        this.vendas = qtdeVendas;
        System.out.println(this.nome + " realizou " + qtdeVendas + " vendas.");
    }

    /* Método que calcula os pontos do Vendedor de acordo com seus aspectos a serem considerados*/
    public abstract int calcularPontos();

    public String mostrarCategoria() {
        return "";
    }
}
