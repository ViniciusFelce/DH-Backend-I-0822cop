package service.impl;

import entities.Cartao;

public class ApiCartao {

    public int desconto(Cartao cartao) {

        // Aqui se recebe o nome do banco e se guarda a String dentro da variável banco
        String banco = cartao.getBanco(); // "Star Bank"
        // Compara o banco da linha 10 com a String em verde
        if (banco.compareTo("Star Bank") == 0) {
            return 20;
        } else {
            return 0;
        }
    }

}
