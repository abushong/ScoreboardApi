package edu.lvc.cds.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HiThere {

    public String buildJson(){

        JsonObject dog = new JsonObject();
        dog.addProperty("name","mike");
        dog.addProperty("size","smol");
        dog.addProperty("age", 4000);

        Gson gson = new GsonBuilder().create();
        return "HEY! " + gson.toJson(dog);
    }

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        String s = buildJson();
        return "Hello World" + s;
    }
}
