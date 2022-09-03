package br.com.dh.clinica.repositories;

import br.com.dh.clinica.entities.Dentista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class DentistaRepositoryTests {

    @Autowired
    private DentistaRepository repository;

    private Integer idExistente;
    private Integer idNaoExistente;

    @BeforeEach
    void setup() throws Exception {
        idExistente = 1;
        idNaoExistente = 99;
    }

    @Test
    public void procurarPorIdERetornarUmDentista() {
        Optional<Dentista> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdERetornarUmOptionalVazio() {
        Optional<Dentista> resultado = repository.findById(idNaoExistente);
        Assertions.assertTrue(resultado.isEmpty());
    }

}
