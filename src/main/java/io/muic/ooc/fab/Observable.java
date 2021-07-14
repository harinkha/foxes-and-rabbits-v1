package io.muic.ooc.fab;

import java.util.ArrayList;
import java.util.List;


public abstract class Observable {

    private List<Observer> observers = new ArrayList<>();

    public final void addObserver(Observer observer){
        observers.add(observer);
    }

    public final void notifyAllObservers(int step, Field field){
        for(Observer o: observers){
            o.update(step, field);
        }
    }
}
