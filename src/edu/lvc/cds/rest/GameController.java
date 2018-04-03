package edu.lvc.cds.rest;

import com.google.gson.Gson;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;

@Path("/games")
public class GameController {

    private static GameManager gm = new GameManager();
    private static ScoreboardManager sm = new ScoreboardManager();
    private Gson gson = new Gson();

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getGames() {
        ArrayList<Game> games = gm.getGames();
        return Response.ok(games, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getGame(@PathParam("id") int id){
        Game g = gm.getGame(id);
        if(g != null)
            return Response.ok(g, MediaType.APPLICATION_JSON).build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("Game not found").build();
    }

    @POST
    @Consumes("application/json")
    public Response addGame(String str){
        Game g = gson.fromJson(str, Game.class);
        g.setId(gm.setId());
        gm.addGame(g);
        return Response.created(URI.create("/games/" + g.getId())).build();
    }

    @Path("/{id}/scoreboard")
    @POST
    @Consumes("application/json")
    public Response addScoreboard(String str, @PathParam("id") int id){
        Scoreboard s = gson.fromJson(str, Scoreboard.class);
        Game g = gm.getGame(id);
        s.setGame(g.getName());
        s.setId(sm.setId());
        sm.addScoreboard(s);
        return Response.created(URI.create("/games/" + g.getId() + "/scoreboard/" + s.getId())).build();
    }

    @Path("/scoreboard/{id}")
    @GET
    @Produces("application/json")
    public Response getScoreboard(@PathParam("id") int id){
        Scoreboard s = sm.getScoreboard(id);
        if(s != null)
            return Response.ok(s, MediaType.APPLICATION_JSON).build();
        else
            return Response.ok(Response.Status.NOT_FOUND).entity("Scoreboard not found").build();
    }

    @Path("/scoreboard")
    @GET
    @Produces("application/json")
    public Response getScoreboards(){
        ArrayList<Scoreboard> scores = sm.getScoreboards();
        return Response.ok(scores, MediaType.APPLICATION_JSON).build();
    }

}
