package service.impl;

import entities.Cartao;
import entities.Produto;
import service.IFacadeDesconto;

public class FacadeDesconto implements IFacadeDesconto {

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    public FacadeDesconto() {
        apiCartao = new ApiCartao();
        apiProduto = new ApiProduto();
        apiQuantidade = new ApiQuantidade();
    }

    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0; // Inicializa a variável desconto com zero
        desconto += apiCartao.desconto(cartao); // Testa o getBanco()
        desconto += apiProduto.desconto(produto); // Testa o getTipo()
        desconto += apiQuantidade.desconto(quantidade); // Testa a quantidade
        return desconto; // Retorna a soma dos três.
    }
}
