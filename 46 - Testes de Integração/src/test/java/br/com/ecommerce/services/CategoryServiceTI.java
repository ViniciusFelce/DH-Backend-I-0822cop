package br.com.ecommerce.services;

import br.com.ecommerce.dtos.CategoryDto;
import br.com.ecommerce.entities.Category;
import br.com.ecommerce.repositories.CategoryRepository;
import br.com.ecommerce.services.exceptions.DatabaseWineException;
import br.com.ecommerce.services.exceptions.EntityWineNotFoundException;
import br.com.ecommerce.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class CategoryServiceTI {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryRepository repository;

    private Integer existingId;
    private Integer nonExistingId;
    private Integer dependentId;
    private CategoryDto categoryDto;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1;
        nonExistingId = 999;
        dependentId = 3;
        categoryDto = Factory.criarCategoriaDto();
    }

    // Teste do método findAll
    @Test
    public void findAllDeveriaTrazerUmaLista() {
        List<CategoryDto> result = service.searchAll();
        Assertions.assertFalse(result.isEmpty());
    }

    // Teste do método findById
    @Test
    public void findByIdDeveriaTrazerUmRegistro() {
        CategoryDto result = service.searchById(existingId);
        Assertions.assertNotNull(result);
    }

    // Teste do método findById retornando uma Exceção
    @Test
    public void findByIdDeveriaLancarUmaExcecao() {
        Assertions.assertThrows(EntityWineNotFoundException.class, () -> {
            service.searchById(nonExistingId);
        });
    }

    // Teste do método save
    @Test
    public void saveDeveriaPersistirNoBancoDeDados() {
        CategoryDto dto = categoryDto;
        dto.setId(null);
        dto = service.insert(dto);
        Assertions.assertNotNull(dto.getId());
    }

    // Teste do método update
    @Test
    public void updateDeveriaAtualizarUmRegistro() {
        CategoryDto result = service.update(existingId, categoryDto);
        Assertions.assertNotNull(result);
    }

    // Teste do método update com exceção
    @Test
    public void updateDeveriaLancarUmaExcecao() {
        Assertions.assertThrows(EntityWineNotFoundException.class, () -> {
            service.update(nonExistingId, categoryDto);
        });
    }

    // Teste do método delete
    @Test
    public void deleteDeveriaExcluirUmRegistro() {
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });
    }

    // Teste do método delete com exceção de recurso não encontrado
    @Test
    public void deleteDeveriaLancarUmaExcecao() {
        Assertions.assertThrows(EntityWineNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
    }

    // Teste do método delete com exceção de integridade do BD
    @Test
    public void deleteDeveriaLancarUmaViolacaoDeIntegridade() {
        Assertions.assertThrows(DatabaseWineException.class, () -> {
            service.delete(dependentId);
        });
    }
}
