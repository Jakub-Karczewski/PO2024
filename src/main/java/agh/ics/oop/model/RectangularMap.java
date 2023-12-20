package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{


    @Override
    public String toString(){
        MapVisualizer drawing = new MapVisualizer(this,  new RectangularMap());
        return drawing.draw();
    }


    public void move(WorldElement stwor, MoveDirection direction){
        Vector2d prev = stwor.getPos();
        Animal animal_test = new Animal(prev, stwor.getOrient());
        animal_test.move(direction, this);
        if(!canMoveTo(animal_test.getPos())){
            return;
        }
        elements.remove(prev);
        stwor.move(direction, this);
        place(stwor);
    }
}
