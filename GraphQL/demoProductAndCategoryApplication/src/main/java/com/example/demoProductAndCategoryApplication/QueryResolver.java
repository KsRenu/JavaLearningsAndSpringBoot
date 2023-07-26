package com.example.demoProductAndCategoryApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Controller;

//@Component
@Controller
//public class QueryResolver implements GraphQLQueryResolver {
public class QueryResolver{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @QueryMapping
    public List<Category> allCategories() {
        return this.categoryRepository.findAll();
    }

    @QueryMapping
    public List<Product> allProducts() {
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Category category(@Argument Integer id) {
        return this.categoryRepository.findById(id).orElseGet(null);
    }

    @QueryMapping
    public Product product(@Argument Integer id) {
        return this.productRepository.findById(id).orElseGet(null);
    }

}
