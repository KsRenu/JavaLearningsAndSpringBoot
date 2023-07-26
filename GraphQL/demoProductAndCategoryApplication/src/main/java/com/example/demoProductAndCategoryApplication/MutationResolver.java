package com.example.demoProductAndCategoryApplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Controller;


@Slf4j

//@Component
@Controller
//public class MutationResolver implements GraphQLMutationResolver {
    public class MutationResolver{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @MutationMapping
    //public Category addCategory(String name) {
        public Category addCategory(@Argument String name) {
        log.info("Adding a Category to the database");
        Category category = new Category();
        category.setName(name);

        return this.categoryRepository.saveAndFlush(category);
    }

    @MutationMapping
    public Product addProduct(@Argument String name,@Argument String code,@Argument Double price,@Argument Integer category_id) {
        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);
        product.setCategory(category);

        return this.productRepository.saveAndFlush(product);
    }
    @MutationMapping
    public Category updateCategory(@Argument Integer id,@Argument String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return this.categoryRepository.saveAndFlush(category);
    }
    @MutationMapping
    public Product updateProduct(@Argument Integer id,@Argument String name,  @Argument String code,@Argument Double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);

        return this.productRepository.saveAndFlush(product);
    }
    @MutationMapping
    public Boolean deleteCategory(@Argument Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }
    @MutationMapping
    public Boolean deleteProduct(@Argument Integer id) {
        productRepository.deleteById(id);
        return true;
    }

}
