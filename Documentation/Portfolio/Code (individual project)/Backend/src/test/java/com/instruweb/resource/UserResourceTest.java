package com.instruweb.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import io.quarkus.test.security.TestSecurity;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {
    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    void testGetUserByUsername() {
        given()
                .when().get("/nickwelles")
                .then()
                .statusCode(200);
    }

    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    void testRegisterNewUser() {
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .post("/register/testusername/test@emailaddress.com")
                .then()
                .statusCode(201);
    }

    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    void testUpdateUser() {
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .put("/update/nickwelles/5123PC/Testlaan 1/0612345678")
                .then()
                .statusCode(200);
    }

    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    void testUpdateAnotherUser() {
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .put("/update/anotherusername/5123PC/Testlaan 1/0612345678")
                .then()
                .statusCode(401);
    }
}
