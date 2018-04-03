package edu.lvc.cds.rest;

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Game> gameDb = new ArrayList<>();
    private int gameId = 100;

    public int setId(){
        gameId += 3;
        return gameId;
    }


    public GameManager(){
        Game g1 = new Game();
        g1.setId(10);
        g1.setName("Pubg");
        gameDb.add(g1);
    }

    public String getName(Game g){
        return g.getName();
    }

    public void addGame(Game g){
        gameDb.add(g);
    }

    public ArrayList<Game> getGames(){
        return gameDb;
    }

    public Game getGame(int id){
        for(Game g : gameDb){
            if(g.getId() == id){
                return g;
            }
        }
        return null;
    }

}
