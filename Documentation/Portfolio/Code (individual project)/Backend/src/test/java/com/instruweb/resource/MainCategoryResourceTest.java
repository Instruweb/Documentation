package com.instruweb.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(MainCategoryResource.class)
public class MainCategoryResourceTest {
    @Test
    void testGetCategoryByName() {
        given()
                .when().get("/Gitaren")
                .then()
                .statusCode(200);
    }

    @Test
    void testGetAllCategories() {
        given()
                .when().get("/")
                .then()
                .statusCode(200);
    }

    @Test
    void testGiveErrorWhenWrongCategory() {
        given()
                .when().get("/Een eend")
                .then()
                .statusCode(404);
    }
}
