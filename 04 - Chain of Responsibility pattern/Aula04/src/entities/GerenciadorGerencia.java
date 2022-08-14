package entities;

public class GerenciadorGerencia extends Gerenciador {

    @Override
    public void verificar(Mail email) {
        if ((email.getDestino().equalsIgnoreCase("gerencia@colmeia.com")) || (email.getAssunto().equalsIgnoreCase("Gerência"))) {
            System.out.println("E-mail enviado para o departamento Gerencial da empresa.");
        } else {
            if (this.getGerenciadorSeguinte() != null) {
                this.getGerenciadorSeguinte().verificar(email);
            }
        } // Fecha o Else
    } // Fecha o Verificar
} // Fecha a classe
