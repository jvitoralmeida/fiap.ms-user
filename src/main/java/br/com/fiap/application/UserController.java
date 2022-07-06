package br.com.fiap.application;

import br.com.fiap.domain.model.Auth;
import br.com.fiap.domain.model.User;
import br.com.fiap.domain.model.UserLogin;
import br.com.fiap.domain.repository.UserRepository;
import br.com.fiap.domain.services.UserService;
import io.quarkus.security.identity.SecurityIdentity;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
@Slf4j
public class UserController {

    private final SecurityIdentity securityIdentity;
    private final UserService userService;
    private final UserRepository repository;


    public UserController(SecurityIdentity securityIdentity, UserService userService, UserRepository repository) {
        this.securityIdentity = securityIdentity;
        this.userService = userService;
        this.repository = repository;
    }

    @GET
    @Path("/findById")
    @RolesAllowed({"user", "admin"})
    public Response findUserById() {

        var userOptional = repository.findByCpf(securityIdentity.getPrincipal().getName());
        if (userOptional.isPresent()) {
            return Response.ok(userOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @RolesAllowed("admin")
    public List<User> listAllUsers() {
        return repository.listAll();
    }

    @POST
    public Response create(User user) {

        Response response = userService.createNewUser(user);

        if (response.getStatus() == 200) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/authenticate")
    public Response authenticateUser(UserLogin user) {
        var response = userService.authenticateUser(user);

        if (response.getStatus() == 200) {
            var auth = response.readEntity(Auth.class);
            return Response.ok(auth).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
