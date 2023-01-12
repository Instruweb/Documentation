package com.instruweb.resource;

import com.instruweb.domain.Product;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(ProductResource.class)
public class ProductResourceTest {
    @Test
    void testGetProductByName() {
        given()
                .when().get("Fender Gitaar")
                .then()
                .statusCode(200);
    }

    @Test
    void testGetProductById() {
        given()
                .when().get("/id/1")
                .then()
                .statusCode(200);
    }

    @Test
    void testGetProductsByMainCategoryId() {
        given()
                .when().get("/main_category/1")
                .then().statusCode(200);
    }

    @Test
    @TestSecurity(user = "admin", roles = "admin")
    void testCreateProduct() {
        final Product product = new Product();

        product.setName("Standaard Gitaar");
        product.setDescription("Een standaard gitaar met 6 snaren");
        product.setImage("gitaar.webp");
        product.setPrice(123.99);
        product.setSupply("Full");
        product.setMain_categoryId(1);
        product.setSub_categoryId(1);

        given()
                .body(product)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .post("/admin/create")
                .then()
                .statusCode(201);
    }
}
