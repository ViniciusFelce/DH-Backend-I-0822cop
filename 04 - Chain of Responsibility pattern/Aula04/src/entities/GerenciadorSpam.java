package entities;

public class GerenciadorSpam extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        System.out.println("Cuidado! SPAM!!! E-mail enviado para a Lixeira");
    }
}
