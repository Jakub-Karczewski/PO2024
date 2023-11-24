package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("start");
        String[] tabl = {"F", "B", "R", "L", "F", "F", "R", "R", "F", "F", "L", "L", "L", "F", "F", "F", "F", "F", "F", "F",  "F"};
        WorldMap mapeczka = new RectangularMap(5, 5);
        List<MoveDirection> directions = OptionParser.parse(tabl);
        System.out.println(directions);
        run(OptionParser.parse(tabl));
        System.out.println("stop");
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation (positions, directions, mapeczka);
        simulation.run();

    }
    public static void run(List<MoveDirection> args)
    {
        //System.out.println("start");
        for(int i = 0; i < args.size(); i++)
        {
            MoveDirection moves = args.get(i);
            switch(moves) {
                case FORWARD:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("zwierzak zakreca w prawo");
                    break;
                case LEFT:
                    System.out.println("zwierzak zakreca w lewo");
                    break;
            }
        }
    }
}
