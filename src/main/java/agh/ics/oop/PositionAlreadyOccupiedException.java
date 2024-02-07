package agh.ics.oop;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d vec){
        super(String.format("Position (%s, %s) is already occupied.", vec.getx(), vec.gety()));
    }

}
