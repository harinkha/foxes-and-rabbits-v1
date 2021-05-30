package io.muic.ooc.fab;

import java.util.List;

public interface Actor {
    void act(List<Actor> newActors);
    void setLocation(Location newLocation);
}
