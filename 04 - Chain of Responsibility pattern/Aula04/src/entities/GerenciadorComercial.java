package entities;

public class GerenciadorComercial extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        if ((email.getDestino().equalsIgnoreCase("comercial@colmeia.com")) || (email.getAssunto().equalsIgnoreCase("Comercial"))) {
            System.out.println("E-mail enviado para o departamento Comercial.");
        } else {
            if (this.getGerenciadorSeguinte() != null) {
                this.getGerenciadorSeguinte().verificar(email);
            }
        } // Fecha o Else
    } // Fecha o Verificar
} // Fecha a classe
