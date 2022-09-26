package br.com.ecommerce.services;

import br.com.ecommerce.dtos.CategoryDto;
import br.com.ecommerce.entities.Category;
import br.com.ecommerce.entities.Product;
import br.com.ecommerce.services.exceptions.DatabaseWineException;
import br.com.ecommerce.dtos.ProductDto;
import br.com.ecommerce.repositories.CategoryRepository;
import br.com.ecommerce.repositories.ProductRepository;
import br.com.ecommerce.services.exceptions.EntityWineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> searchAll() {
        try{
            List<Product> list = repository.findAll();
            return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
        } catch (EntityNotFoundException e){
            throw new EntityWineNotFoundException(
                    "Registros Não Encontrados!"
            );
        }
    }

    @Transactional(readOnly = true)
    public ProductDto  searchById(Integer id) {
        Optional<Product> object = repository.findById(id);
//        Product entity = object.get();
//        Faz o get e também trabalha exceção
        Product entity = object.orElseThrow(() -> new EntityWineNotFoundException("Registro: " + id + " Não Encontrado"));
        return new ProductDto(entity);
    }

    public void delete(Integer id) {
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new EntityWineNotFoundException(
                    "Exclusão não possível não realizada!" +
                            id + "Não encontrado!"

            );
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseWineException(
                    "Violação de integridade: Registro" +
                            id + "está em outro registro!"
            );
        }
    }

    @Transactional
    public ProductDto insert(ProductDto dto) {
        Product entity = new Product();
        copyDtoForEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDto(entity);
    }

    @Transactional
    public ProductDto update(Integer id, ProductDto dto) {
        try{
            Product entity = repository.getReferenceById(id);
            copyDtoForEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDto(entity);
        } catch (EntityNotFoundException e){
            throw new EntityWineNotFoundException(
                    "Registro" + id + "Não encontrado!"
            );
        }

    }

    private void copyDtoForEntity(ProductDto dto, Product entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setPrice(dto.getPrice());

        entity.getCategories().clear();
        for (CategoryDto endDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(endDto.getId());
            entity.getCategories().add(category);
        }
    }
}
