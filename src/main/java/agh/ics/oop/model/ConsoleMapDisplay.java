package agh.ics.oop.model;

public class ConsoleMapDisplay {
    private int operations = 0;
    private int ID;

    public ConsoleMapDisplay(int ID){
        this.ID = ID;
    }
    public void MapChanged(WorldMap mapa, String message){
        System.out.println(mapa.toString());
        System.out.println(message);
        System.out.print("Liczba operacji: ");
        System.out.println(operations);
        operations += 1;
    }


    public int getID() {
        return ID;
    }
}
