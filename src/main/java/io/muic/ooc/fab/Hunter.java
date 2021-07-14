package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter implements Actor {
    // The hunter's field.
    private Field field;
    // The hunter's position in the field.
    private Location location;

    public Hunter(Field field, Location newLocation) {
        this.field = field;
        setLocation(newLocation);
    }

    @Override
    public void act(List<Actor> newActors) {
        Location newLocation = findPrey();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(location);
        }
        // See if it was possible to move.
        if (newLocation != null) {
            setLocation(newLocation);
        }
        if (newLocation != null) {
            setLocation(newLocation);
        }

    }

    @Override
    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    private Location findPrey() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }
            if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            }
            if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }

        }
        return null;
    }

}



