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
        int pontosDoVendedor = calcularPontos();
        return this.nome + " têm um total de "
                + pontosDoVendedor + " pontos e está na categoria "
                + getNomeDaCategoria(pontosDoVendedor);
    }

    // Recebe os pontos, e devolve a categoria do vendedor
    private String getNomeDaCategoria(int pontos) {
        if (pontos < 20) {
            return "Vendedor novato!";
        } else if (pontos < 31) {
            return "Vendedor aprendiz!";
        } else if (pontos < 41) {
            return "Vendedor bom!";
        } else {
            return "Vendedor mestre!";
        }
    }
}
