package edu.lvc.cds.rest;

import java.util.ArrayList;

public class ScoreboardManager {
    ArrayList<Scoreboard> scoreboardDb = new ArrayList<Scoreboard>();
    private int scoreboardId = 100;

    public int setId(){
        scoreboardId += 3;
        return scoreboardId;
    }

    public void addScoreboard(Scoreboard s){
        scoreboardDb.add(s);
    }

    public Scoreboard getScoreboard(int id){
        for(Scoreboard s : scoreboardDb){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Scoreboard> getScoreboards() {
        return scoreboardDb;
    }
}
