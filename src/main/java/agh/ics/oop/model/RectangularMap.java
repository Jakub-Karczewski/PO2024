package agh.ics.oop.model;

import agh.ics.oop.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    int height;
    int width;

    public RectangularMap(int height, int width, int ID){
        super(ID);
        this.height = height;
        this.width = width;
    }


    @Override
    public boolean canMoveTo(Vector2d position) throws PositionAlreadyOccupiedException{
        int x = position.getx(); int y = position.gety();
        if(x < 0 || x > width || y < 0 || y > height){
            throw new PositionAlreadyOccupiedException(position);
        }
        return super.canMoveTo(position);
    }

    @Override
    public Boundary getCurrentBonds(){
        return new Boundary(new Vector2d(0 , 0), new Vector2d(width, height));
    }

    @Override
    public boolean place(WorldElement stwor) {
        return false;
    }

}
