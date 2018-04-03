package edu.lvc.cds.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> oneShot = new HashSet<>();

    public MyApplication(){
        singletons.add(new HiThere());
        singletons.add(new GameController());
        //oneShot.add(HiThere.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }

    /*@Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }*/
}

