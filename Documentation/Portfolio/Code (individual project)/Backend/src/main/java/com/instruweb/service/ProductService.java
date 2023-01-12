package com.instruweb.service;

import com.instruweb.domain.Product;
import com.instruweb.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public ProductService() {}

    public Product getProduct(String name) {
        Product product = productRepository.find("name", name).firstResult();

        if (product == null) {
            throw new NotFoundException();
        }

        return product;
    }

    public Product getProductById(Integer id) {
        Product product = productRepository.find("id", id).firstResult();

        if (product == null) {
            throw new NotFoundException();
        }

        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.listAll();

        if (productList == null) {
            throw new NotFoundException();
        }

        return productList;
    }

    public List<Product> getAllProductsByMainCategoryId(Integer id) {
        List<Product> productList = productRepository.find("main_categoryId", id).list();

        if (productList == null) {
            throw new NotFoundException();
        }

        return productList;
    }

    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }

        productRepository.persist(product);

        return product;
    }
}
