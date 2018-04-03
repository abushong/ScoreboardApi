package edu.lvc.cds.rest;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> userDb = new ArrayList<User>();
    private int userId = 100;

    public int setId(){
        userId += 3;
        return userId;
    }

    public void addUser(User u){
        userDb.add(u);
    }

    public User getUser(int id){
        for(User u : userDb){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return userDb;
    }
}
