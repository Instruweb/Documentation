package com.instruweb.service;

import com.instruweb.domain.User;
import com.instruweb.repository.UserRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.security.UnauthorizedException;
import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    SecurityIdentity securityIdentity;

    public UserService() {}

    public User getUser(String username) {
        if (!securityIdentity.getPrincipal().getName().equals(username))
        {
            throw new UnauthorizedException();
        }

        User user = userRepository.find("username", username).firstResult();

        if (user == null) {
            throw new NotFoundException();
        }

        return user;
    }

    public boolean checkIfUserExists(String username)
    {
        long count = userRepository.find("#User.getByUsername", Parameters.with("username", username)).count();

        return count != 0;
    }

    public User registerUser(String username, String emailaddress) {
        User user = new User();

        user.setUsername(username);
        user.setEmailaddress(emailaddress);

        userRepository.persist(user);

        return user;
    }

    public String UpdateUser(String username, String address, String postalcode, String phonenumber) {
        if (!securityIdentity.getPrincipal().getName().equals(username))
        {
            throw new UnauthorizedException();
        }

        if (!this.checkIfUserExists(username)) {
            return "{\"message\": \"User doesn't exist.\"}";
        }

        try {
            userRepository.update("#User.updateUser", Parameters.with("username", username).and("postalcode", postalcode).and("address", address).and("phonenumber", phonenumber));
            return "{\"message\": \"User succesfully updated.\"}";
        } catch(Exception ex) {
            return String.format("{\"message\": \"%s\"}", ex.getMessage());
        }
    }
}
