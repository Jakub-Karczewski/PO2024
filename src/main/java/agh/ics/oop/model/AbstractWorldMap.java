package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected HashMap<Vector2d, WorldElement> elements = new HashMap<>();
    public boolean place(WorldElement stwor) {
        Vector2d val = stwor.getPos();
        boolean valid = false;
        if(!isOccupied(val)){
            elements.put(val, stwor);
            valid = true;
        }
        return valid;
    }
    public WorldElement objectAt(Vector2d position) {
        if(isOccupied(position)){
            return elements.get(position);
        }
        return null;
    }
    public boolean isOccupied(Vector2d position) {
        return (elements.containsKey(position));
    }
    public HashMap<Vector2d, WorldElement> getElements() {
        return elements;
    }

    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

}
