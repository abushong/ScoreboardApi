package edu.lvc.cds.rest;

import java.util.ArrayList;

public class Scoreboard {

    private int id = 100;
    private String game = "Not Defined";
    private ArrayList<String> columns = new ArrayList<>();

    public void setId(int id){
        this.id = id;
    }

    public void setGame(String g){
        game = g;
    }

    public int getId(){
        return id;
    }

    public void addColumns(ArrayList<String> col){
        if(col.size() != 0) {
            for (String s : col) {
                columns.add(s);
            }
        }
        else
            System.out.println("No columns to be added to scoreboard");
    }
}
