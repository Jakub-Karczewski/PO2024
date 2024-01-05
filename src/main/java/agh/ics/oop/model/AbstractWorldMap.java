package agh.ics.oop.model;

import agh.ics.oop.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    private Boundary bonds = new Boundary(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE), new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE));
    protected HashMap<Vector2d, Animal> animals = new HashMap<>();
    protected HashMap<Vector2d, Grass> grass = new HashMap<>();
    private HashMap<Integer, ConsoleMapDisplay> Observators = new HashMap<>();

    private int ID;

    public AbstractWorldMap(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public HashMap<Vector2d, Grass> getGrass() {
        return grass;
    }

    public void actualize_bonds(int x1, int y1){
        Boundary act_border = getCurrentBonds();
        int xp = act_border.start().getx(); int yp = act_border.start().gety();
        int xk = act_border.koniec().getx(); int yk = act_border.koniec().gety();
        if(x1 < xp) {
            xp = x1;
        }
        if(x1 > xk){
            xk = x1;
        }
        if(y1 < yp){
            yp = y1;
        }
        if(y1 > yk){
            yk = y1;
        }
        this.setBonds(new Boundary(new Vector2d(xp, yp), new Vector2d(xk, yk)));
    }


    public boolean place(Animal stwor) {
        Vector2d val = stwor.getPos();
        boolean valid = false;
        try{
            if(canMoveTo(val)){
                actualize_bonds(val.getx(), val.gety());
                animals.put(val, stwor);
                valid = true;
                MapChanged("dodano nowego zwierzaka");
            }
        }
        catch(PositionAlreadyOccupiedException JD){
             JD.printStackTrace();
        }
        return valid;
    }

    public void move(WorldElement stwor, MoveDirection direction){
        Vector2d prev = stwor.getPos();
        Animal animal_test = new Animal(prev, stwor.getOrient());
        animal_test.move(direction, this);
        try {
            if (!canMoveTo(animal_test.getPos())) {
                return;
            }
        }
        catch(PositionAlreadyOccupiedException JD){
            JD.printStackTrace();
        }
        animals.remove(prev);
        stwor.move(direction, this);
        place(stwor);
        MapChanged("zwierzak poruszył się");
    }

    public WorldElement objectAt(Vector2d position) throws PositionAlreadyOccupiedException{
        if(isOccupied(position)){
            return animals.get(position);
        }
        return null;
    }
    public boolean isOccupied(Vector2d position) throws PositionAlreadyOccupiedException {
        if(animals.containsKey(position)){
            throw new PositionAlreadyOccupiedException(position);
        }
        return (animals.containsKey(position));
    }

    public HashMap<Vector2d, Animal> getAnimals() {
        return animals;
    }

    public boolean canMoveTo(Vector2d position) throws PositionAlreadyOccupiedException {
        return (!isOccupied(position));
    }

    public Boundary getCurrentBonds() {
        return bonds;
    }

    public void setBonds(Boundary bonds) {
        this.bonds = bonds;
    }

    public String toString(){
        Boundary limit = getCurrentBonds();
        MapVisualizer drawing = new MapVisualizer(this.getAnimals(), this.getGrass() , limit);
        return drawing.draw();
    }

    public HashMap<Integer, ConsoleMapDisplay> getObservators() {
        return Observators;
    }

    public void add_observators(ConsoleMapDisplay obs){
        this.Observators.put(Integer.valueOf(obs.getID()), obs);
    }

    public void remove_observators(ConsoleMapDisplay obs){
        this.Observators.remove(Integer.valueOf(obs.getID()));
    }

    public void MapChanged(String message){
        //System.out.println("Jestem w MapChanged");
        for(Map.Entry<Integer, ConsoleMapDisplay> entry : Observators.entrySet()) {
            ConsoleMapDisplay obs = entry.getValue();
            obs.MapChanged(this, message);
        }
    }



}
