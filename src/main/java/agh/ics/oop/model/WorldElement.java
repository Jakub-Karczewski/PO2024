package agh.ics.oop.model;

public interface WorldElement {
    public String toString();
    public Vector2d getPos();
    public MapDirection getOrient();
    public void move(MoveDirection direction, MoveValidator JD);

}
