package com.instruweb.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instruweb.domain.User;
import com.instruweb.service.UserService;
import io.quarkus.security.Authenticated;

import java.net.URI;

@Path("/api/users")
@Authenticated
public class UserResource {

    @Inject
    UserService userService;

    public UserResource(){}

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(String username) {
        return userService.getUser(username);
    }

    @POST
    @Path("/register/{username}/{emailaddress}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(String username, String emailaddress) {
        User user = userService.registerUser(username, emailaddress);
        return Response.created(URI.create("/api/users/register/" + user.getId())).build();
    }

    @PUT
    @Path("/update/{username}/{postalcode}/{address}/{phonenumber}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateUser(String username, String postalcode, String address, String phonenumber) {
        return userService.UpdateUser(username, address, postalcode, phonenumber);
    }
}
