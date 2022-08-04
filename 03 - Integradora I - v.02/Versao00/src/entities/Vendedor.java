package entities;

public abstract class Vendedor {

    protected String nome;
    protected int vendas = 0;
    protected int pontosPorVenda;
    protected String tipo;

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

        if (tipo.equalsIgnoreCase("Estagiário")) {

            if (pontos < 50) {
                return "Estagiário(a) novato(a)!";
            } else {
                return "Estagiário(a) experiente!";
            }

        } else {

            if (pontos < 20) {
                return "Vendedor(a) novato(a)!";
            } else if (pontos < 31) {
                return "Vendedor(a) aprendiz!";
            } else if (pontos < 41) {
                return "Vendedor(a) bom(a)!";
            } else {
                return "Vendedor(a) mestre!";
            }
        }
    }
}
