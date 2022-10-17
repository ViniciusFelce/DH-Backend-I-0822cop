package br.com.dh.clinica.tests;

// Fábrica para criar entidades dentista e dentistaDto para ser
// usadas nas camadas de testes

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.entities.Dentista;

public class Factory {

    // As camadas de entities e Dtos não precisam ser testadas.
    public static Dentista criarDentista() {
        Dentista dentista = new Dentista(null, "Joana Rabelo", "joanar@gmail.com", 12456, true);
        return dentista;
    }

    public static DentistaDto criarDentistaDto() {
        Dentista dentista = criarDentista();
        return new DentistaDto(dentista);
    }
}
