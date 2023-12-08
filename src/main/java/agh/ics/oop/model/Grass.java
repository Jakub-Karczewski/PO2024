package agh.ics.oop.model;

public class Grass implements WorldElement{
    private Vector2d pos;
    public Grass(Vector2d where){
        this.pos = where;
    }
    public Vector2d getPos(){
        return this.pos;
    }
    @Override
    public MapDirection getOrient() {
        return MapDirection.NORTH;
    }
    public void move(MoveDirection direction, MoveValidator JD) {
        return;
    }
    @Override
    public String toString() {
        return "*";
    }


}
