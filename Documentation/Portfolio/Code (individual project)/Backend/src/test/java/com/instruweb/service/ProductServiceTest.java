package com.instruweb.service;

import com.instruweb.domain.Product;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
public class ProductServiceTest {
    @Inject
    ProductService productService;

    @Test
    void testGetProductByName() {
        // Arrange
        String productName = "Gitaar";

        // Act
        Product product = productService.getProduct(productName);

        // Assert
        Assertions.assertEquals(productName, product.getName());
    }

    @Test
    void testGetProductById() {
        // Arrange
        Integer productId = 1;

        // Act
        Product product = productService.getProductById(productId);

        // Assert
        Assertions.assertEquals(productId, product.getId());
    }

    @Test
    @Transactional
    void testCreateNewProduct() {
        // Arrange
        Product insertProduct = new Product();

        insertProduct.setName("Test product");
        insertProduct.setDescription("Beschrijving van het test product");
        insertProduct.setPrice(11.59);
        insertProduct.setSupply("Full");
        insertProduct.setImage("gitaar.webp");
        insertProduct.setMain_categoryId(1);
        insertProduct.setSub_categoryId(1);

        // Act
        Product product = productService.createProduct(insertProduct);

        // Assert
        Assertions.assertEquals(insertProduct, product);
    }
}
