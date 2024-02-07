package agh.ics.oop.model;

public class ConsoleMapDisplay {
    private int operations;
    private int ID;

    public ConsoleMapDisplay(int ID){
        this.ID = ID;
    }
    void MapChanged(WorldMap mapa, String message){
        System.out.print(mapa.toString());
        System.out.print(message);
        System.out.printf("Number of operations:", operations);
        operations += 1;
    }

    public int getID() {
        return ID;
    }
}
