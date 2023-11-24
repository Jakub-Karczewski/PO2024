package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private int width;
    private int height;
    HashMap<Vector2d, Animal> animals = new HashMap<>();
    public RectangularMap(int height, int width){
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position)){
            return false;
        }
        int x = position.getx();
        int y = position.gety();
        if(x >= 0 && x <= width-1 && y >= 0 && y <= height-1){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d val = animal.getPos();
        boolean valid = false;
        if(canMoveTo(val)){
            animals.put(val, animal);
            valid = true;
        }
        return valid;
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d prev = animal.getPos();
        Animal animal_test = new Animal(prev, animal.getOrient());
        animal_test.move(direction, this);
        if(!canMoveTo(animal_test.getPos())){
            return;
        }

        for (HashMap.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            Vector2d key = entry.getKey();
            Animal zwierzak = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + zwierzak);
        }
        animals.remove(prev);
        animal.move(direction, this);
        place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(!animals.containsKey(position)){
            return false;
        }
        return true;
    }

    @Override
    public Animal objectAt(Vector2d position) {

        if(isOccupied(position)){
            return animals.get(position);
        }
        return null;
    }
    @Override
    public String toString(){

        MapVisualizer drawing = new MapVisualizer(this);
        return drawing.draw(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }

    public HashMap<Vector2d, Animal> getAnimals() {
        return animals;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
