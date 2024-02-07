package agh.ics.oop.model;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;
    public String toString() {
        String conv = switch (this) {
            case EAST -> "Wschod";
            case NORTH -> "Polnoc";
            case WEST -> "Zachod";
            case SOUTH -> "Wschod";
            default -> "Polnoc";
        };
        return conv;
    }

    public MapDirection next (){
        MapDirection nowy = switch(this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            default -> NORTH;
        };
        return nowy;
    }

    public MapDirection previous(){
        MapDirection res = switch(this){
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            default -> NORTH;
        };
        return res;

    }

    public Vector2d toUnitVector(MapDirection orient){
        Vector2d unit = switch(orient){
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            default -> new Vector2d(0, 1);
        };
        return unit;
    }
}
