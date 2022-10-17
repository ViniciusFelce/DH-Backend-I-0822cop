package br.com.ecommerce.controllers;

import br.com.ecommerce.dtos.CategoryDto;
import br.com.ecommerce.services.CategoryService;
import br.com.ecommerce.services.exceptions.DatabaseWineException;
import br.com.ecommerce.services.exceptions.EntityWineNotFoundException;
import br.com.ecommerce.tests.Factory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Integer existingId;
    private Integer nonExistingId;
    private Integer dependentId;
    private CategoryDto categoryDto;
    private List<CategoryDto> list;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1;
        nonExistingId = 999;
        dependentId = 2;
        categoryDto = Factory.criarCategoriaDto();
        list = new ArrayList<>();

        // Mock do findAll
        when(service.searchAll()).thenReturn(list);

        // Mock do findById
        when(service.searchById(existingId)).thenReturn(categoryDto);
        when(service.searchById(nonExistingId)).
                thenThrow(EntityWineNotFoundException.class);

        // Mock do save
        when(service.insert(any())).thenReturn(categoryDto);

        // Mock do update
        when(service.update(eq(existingId), any())).thenReturn(categoryDto);
        when(service.update(eq(nonExistingId), any())).
                thenThrow(EntityWineNotFoundException.class);

        // Mock do delete
        doNothing().when(service).delete(existingId);
        // Mock do delete com Excepion de Entidade não encontrada
        doThrow(EntityWineNotFoundException.class).when(service).delete(nonExistingId);
        // Mock do delete com Excepion de violação de integridade
        doThrow(DatabaseWineException.class).when(service).delete(dependentId);
    }

    // Teste do método findAll
    @Test
    public void findAllDeveriaRetornarUmaLista() throws Exception {
        ResultActions result = mockMvc.perform(get("/categories")
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }

    // Teste do método findById
    @Test
    public void findByIdDeveriaRetornarUmDto() throws Exception {
        ResultActions result = mockMvc.perform(get("/categories/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").exists());
    }

    // Teste do método findById retornando uma Exceção
    @Test
    public void findByIdDeveriaDeveriaRetornarUm404() throws Exception {
        ResultActions result = mockMvc.perform(get("/categories/{id}", nonExistingId)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    // Teste do método save
    @Test
    public void insertDeveriaRetornarUm201CategoryDto() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(categoryDto);

        ResultActions result = mockMvc.perform(post("/categories")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").exists());
    }

    // Teste do método update
    @Test
    public void updateDeveriaRetornarUm200QuandoOIdExistir() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(categoryDto);

        ResultActions result = mockMvc.perform(put("/categories/{id}", existingId)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").exists());
    }

    // Teste do método update com exceção
    @Test
    public void updateDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(categoryDto);

        ResultActions result = mockMvc.perform(put("/categories/{id}", nonExistingId)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    // Teste do método delete
    @Test
    public void deleteDeveriaRetornarUm204QuandoOIdExistir() throws Exception {
        ResultActions result = mockMvc.perform(delete("/categories/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNoContent());
    }

    // Teste do método delete com exceção de recurso não encontrado
    @Test
    public void deleteDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions result = mockMvc.perform(delete("/categories/{id}", nonExistingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }
}
