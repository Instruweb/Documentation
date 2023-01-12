package com.instruweb.service;

import com.instruweb.domain.User;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
public class UserServiceTest {
    @Inject
    UserService userService;

    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    void testGetUserByUsername() {
        // Arrange
        String username = "nickwelles";

        // Act
        User getUser = userService.getUser(username);

        // Assert
        Assertions.assertEquals(username, getUser.getUsername());
    }

    @Test
    void testCheckIfUserAlreadyExists() {
        // Arrange
        String username = "nickwelles";

        // Act
        boolean isUser = userService.checkIfUserExists(username);

        // Assert
        Assertions.assertTrue(isUser);
    }

    @Test
    @Transactional
    void testRegisterNewUser() {
        // Arrange
        User user = new User();

        user.setUsername("newUser");
        user.setEmailaddress("newuser@instruweb.com");
        user.setAddress("Testweg 1");
        user.setPostalcode("1234AB");
        user.setPhonenumber("0612345678");

        // Act
        User registeredUser = userService.registerUser(user.getUsername(), user.getEmailaddress());

        // Assert
        Assertions.assertEquals(registeredUser.getEmailaddress(), user.getEmailaddress());
    }

    @Test
    @TestSecurity(user = "nickwelles", roles = "user")
    @Transactional
    void testUpdateUser() {
        // Arrange
        String username = "nickwelles";

        String userAddress = "Bierweg 34";
        String userPostalcode = "4321BA";
        String userPhonenumber = "0687654321";

        String expectedMessage = "{\"message\": \"User succesfully updated.\"}";

        // Act
        String updateUser = userService.UpdateUser(username, userAddress, userPostalcode, userPhonenumber);

        // Assert
        Assertions.assertEquals(expectedMessage, updateUser);
    }
}
