package br.com.fiap.application;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import br.com.fiap.domain.model.User;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserController {

    @GET
    @Path("/{id}")
    public User findUserById(String id) {
        return User.findById(new ObjectId(id));
    }

    @GET
    public List<User> listAllUsers() {
        return User.listAll();
    }

    @POST
    public Response create(User user) {
        user.persist();

        return Response.created(URI.create("/" + user.id)).build();
    }
}
