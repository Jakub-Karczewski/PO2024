package agh.ics.oop.model.util;

import agh.ics.oop.PositionAlreadyOccupiedException;
import agh.ics.oop.model.*;

import java.util.HashMap;

/**
 * The map visualizer converts the {@link WorldMap} map into a string
 * representation.
 *
 * @author apohllo, idzik
 */
public class MapVisualizer {
    private static final String EMPTY_CELL = " ";
    private static final String FRAME_SEGMENT = "-";
    private static final String CELL_SEGMENT = "|";
    private final HashMap<Vector2d, Animal> animals;
    private final HashMap<Vector2d, Grass> grass;
    private final Boundary Border;

    /**
     * Initializes the MapVisualizer with an instance of map to visualize.
     *
     * @param  animals
     * @param grass
     * .
     */
    public MapVisualizer(HashMap<Vector2d, Animal> animals, HashMap<Vector2d, Grass> grass, Boundary Border) {
        for(HashMap.Entry<Vector2d, Animal> entry : animals.entrySet()){
            Vector2d key = entry.getKey(); Animal value = entry.getValue();
            //System.out.print(value.getPos().getx()); System.out.print(" ");
            //System.out.print(value.getPos().gety());
            //System.out.println();
        }
        //System.out.println(Border.toString());

        this.animals = animals;
        this.grass = grass;
        this.Border = Border;
    }

    /**
     * Convert selected region of the map into a string. It is assumed that the
     * indices of the map will have no more than two characters (including the
     * sign).
     *
     * @  The lower left corner of the region that is drawn.
     *  The upper right corner of the region that is drawn.
     * @return String representation of the selected region of the map.
     */

    public String draw() {
        Vector2d lowerLeft = Border.start();
        Vector2d upperRight = Border.koniec();
        StringBuilder builder = new StringBuilder();
        for (int i = upperRight.gety() + 1; i >= lowerLeft.gety() - 1; i--) {
            if (i == upperRight.gety() + 1) {
                builder.append(drawHeader(lowerLeft, upperRight));
            }
            builder.append(String.format("%3d: ", i));
            for (int j = lowerLeft.getx(); j <= upperRight.getx() + 1; j++) {
                if (i < lowerLeft.gety() || i > upperRight.gety()) {
                    builder.append(drawFrame(j <= upperRight.getx()));
                } else {
                    builder.append(CELL_SEGMENT);
                    if (j <= upperRight.getx()) {
                        builder.append(drawObject(new Vector2d(j, i)));
                    }
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private String drawFrame(boolean innerSegment) {
        if (innerSegment) {
            return FRAME_SEGMENT + FRAME_SEGMENT;
        }
        else {
            return FRAME_SEGMENT;
        }
    }

    private String drawHeader(Vector2d lowerLeft, Vector2d upperRight) {
        StringBuilder builder = new StringBuilder();
        builder.append(" y\\x ");
        for (int j = lowerLeft.getx(); j < upperRight.gety() + 1; j++) {
            builder.append(String.format("%2d", j));
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    private String drawObject(Vector2d currentPosition) {
        if (this.animals.containsKey(currentPosition)) {
            Object object1 = this.animals.get(currentPosition);
            if (object1 != null) {
                return object1.toString();
            }
        }
        if (this.grass != null && this.grass.containsKey(currentPosition)) {
            return this.grass.get(currentPosition).toString();
        }
        return EMPTY_CELL;
    }
}