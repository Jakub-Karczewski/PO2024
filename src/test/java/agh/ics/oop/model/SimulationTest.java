package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulationTest {
    @Test
    public void simtest(){
        String[] moves = {"F", "F", "F", "B", "B", "B", "L", "F", "L", "F", "F", "B"};
        RectangularMap zwierz_pocz = new RectangularMap();
        Vector2d v1 = new Vector2d(2, 3), v2 = new Vector2d(3, 4), v3 = new Vector2d(6, 8);
        List<Vector2d> start = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int x = i+2, y = 2*i-5;
            start.add(new Vector2d(x, y));
        }
        WorldElement z1 = new Animal(v1, MapDirection.NORTH), z2 = new Animal(v2, MapDirection.EAST);
        Animal z3 = new Animal(v3, MapDirection.SOUTH);
        GrassField trawka = new GrassField(5);
        List<WorldElement> animals = List.of(z1, z2, z3);
        for (int i = 0; i < 3; i++){
            zwierz_pocz.place(animals.get(i));
        }
        List<Vector2d> positions = List.of(new Vector2d(2,2),
                new Vector2d(3,4), new Vector2d(7, 10), new Vector2d (7, 5));

       List<MoveDirection> moves_parsed = OptionParser.parse(moves);
       Simulation JD = new Simulation(start, moves_parsed, zwierz_pocz, trawka);
       RectangularMap done = JD.get_animals();
       JD.run();
       List<Vector2d> lista = new ArrayList<>();
       for(Map.Entry<Vector2d, WorldElement> entry : done.getElements().entrySet()) {
           Vector2d key = entry.getKey();
           lista.add(key);
       }
       System.out.println(lista);
       assertEquals(true, done.isOccupied(new Vector2d(6, 8)));
       assertEquals(true, done.isOccupied(new Vector2d(3, 4)));
       assertEquals(true, done.isOccupied(new Vector2d(2, 3)));
       assertEquals(true, done.isOccupied(new Vector2d(5, -3)));
       assertEquals(false, done.isOccupied(new Vector2d(5, 5)));

    }
}
