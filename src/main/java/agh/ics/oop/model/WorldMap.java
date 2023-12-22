package agh.ics.oop.model;
import agh.ics.oop.PositionAlreadyOccupiedException;
import agh.ics.oop.model.WorldElement;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap extends MoveValidator {

    /**
     * Place a animal on the map.
     *
     * @param stwor The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    public boolean place(WorldElement stwor);


    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    public boolean isOccupied(Vector2d position) throws PositionAlreadyOccupiedException;

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param direction Position to check.
     * @return True if the position is occupied.
     */

    /**
     * Return an animal at a given position.
     *
     * @param position The position of the animal.
     * @return animal or null if the position is not occupied.
     */
    WorldElement objectAt(Vector2d position) throws PositionAlreadyOccupiedException;
    public String toString();
}
