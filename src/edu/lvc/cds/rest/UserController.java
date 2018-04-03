package edu.lvc.cds.rest;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

@Path("/users")
public class UserController {

    private static UserManager um = new UserManager();
    private Gson gson = new Gson();

    @GET
    @Produces("application/json")
    public Response getUsers(){
        ArrayList<User> users = um.getUsers();
        return Response.ok(users, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") int id){
        User u = um.getUser(id);
        if(u != null)
            return Response.ok(u, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
    }

    @POST
    @Consumes("application/json")
    public Response addUser(String str){
        User u = gson.fromJson(str, User.class);
        u.setId(um.setId());
        um.addUser(u);
        return Response.created(URI.create("/users/" + u.getId())).build();
    }
}
