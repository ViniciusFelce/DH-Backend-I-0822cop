import entities.Cartao;
import entities.Produto;
import service.impl.FacadeDesconto;

public class Programa {

    public static void main(String[] args) {

        // Instanciar o facade e as 3 APIs
        FacadeDesconto facadeDesconto = new FacadeDesconto();

        // Instanciar o cartão e o produto
        Cartao cartao = new Cartao("123456", "Star Bank");
        Produto produto = new Produto("Lasanha", "Lata");

        // Executar o facadeDesconto
        int descontoTotal = facadeDesconto.desconto(cartao, produto, 20);
        System.out.println("Desconto concedido: " + descontoTotal + "%.");

    }

}
