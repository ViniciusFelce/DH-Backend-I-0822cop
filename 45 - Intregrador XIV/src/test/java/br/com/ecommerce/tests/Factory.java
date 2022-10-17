package br.com.ecommerce.tests;

import br.com.ecommerce.dtos.CategoryDto;
import br.com.ecommerce.entities.Category;

public class Factory {

    public static Category criarCategoria() {
        Category category = new Category(1, "Marketing");
        return category;
    }

    public static CategoryDto criarCategoriaDto() {
        Category category = criarCategoria();
        return new CategoryDto(category);
    }

}
