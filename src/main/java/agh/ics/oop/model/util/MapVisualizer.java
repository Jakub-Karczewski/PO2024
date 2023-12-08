package agh.ics.oop.model.util;

import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldElement;
import agh.ics.oop.model.WorldMap;

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
    private final AbstractWorldMap animals;
    private final AbstractWorldMap grass;

    /**
     * Initializes the MapVisualizer with an instance of map to visualize.
     *
     * @param  animals
     * @param grass
     */
    public MapVisualizer(AbstractWorldMap animals, AbstractWorldMap grass) {

        this.animals = animals;
        this.grass = grass;
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
    public Vector2d[] calculateBorder(HashMap<Vector2d, WorldElement> zbior){
        int max_x = Integer.MIN_VALUE, min_x = Integer.MAX_VALUE, max_y = Integer.MIN_VALUE, min_y = Integer.MAX_VALUE;
        for (HashMap.Entry <Vector2d, WorldElement> entry : zbior.entrySet()){
            Vector2d key = entry.getKey();
            int x = key.getx(), y = key.gety();
            max_x = Math.max(max_x, x); min_x = Math.min(min_x, x);
            max_y = Math.max(max_y, y); min_y = Math.min(min_y, y);

        }
        Vector2d[] limits = {new Vector2d(min_x, min_y), new Vector2d(max_x, max_y)};
        return limits;
    }
    public String draw() {
        Vector2d[] anim_lim = calculateBorder(this.animals.getElements());
        Vector2d[] grass_lim = calculateBorder(this.grass.getElements());
        int xmin = Math.min(anim_lim[0].getx(), grass_lim[0].getx()), ymin = Math.min(anim_lim[0].gety(), grass_lim[0].gety());
        int xmax = Math.max(anim_lim[1].getx(), grass_lim[1].getx()), ymax = Math.max(anim_lim[1].gety(), grass_lim[1].gety());
        Vector2d lowerLeft = new Vector2d(xmin, ymin), upperRight = new Vector2d(xmax, ymax);
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
        } else {
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
        if (this.animals.isOccupied(currentPosition)) {
            Object object1 = this.animals.objectAt(currentPosition);
            if (object1 != null) {
                return object1.toString();
            }
        }
        if(this.grass.isOccupied(currentPosition)){
            return this.grass.objectAt(currentPosition).toString();
        }
        return EMPTY_CELL;
    }
}