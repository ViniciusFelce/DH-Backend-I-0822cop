package br.com.dh.clinica.repositories;

import br.com.dh.clinica.entities.Dentista;
import br.com.dh.clinica.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class DentistaRepositoryTests {

    @Autowired
    private DentistaRepository repository;

    private Integer idExistente;
    private Integer idNaoExistente;
    private Integer countTotalDentistas;
    private List<Dentista> dentistaList;

    @BeforeEach
    void setup() throws Exception {
        idExistente = 1;
        idNaoExistente = 99;
        countTotalDentistas = 3;
        dentistaList = new ArrayList<>();
    }

    @Test
    public void saveDeveriaSalvarComAutoincrementoQuandoOIdForNulo() {
        Dentista dentista = Factory.criarDentista(); // Simular um DTO
        dentista = repository.save(dentista);

        Assertions.assertNotNull(dentista.getId()); // Aqui o id vale 4
        Assertions.assertEquals(countTotalDentistas + 1, dentista.getId());
    }

    // Na camada de Repository não faz sentido testar o update

    @Test
    public void deleteDeveriaExcluirOObjetoQuandoOIdExistir() {
        // Deletando o ID 1
        repository.deleteById(idExistente);
        // Pesquisando se o ID 1 existe
        Optional<Dentista> resultado = repository.findById(idExistente);
        // Testa se o resultado é um Optional vazio
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void deleteDeveriaLancarExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            // Deletando o ID 99 que não existe
            repository.deleteById(idNaoExistente);
        });
    }

    @Test
    public void findAllDeveriaRetornarumaLista() {
        List<Dentista> resultado = repository.findAll();

        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdERetornarUmDentista() {
        Optional<Dentista> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent()); // Retorna um boolean
    }

    @Test
    public void procurarPorIdERetornarUmOptionalVazio() {
        Optional<Dentista> resultado = repository.findById(idNaoExistente);

        Assertions.assertTrue(resultado.isEmpty()); // Retorna um boolean
    }
}
