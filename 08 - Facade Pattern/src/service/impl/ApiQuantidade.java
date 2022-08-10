package service.impl;

public class ApiQuantidade {

    public int desconto(int quantidade) {

        // Compara a quantidade da parâmetro com 12
        if (quantidade > 12) {
            return 15;
        } else {
            return 0;
        }
    }

}
