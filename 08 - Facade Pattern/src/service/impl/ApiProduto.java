package service.impl;

import entities.Produto;

public class ApiProduto {

    public int desconto(Produto produto) {

        // Aqui se recebe o tipo do produto e se guarda a String dentro da variável prod
        String prod = produto.getTipo();
        // Compara o prod da linha 10 com a String em verde
        if (prod.compareTo("Lata") == 0) {
            return 10;
        } else {
            return 0;
        }
    }
}
